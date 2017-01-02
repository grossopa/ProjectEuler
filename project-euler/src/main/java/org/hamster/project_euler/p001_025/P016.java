/**
 * 
 */
package org.hamster.project_euler.p001_025;

import java.math.BigInteger;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P016 implements Solution {

    /* 
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        BigInteger number = BigInteger.valueOf(2).pow((int) input);
        char[] numberStrs = number.toString().toCharArray();
        double result = 0;
        for (char str : numberStrs) {
            result += str - 48;
        }
        return result;
    }

}
