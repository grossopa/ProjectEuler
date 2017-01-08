/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P038 implements Solution {

    /**
     * 0 - 9
     */
    public static final int[] NUMBER_FLAG_CACHE = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 };

    /**
     * 1 - 9
     */
    public static final int ALL = 2 | 4 | 8 | 16 | 32 | 64 | 128 | 256 | 512;

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        // given 9 and (1, 2, 3, 4, 5) = 918273645, we can safely use the number as baseline
        int result = 918273645;
        int minimalDigits = 0;

        for (int i = 1; minimalDigits < 6; i++) {
            minimalDigits = EulerMathUtils.digitCount(i * 2);

            if (EulerMathUtils.firstDigit(i) != 9) {
                continue;
            }

            for (int n = 2; n <= 9; n++) {
                boolean skip = false;
                int usedNumber = 0;
                int[] products = new int[n + 1];
                for (int nn = 1; nn <= n; nn++) {
                    int num = i * nn;
                    products[nn] = num;

                    do {
                        int la = num % 10;
                        if ((usedNumber & NUMBER_FLAG_CACHE[la]) != 0) {
                            skip = true;
                            break;
                        }
                        usedNumber = usedNumber | NUMBER_FLAG_CACHE[la];
                        num /= 10;
                    } while (num > 0);

                    if (skip) {
                        break;
                    }
                }

                if (skip || usedNumber != ALL) {
                    continue;
                }

                int num = 0;
                int nextDigit = 0;
                for (int j = n; j >= 1; j--) {
                    int number = products[j];
                    int digit = EulerMathUtils.digitCount(number);
                    num += number * Math.pow(10, nextDigit);
                    nextDigit += digit;
                }

                result = Math.max(result, num);
            }
        }

        return result;
    }
}
