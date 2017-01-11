/**
 * 
 */
package org.hamster.project_euler.p026_050;

import java.util.function.Function;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerCallbackUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P043 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int[] nums = new int[10];
        for (int i = 0; i <= 9; i++) {
            nums[i] = i;
        }

        final long min = 1_000_000_000;
        final int[] primes = new int[] { 17, 13, 11, 7, 5, 3, 2 };
        final long[] sum = new long[1];

        EulerCallbackUtils.permutationDigits(new Function<Long, Boolean>() {

            @Override
            public Boolean apply(Long t) {
                if (t > min) {
                    long reminder = t % 1000;
                    long number = t / 1000;
                    for (int p = 0; p < primes.length; p++) {

                        if (reminder % primes[p] != 0) {
                            return true;
                        }
                        // do calculate
                        reminder /= 10;
                        reminder += (number % 10) * 100;
                        number /= 10;
                    }
                    sum[0] += t;

                }

                return true;
            }

        }, nums);

        return sum[0];
    }

}
