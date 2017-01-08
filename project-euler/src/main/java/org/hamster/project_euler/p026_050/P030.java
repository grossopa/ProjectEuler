/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P030 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int powers = (int) input;

        int[] powerCache = new int[10];
        for (int i = 0; i < powerCache.length; i++) {
            powerCache[i] = (int) Math.pow(i, powers);
        }

        // terminate when 10 ^ digits larger than digits * 9 ^ powers
        double maxDigits = 2;
        while (Math.pow(10, maxDigits) <= maxDigits * Math.pow(9, powers)) {
            maxDigits++;
        }

        double result = 0;

        for (double num = 10; num <= Math.pow(10, maxDigits); num++) {
            double sum = 0;
            double currentNum = num;
            do {
                sum += powerCache[(int) (currentNum % 10)];
                currentNum = Math.floor(currentNum / 10);
            } while (currentNum > 0);

            if (Math.abs(sum - num) < 0.01D) {
                result += sum;
            }
        }

        return result;
    }

}
