/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * Considering the minimum for n / totient(n) should maximumise the totient(n), the simple case p1 * p2 should be the
 * first case to be evaluated as totient(n) = (p1 - 1) * (p2 - 1).
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P070 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        long result = 0;
        double resultMin = Double.MAX_VALUE;
        Integer[] primes = EulerMathUtils.primesAsList((int) input).toArray(new Integer[] {});
        int l = primes.length;

        for (int i = 0; i < l; i++) {
            long pi = primes[i];
            for (int j = i + 1; j < l; j++) {
                long pj = primes[j];
                long num = pi * pj;
                if (num > input) {
                    break;
                }
                long val = (pi - 1) * (pj - 1);
                double div = (double) num / val;
                if (resultMin < div) {
                    continue;
                } else if (EulerMathUtils.isPermutation(val, num)) {
                    resultMin = div;
                    result = num;
                }
            }
        }

        return result;
    }

}
