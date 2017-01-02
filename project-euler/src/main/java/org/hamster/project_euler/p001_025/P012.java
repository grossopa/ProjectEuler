/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P012 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int totalDivisors = 0;
        int prevDivisors = 1;
        int currentNumber = 0;
        for (int i = 2; totalDivisors < input; i++) {
            currentNumber = i;
            int current = i;
            if (current % 2 == 0) {
                current /= 2;
            }

            int divisors = 0;

            for (int j = 1; j * j <= current; j++) {
                if (current % j == 0) {
                    divisors += 2;
                    if (current / j == j) {
                        divisors--;
                    }
                }
            }

            totalDivisors = prevDivisors * divisors;
            prevDivisors = divisors;
        }

        return currentNumber * (currentNumber - 1) / 2;
    }

}
