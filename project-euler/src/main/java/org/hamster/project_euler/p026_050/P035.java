/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P035 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        boolean[] composites = EulerMathUtils.primes((int) input);
        int result = 0;

        for (int i = 2; i < composites.length; i++) {
            if (composites[i]) {
                continue;
            }

            int num = i;

            boolean isCount = true;
            int totalCount = 1;

            int digitCount = (int) (Math.log10(i) + 1);
            int offset = (int) Math.pow(10, digitCount - 1);

            int[] primes = new int[digitCount];
            primes[0] = i;
            for (int j = 1; j < digitCount; j++) {
                int reminder = num % 10;
                num /= 10;
                num += offset * reminder;

                boolean duplicated = false;
                for (int p : primes) {
                    if (num == p) {
                        duplicated = true;
                        break;
                    }
                }
                if (duplicated) {
                    continue;
                }
                primes[j] = num;

                if (composites[num]) {
                    isCount = false;
                    break;
                } else {

                    totalCount++;
                }
                composites[i] = true; // skip others
            }

            if (isCount) {
                result += totalCount;
            }
        }
        return result;
    }

}
