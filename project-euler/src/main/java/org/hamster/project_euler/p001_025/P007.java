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
public class P007 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public Number solution(double input) {
        double count = input;
        double i = 1;
        while (count > 0) {
            i++;
            if (EulerMathUtils.isPrime(i)) {
                count--;
            }

        }
        return i;
    }

}
