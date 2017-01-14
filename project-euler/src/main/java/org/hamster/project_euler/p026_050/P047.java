/**
 * 
 */
package org.hamster.project_euler.p026_050;

import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P047 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        boolean[] composites = EulerMathUtils.primes(10_000_000);
        List<Integer> primes = EulerMathUtils.primesAsList(composites);
        
        int result = 0;
        int targetCount = (int) input;
        int cont = 0;
        for (int i = 2; ; i++) {
            if (composites[i]) {
                int primeCount = 0;
                for (Integer prime : primes) {
                    if (prime > i >> 1) {
                        break;
                    }
                    if (i % prime == 0) {
                        primeCount++;
                    }
                }
                cont = primeCount == targetCount ? cont + 1 : 0;
                
                if (cont == targetCount) {
                    result = i - targetCount + 1;
                    break;
                }
            } else {
                cont = 0;
            }
        }
        
        return result;
    }

}
