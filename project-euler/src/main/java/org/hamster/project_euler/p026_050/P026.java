/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P026 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int maxDigitCycleCount = 0;
        int maxDigitCycleNumber = 0;

        for (int i = 2; i < input; i++) {
            int[] digits = new int[2000];
            int[] remainers = new int[2000];

            int index = 0;
            int number = 10;
            while (true) {

                short digit = 0;
                while (number >= i) {
                    number -= i;
                    digit++;
                }

                if (number == 0) {
                    break;
                }

                digits[index] = digit;
                remainers[index] = number;

                boolean foundCycle = false;
                for (int d = 0; d < index; d++) {
                    if (digits[d] == digit && remainers[d] == number) {
                        foundCycle = true;
                        if (maxDigitCycleCount < index - d) {
                            maxDigitCycleCount = index - d;
                            maxDigitCycleNumber = i;
                        }
                        break;
                    }
                }

                if (foundCycle) {
                    break;
                }

                number *= 10;
                index++;
            }

        }

        return maxDigitCycleNumber;
    }

}
