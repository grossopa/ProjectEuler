/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;
import static org.hamster.project_euler.util.EulerMathUtils.factorial;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P034 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {

        // detect bound 9! * n < pow(10, n); n = 7 when 9! * 7

        double[] factorialCache = new double[10];

        for (int i = 0; i < factorialCache.length; i++) {
            factorialCache[i] = factorial(i);
        }

        int result = 0;
        for (int i = 10; i < Math.pow(10, 7); i++) {
            int n = i;
            int sum = 0;
            do {
                int digit = n % 10;
                sum += factorialCache[digit];
                n /= 10;
            } while (n > 0);
            
            if (sum == i) {
                result += i;
            }
        }

        return result;
    }

}
