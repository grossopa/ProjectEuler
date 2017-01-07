/**
 * 
 */
package org.hamster.project_euler.P026_050;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P027 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int bound = (int) input;
        int maxValue = quadratic(bound, bound, bound);
        boolean[] composites = EulerMathUtils.primes(maxValue);

        int maxN = 1;
        int maxA = 0;
        int maxB = 0;

        // 1. b must be prime
        // 2. given any a is even, when n = 3 then 9 + 3 * a + b is even so we can safely assume a must be odd.
        // 3. max value for n will always be less than b
        // 4. for any 1 + a + b < 2 we can safely ignore
        // 5. first to test from maxN + 1 to 1, then maxN + 2 to b - 1
        for (int a = -bound + 1; a < bound; a += 2) {
            for (int b = 1; b < bound; b += 2) {
                if (composites[b]) {
                    continue;
                }
                if (1 + a + b < 2) {
                    continue;
                }
                
                boolean skip = false;
                for (int n = maxN + 1; n >= 1; n--) {
                    int q = quadratic(n, a, b);
                    if (q < 2 || composites[q]) {
                        skip = true;
                        break;
                    }
                }
                
                if (skip) {
                    continue;
                }
                
                maxN = maxN + 1;
                maxA = a;
                maxB = b;
                
                for (int n = maxN + 2; n < b;n++) {
                    int q = quadratic(n, a, b);
                    if (q >= 2 && !composites[q]) {
                        maxN = n;
                    } else {
                        break;
                    }
                     
                }
            }
        }

        return maxA * maxB;
    }

    private int quadratic(int n, int a, int b) {
        return n * (n + a) + b;
    }

}
