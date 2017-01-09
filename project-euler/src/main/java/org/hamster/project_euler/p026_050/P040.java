/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P040 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        // 1. need to understand which number it locates given d
        // (1 - 9) => num
        // (10 - 99) => 9 + 2 * num
        // (100 - 999) => 90 * 2 + 9 + 3 * num
        // (10^k - 99..k..999) => 9 + 90*2 + ... + 9 * n * 10^(k-1) + k * num
        double result = 1;
        for (int i = 0; i <= 6; i++) {
            double index = Math.pow(10, i);
            double[] bounds = new double[7];
            double offset = 0;
            for (int k = 1; k < bounds.length; k++) {
                double bound = 9 * k * Math.pow(10, k - 1);
                bounds[k] = offset + bound;
                offset += bound;
                if (index < bounds[k]) {
                    double prevBound = bounds[k - 1];
                    double number = Math.ceil((index - prevBound) / k) + Math.pow(10, k - 1) - 1;
                    int reminder = (int) ((index - prevBound) % k);
                    if (number == 1) { // safely ignore 1
                        break;
                    }
                    int digit = String.valueOf(number).toCharArray()[reminder - 1] - 48;
                    result *= digit;
                    break;
                }
            }
        }

        return result;
    }

}
