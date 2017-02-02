/**
 * 
 */
package org.hamster.project_euler.p051_075;

import java.math.BigInteger;
import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerCallbackUtils;
import org.hamster.project_euler.util.EulerCallbackUtils.ContinuedFractionsCallback;
import org.hamster.project_euler.util.EulerMathUtils;
import org.hamster.project_euler.util.Fraction;

/**
 * Pell's equation
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Pell%27s_equation">Pell's equation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Continued_fraction">Continued Fraction</a>
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P066 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {

        BigInteger[] bresult = new BigInteger[] { BigInteger.ZERO, BigInteger.ZERO };

        for (long d = 1; d <= input; d++) {
            if (EulerMathUtils.isInteger(Math.sqrt(d))) {
                continue;
            }

            final BigInteger bd = BigInteger.valueOf(d);

            EulerCallbackUtils.continuedFractions(d, Integer.MAX_VALUE, new ContinuedFractionsCallback() {

                @Override
                public boolean apply(List<BigInteger[]> sequence, BigInteger bsqrt, BigInteger left,
                        BigInteger numerator, BigInteger denominator) {
                    Fraction f = new Fraction(BigInteger.ONE, sequence.get(sequence.size() - 1)[0]);
                    for (int i = sequence.size() - 2; i >= 0; i--) {
                        BigInteger[] seq = sequence.get(i);
                        f.add(seq[0], BigInteger.ONE);
                        BigInteger t = f.getDenominator();
                        f.setDenominator(f.getNumerator());
                        f.setNumerator(t);
                    }
                    BigInteger t = f.getDenominator();
                    f.setDenominator(f.getNumerator());
                    f.setNumerator(t);

                    BigInteger powx = f.getNumerator().multiply(f.getNumerator());
                    BigInteger calc = powx.subtract(bd.multiply(f.getDenominator().multiply(f.getDenominator())));
                    if (calc.equals(BigInteger.ONE)) {
                        if (bresult[0].compareTo(powx) == -1) {
                            bresult[0] = powx;
                            bresult[1] = bd;
                        }
                        return false;
                    }
                    return true;
                }

            });
        }
        return bresult[1];
    }

}
