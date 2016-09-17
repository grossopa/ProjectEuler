/**
 * 
 */
package org.hamster.project_euler.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class SolutionUtils {

    public static final <T extends Solution> void invoke(Class<T> clazz, long expectedResult) {
        try {
            System.out.println("---------- Solution -----------");
            long t = System.currentTimeMillis();
            long r = clazz.newInstance().solution();
            System.out.println("Result : " + r + " Time: " + (System.currentTimeMillis() - t) + " ms");
            System.out.println("Result is " + (expectedResult == r ? " Correct" : " Incorrect"));
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static final <T extends Solution> void invokeSolutionTest(Class<T> clazz, long expectedResult, Object... args) {
        try {
            System.out.println("---------- Test ---------------");
            long t = System.currentTimeMillis();
            Method solutionTestMethod = null;
            for (Method ms : clazz.getMethods()) {
                if (ms.getName() == "solutionTest") {
                    solutionTestMethod = ms;
                }
            }
            long r = (long) solutionTestMethod.invoke(clazz.newInstance(), args);
            System.out.println("Test result : " + r + " Time: " + (System.currentTimeMillis() - t) + " ms");
            System.out.println("Test result is " + (expectedResult == r ? " Correct" : " Incorrect"));
            
        } catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static final <T extends SolutionString> void invoke(Class<T> clazz, String expectedResult) {
        try {
            long t = System.currentTimeMillis();
            String r = clazz.newInstance().solution();
            System.out.println("Result : " + r + " Time: " + (System.currentTimeMillis() - t) + " ms");
            System.out.println("Result is " + (expectedResult.equals(r) ? " Correct" : " Incorrect"));
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
