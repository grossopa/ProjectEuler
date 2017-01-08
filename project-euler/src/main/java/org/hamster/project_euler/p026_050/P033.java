/**
 * 
 */
package org.hamster.project_euler.p026_050;

import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P033 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        double productD = 1;
        double productM = 1;

        for (double i = 1; i <= 9; i++) {
            for (double d = 1; d < i; d++) {
                for (double n = 1; n < d; n++) {
                    if ((n * 10 + i) / (i * 10 + d) == n / d) {
                        productD *= d;
                        productM *= n;
                    }
                }
            }
        }
        
        List<Double> divisorD = EulerMathUtils.divisors(productD);
        List<Double> divisorM = EulerMathUtils.divisors(productM);
        divisorD.add(productD);
        divisorM.add(productM);
        
        double maxdivisor = 0;
        for (Double d : divisorD) {
            if (divisorM.contains(d)) {
                maxdivisor = Math.max(maxdivisor, d);
            }
        }

        return productD / maxdivisor;
    }

}
