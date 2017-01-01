/**
 * 
 */
package org.hamster.project_euler.p126_150;

import java.math.BigInteger;

import org.hamster.project_euler.base.Solution;

/**
 * FINISHED 
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P131 implements Solution {

    public double solutionTest(double max) {
        int result = 0;
        for (int x = 1; x < max; x++) {
            long p = (long) (3 * Math.pow(x, 2) + 3 * x + 1);
            if (p >= max) {
                break;
            }

            if (BigInteger.valueOf(p).isProbablePrime(15)) {
                result++;
            }
        }

        return result;
    }

    @Override
    public double solution() {
        return solutionTest(1000000L);
    }
}
