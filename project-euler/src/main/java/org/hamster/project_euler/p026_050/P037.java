/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;
import static org.hamster.project_euler.util.EulerMathUtils.digitCount;
import static org.hamster.project_euler.util.EulerMathUtils.isPrime;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P037 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int result = 23 + 37 + 53 + 73;
        int count = 4;
        int[] firstLasts = new int[] { 3, 7 };
        int[] middles = new int[] { 1, 3, 7, 9 };

        for (int m = 0; count < 11; m++) {
            int mt = m;
            double middle = 0;
            do {
                middle *= 10;
                middle += middles[mt % 4];
                mt *= .25;
            } while (mt > 0);

            for (int f = 0; f < 2; f++) {
                for (int l = 0; l < 2; l++) {
                    int fi = firstLasts[f];
                    int la = firstLasts[l];
                    double number = fi * Math.pow(10, digitCount(middle) + 1D) + middle * 10 + la;

                    boolean isTruncatable = true;
                    double num = number;
                    // left to right
                    do {
                        if (!isPrime(num)) {
                            isTruncatable = false;
                            break;
                        }
                        num = (num - (num % 10)) / 10;
                    } while (num > 0);

                    if (!isTruncatable) {
                        continue;
                    }

                    // right to left
                    num = number;
                    do {
                        if (!isPrime(num)) {
                            isTruncatable = false;
                        }
                        int subDigit = digitCount(num);
                        int subFirst = (int) (num / Math.pow(10, subDigit - 1D));
                        num -= subFirst * Math.pow(10, subDigit - 1D);
                    } while (num > 0);

                    if (isTruncatable) {
                        result += number;
                        count++;
                    }
                }
            }
        }

        return result;
    }

}
