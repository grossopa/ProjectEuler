/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P010 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public Number solution(double input) {
        boolean[] composites = EulerMathUtils.primes((int) input);
        double result = 0;
        for (int i = 1; i < input; i++) {
            if (!composites[i]) {
                result += i;
            }
        }
        return result;
    }

}
