/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P021 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        double bound = input - 1;
        double result = 0;
        for (int i = 2; i < bound; i++) {
            int divisorSum = getDivisorSum(i);
            if (i != divisorSum && i == getDivisorSum(divisorSum)) {
                result += i + divisorSum;
            }
        }

        return result / 2;
    }

    private int getDivisorSum(int n) {
        int sum = 0;
        for (int i = 1; i <= (int) (n / 2); i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

}
