/**
 * 
 */
package org.hamster.project_euler.p051_075;

import java.util.Arrays;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P051 implements Solution {

    private static final int[] DIGIT_CACHE = new int[] { 0, 1, 2, 4, 8, 16, 32, 64, 128 };
    private static final int[] TEN_POW_CACHE = new int[] { 1, 10, 100, 1000, 10000, 100_000, 1_000_000, 10_000_000 };

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        boolean[] composites = EulerMathUtils.primes(1_000_000);
        Integer[] primes = EulerMathUtils.primesAsList(composites).toArray(new Integer[] {});

        int result = Integer.MAX_VALUE;
        int previousDigitCount = 3;

        for (int prime : primes) {
            if (prime < 100) {
                continue;
            }

            int[] digits = EulerMathUtils.digits(prime);
            int digitCount = digits.length;
            if (previousDigitCount != digitCount && result != Integer.MAX_VALUE) {
                break;
            }
            previousDigitCount = digitCount;
            int digitFlag = (int) (Math.pow(2, digitCount - 1) - 1);
            for (int df = 1; df <= digitFlag; df++) {
                // starts from the second digit
                int primesCount = 0;
                int minPrime = Integer.MAX_VALUE;
                int[] copyDigits = Arrays.copyOf(digits, digitCount);
                for (int i = 0; i < 10; i++) {
                    for (int subDigit = 1; subDigit <= digitCount; subDigit++) {
                        if ((DIGIT_CACHE[subDigit] & df) != 0) {
                            copyDigits[subDigit] = i;
                        }
                    }

                    int num = 0;
                    for (int t = 0; t < digitCount; t++) {
                        num += copyDigits[t] * TEN_POW_CACHE[t];
                    }

                    if (EulerMathUtils.digitCount(num) < digitCount) {
                        continue;
                    }

                    if (!composites[num]) {
                        minPrime = Math.min(minPrime, num);
                        primesCount++;
                    }
                }

                if (primesCount >= input) {
                    result = Math.min(result, minPrime);
                    return result;
                }
            }
        }

        return result;

    }

}
