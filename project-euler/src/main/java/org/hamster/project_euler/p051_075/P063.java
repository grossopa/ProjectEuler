/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P063 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        long result = 0;
        // for numbers larger than 10 we can ignore as 10 ^ 2 == 100 (3) > 2
        for (int n = 2; n < 10; n++) {
            int p = 2;
            for (;; p++) {
                double num = Math.pow(n, p);
                int digitsPow = EulerMathUtils.digitCount(num);

                if (p == digitsPow) {
                    result++;
                } else if (p > digitsPow) {
                    break;
                }
            }

        }
        return result + 9 /* number from 1 to 9 with pow 1*/;
    }

}
