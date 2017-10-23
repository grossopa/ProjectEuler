/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * We are looking for Pythagorean triple list using Geometry of Euclid's formula:<br>
 * <tt>
 * while : a = 2mn, b = m^2 - n^2, c = m^2 + n^2 where gcd(m, n) == 1 (coprimes)<br>
 * 
 * a + b + c = 2mn + 2m^2 &lt;= bound <br>
 * &nbsp;&nbsp;&lt; m(m + n) &lt;= bound / 2<br>
 * 
 *</tt>
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 * @see https://en.wikipedia.org/wiki/Pythagorean_triple
 */
public class P075 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int bound = (int) input;
        int[] count = new int[bound + 1];

        for (long m = 2; m < Math.ceil(Math.sqrt(bound / 2)); m++) {
            for (long n = 1; n < m; n++) {
                // where m, n, and k are positive integers with m > n, and with m and n coprime and not both odd.
                if ((m % 2 != 0 && n % 2 != 0) || !EulerMathUtils.coprime(m, n)) {
                    continue;
                }

                long len = 2 * m * n + m * m * 2;
                int k = 1;
                while (k * len <= bound) {
                    count[k * (int) len]++;
                    k++;
                }
            }
        }

        int result = 0;
        for (int i = 1; i < bound + 1; i++) {
            if (count[i] == 1) {
                result++;
            }
        }

        return result;
    }

}
