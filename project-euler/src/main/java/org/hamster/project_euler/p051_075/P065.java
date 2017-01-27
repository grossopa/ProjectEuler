/**
 * 
 */
package org.hamster.project_euler.p051_075;

import java.math.BigInteger;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;
import org.hamster.project_euler.util.Fraction;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P065 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        Fraction fraction = new Fraction(EulerMathUtils.ZERO, EulerMathUtils.ONE);
        for (int i = (int) input - 1; i > 0; i--) {
            int left = i % 3 == 2 ? (i / 3 + 1) * 2 : 1;
            fraction.add(BigInteger.valueOf(left), EulerMathUtils.ONE);
            BigInteger numerator = fraction.getNumerator();
            fraction.setNumerator(fraction.getDenominator());
            fraction.setDenominator(numerator);
        }
        BigInteger numerator = new Fraction(EulerMathUtils.TWO, EulerMathUtils.ONE).add(fraction).getNumerator();
        int result = 0;
        char[] digits = numerator.toString().toCharArray();
        for (char digit : digits) {
            result += digit - '0';
        }

        return result;
    }

}
