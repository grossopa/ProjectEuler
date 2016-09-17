/**
 * 
 */
package org.hamster.project_euler.base;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class SolutionUtils {

    public static final <T extends Solution> void invoke(Class<T> clazz, long expectedResult) {
        try {
            long t = System.currentTimeMillis();
            long r = clazz.newInstance().solution();
            System.out.println("Result : " + r + " Time: " + (System.currentTimeMillis() - t) + " ms");
            System.out.println("Result is " + (expectedResult == r ? " Correct" : " Incorrect"));
        } catch (InstantiationException | IllegalAccessException e) {
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
