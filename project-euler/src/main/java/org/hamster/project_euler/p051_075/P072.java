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
public class P072 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int bound = (int) input;
        // boolean[] composites = EulerMathUtils.primes(bound);
        boolean[] checked = new boolean[bound + 1];

        long result = 0;

        for (int denominator = 2; denominator <= bound; denominator++) {
            if (checked[denominator]) {
                continue;
            }

            Set<Long> primes = EulerMathUtils.distinctPrimeFactors(denominator);
            long[] tempResult = new long[] { 0 };
            calc(denominator, primes.toArray(new Long[] {}), 0, tempResult, checked, bound);
            // System.out.println(denominator + " " + tempResult[0]);
            result += tempResult[0];
        }

        return result;
    }

    private void calc(long num, Long[] primes, int index, long[] result, boolean[] checked, int bound) {
        if (primes.length == index) {
            return;
        }
        long prime = primes[index];
        while (num <= bound) {
            if (checked[(int) num]) {
                return;
            }
            calc(num * prime, primes, index + 1, result, checked, bound);
            checked[(int) num] = true;
            long tc = num;
            for (Long p : primes) {
                tc = tc * (p - 1) / p;
            }
            result[0] += tc;

            num *= prime;
        }
    }

}
