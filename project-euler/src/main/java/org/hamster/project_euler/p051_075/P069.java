/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P069 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        double result = Double.MIN_VALUE;
        double resultValue = Double.MIN_VALUE;
        for (int i = 2; i <= input; i++) {
            double val = (double) i / EulerMathUtils.eulersTotientFunction(i);
            if (resultValue < val) {
                result = i;
                resultValue = val;
            }
        }
        return result;
    }

}
