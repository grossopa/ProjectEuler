/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P021 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        double bound = input - 1;
        double result = 0;
        for (double i = 2; i < bound; i++) {
            double divisorSum = EulerMathUtils.getDivisorSum(i);
            if (i != divisorSum && i == EulerMathUtils.getDivisorSum(divisorSum)) {
                result += i + divisorSum;
            }
        }

        return result / 2;
    }


}
