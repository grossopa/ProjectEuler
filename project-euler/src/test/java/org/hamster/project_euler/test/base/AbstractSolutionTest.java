/**
 * 
 */
package org.hamster.project_euler.test.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.base.SolutionString;
import org.junit.Assert;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public abstract class AbstractSolutionTest<P extends Solution> {

    /**
     * test the give example
     */
    public abstract void testExample();

    /**
     * text the answer
     */
    public abstract void testSolution();
    
    /**
     * 
     * @return the problem class
     */
    public abstract Class<P> problemClass();

    /**
     * Invokes the <tt>solution</tt> method and verifies the result
     * 
     * @param expectedResult
     */
    public final void invoke(double expectedResult) {
        try {
            long t = System.currentTimeMillis();
            double r = problemClass().newInstance().solution();
            System.out.println("Result : " + r + " Time: " + (System.currentTimeMillis() - t) + " ms");
            Assert.assertEquals(expectedResult, r, 0.0001D);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Invokes <tt>solutionTest</tt> method and verifies the result
     * 
     * @param expectedResult
     * @param args
     */
    public final void invokeTest(double expectedResult, Object... args) {
        try {
            long t = System.currentTimeMillis();
            Method solutionTestMethod = null;
            for (Method ms : problemClass().getMethods()) {
                if (ms.getName() == "solutionTest") {
                    solutionTestMethod = ms;
                }
            }
            double r = (double) solutionTestMethod.invoke(problemClass().newInstance(), args);
            System.out.println("Test result : " + r + " Time: " + (System.currentTimeMillis() - t) + " ms");
            Assert.assertEquals(expectedResult, r, 0.0001D);
        } catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static final <T extends SolutionString> void invoke(Class<T> clazz, String expectedResult) {
        try {
            long t = System.currentTimeMillis();
            String r = clazz.newInstance().solution();
            System.out.println("Result : " + r + " Time: " + (System.currentTimeMillis() - t) + " ms");
            Assert.assertEquals(expectedResult, r);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
