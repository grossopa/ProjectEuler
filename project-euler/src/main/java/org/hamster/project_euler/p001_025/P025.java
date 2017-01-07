/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P025 implements Solution {

    /**
     * Always divides current number till number &lt; 10 and store the digit count until the digits equals the required
     * number.
     * 
     */
    @Override
    public Number solution(double input) {
        double max = 10;

        double result = 0;
        double current = 0;
        double prev2 = 1;
        double prev1 = 0;

        int bufferredDigits = 1;

        while (bufferredDigits < input) {
            current = prev1 + prev2;
            result++;
            while (current >= max) {
                current /= 10;
                prev1 /= 10;
                prev2 /= 10;
                bufferredDigits++;
            }
            prev2 = prev1;
            prev1 = current;

        }

        return result;
    }

}
