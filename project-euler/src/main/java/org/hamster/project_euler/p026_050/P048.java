/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P048 implements Solution {

    private static final long MAX = 10_000_000_000L;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        long result = 0;
        for (int i = 1; i <= input; i++) {
            long pow = 1;
            for (int n = 1; n <= i; n++) {
                pow *= i;
                pow = cut(pow);
            }
            result += pow;
            result = cut(result);
        }
        return result;
    }

    private long cut(long number) {
        return number >= MAX ? (long) (number - Math.floor(number / MAX) * MAX) : number;
    }

}
