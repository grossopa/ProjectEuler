/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * the immediately left can be easily assumed that:<br>
 * (x - 1) / y1, x / y2<br>
 * that y1 should be relatively prime with (x - 1)<br>
 * so we get sub numerator = y1 * x -y2 * x - y2 / y1 / y2 is the closet number.
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P071 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int maxd = (int) input;
        int rn = 3;
        int rd = 7;

        int rnmul = (int) (maxd / rd) * rn;
        int rdmul = (int) (maxd / rd) * rd;

        @SuppressWarnings("unused")
        int rprimed = 0;
        for (int i = rdmul - 1; i > 0; i--) {
            if (EulerMathUtils.gcd(i, rnmul - 1) == 1) {
                rprimed = i;
                break;
            }
        }

        // well why needs to calculate the rprimed here?

        return rnmul - 1;
    }

}
