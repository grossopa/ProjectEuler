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
public class P046 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        long result = 0;
        for (long i = 33;; i += 2) {
            if (EulerMathUtils.isPrime(i)) {
                continue;
            }
            for (long num = 1;; num++) {
                long sub = i - 2 * num * num;
                if (sub <= 1) {
                    result = i;
                    // found the right answer
                    break;
                } else if (EulerMathUtils.isPrime(sub)) {
                    // the rest is prime, let's continue
                    break;
                }

            }
            if (result != 0) {
                break;
            }
        }
        return result;
    }

}
