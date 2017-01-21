/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.p026_050.P028;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * iterative algorithm relates to {@link P028}
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P058 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {

        double primeCount = 0;
        for (double sideLength = 3;; sideLength += 2) {
            double prt = (sideLength - 2) * (sideLength - 2);

            double rt = prt + sideLength - 1;
            double lt = rt + sideLength - 1;
            double lb = lt + sideLength - 1;

            if (EulerMathUtils.isPrime(rt)) {
                primeCount++;
            }
            if (EulerMathUtils.isPrime(lt)) {
                primeCount++;
            }
            if (EulerMathUtils.isPrime(lb)) {
                primeCount++;
            }

            if (primeCount / (sideLength * 2 - 1) < 0.1) {
                return sideLength;
            }

        }
    }

}
