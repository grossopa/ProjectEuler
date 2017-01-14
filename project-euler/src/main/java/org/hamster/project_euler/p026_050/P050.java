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
public class P050 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        boolean[] composites = EulerMathUtils.primes((int) input);
        Integer[] primes = EulerMathUtils.primesAsList(composites).toArray(new Integer[] {});
        int chainCount = 0;
        int l = primes.length;
        int result = 0;
        for (int s = 0; s < l; s++) {
            int sum = 0;
            for (int i = s; i < l; i++) {
                sum += primes[i];
                if (sum < input && !composites[sum]) {
                    if (i - s + 1 > chainCount) {
                        chainCount = i - s + 1;
                        result = sum;
                    }
                }
                if (sum >= input) {
                    break;
                }
            }
        }

        return result;
    }

}
