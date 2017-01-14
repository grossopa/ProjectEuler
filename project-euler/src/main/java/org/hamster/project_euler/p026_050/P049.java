/**
 * 
 */
package org.hamster.project_euler.p026_050;

import java.util.Arrays;
import java.util.function.Function;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerCallbackUtils;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P049 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        final boolean[] composites = EulerMathUtils.primes(9999);

        for (int i = 1000; i <= 9999; i++) {
            if (composites[i]) {
                continue;
            }
            int[] digits = EulerMathUtils.digits(i);
            Arrays.sort(digits); // minimun to maximum for later ordered check
            final double[] primeIndexList = new double[24]; // P4 = 4 * 3 * 2 * 1
            final int[] count = new int[1];
            EulerCallbackUtils.permutationDigits(new Function<Long, Boolean>() {

                int index = 0;

                @Override
                public Boolean apply(Long t) {
                    int num = t.intValue();
                    if (num > 1000 && !composites[num]) {
                        primeIndexList[index++] = num;
                        count[0]++;
                    }
                    return true;
                }

            }, digits);

            if (count[0] >= 3) {
                // found more than 3 primes
                for (int right = 2; right < count[0]; right++) {
                    for (int middle = 1; middle < right; middle++) {
                        double rm = primeIndexList[right] - primeIndexList[middle];
                        if (rm == 0) {
                            continue;
                        }
                        for (int left = 0; left < middle; left++) {
                            double ml = primeIndexList[middle] - primeIndexList[left];
                            if (ml == 0) {
                                continue;
                            }
                            if (rm == ml) {
                                if (input == 1 && primeIndexList[left] == 1487) {
                                    continue;
                                }
                                return primeIndexList[left] * 100_000_000 + primeIndexList[middle] * 10_000 + primeIndexList[right];
                            }
                        }
                    }
                }

            }

            // clean up all numbers to avoid duplicate check
            for (double index : primeIndexList) {
                if (index == 0) {
                    break;
                }
                composites[(int) index] = true;
            }
        }
        return -1;
    }

}
