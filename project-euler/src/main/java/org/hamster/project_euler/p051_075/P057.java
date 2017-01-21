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
public class P057 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int result = 0;

        long numerator = 2;
        long denominator = 5;

        for (int i = 2; i < input; i++) {
            // add 2
            numerator = numerator + 2 * denominator;

            // 1 + 1 / (n / d) = 1 + d / n = (n + d) / n
            long sumNumerator = denominator + numerator;
            long sunDenominator = numerator;

            // 1 / (n / d) = d / n;
            long temp = numerator;
            numerator = denominator;
            denominator = temp;

            // FIXME: Why we can skip verifying common divisors here and still the answer is correct?????
            if (numerator > 1_000_000_000_000L) {
                numerator /= 100_000L;
                denominator /= 100_000L;
            }

            if (EulerMathUtils.digitCount(sunDenominator) < EulerMathUtils.digitCount(sumNumerator)) {
                result++;
            }
        }

        return result;
    }

}
