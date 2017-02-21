/**
 * 
 */
package org.hamster.project_euler.p051_075;

import java.util.Set;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P073 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int bound = (int) input;
        int result = 0;

        for (int i = 5; i <= bound; i++) {
            int left = i / 3 + 1;
            int right = i % 2 == 0 ? i / 2 - 1 : i / 2;
            
            Set<Long> primes = EulerMathUtils.distinctPrimeFactors(i);
            for (int j = left; j <= right; j++) {
                boolean skip = false;
                for (Long prime : primes) {
                    if (j > prime && j % prime == 0) {
                        skip = true;
                    }
                }

                if (skip) {
                    continue;
                }
                result++;
            }
        }
        return result;
    }

}
