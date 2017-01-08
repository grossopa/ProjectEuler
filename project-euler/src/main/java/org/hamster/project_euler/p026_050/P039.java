/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P039 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        // it can be calculated by count all possible p's for
        // all a's and b's in the range

        // a + b + c = p
        // a^2 + b^2 = c^2
        // =>> a = p(p - 2b) / 2(p - b)

        // so criteria including:
        // 2b < p
        // p (p - 2b) % 2 (p - b) == 0
        // b <= a // to remove duplicates

        int[] pCount = new int[1001];

        for (int p = 3; p <= 1000; p++) {
            for (int b = 1; 2 * b < p; b++) {
                double a = (p - b * 2) * p * 0.5 / (p - b);
                if (a > b && Math.abs(a - (int) a) <= 0.000001D) {
                    pCount[p]++;
                }
            }
        }

        double max = 0;
        int maxP = 0;
        for (int i = 0; i < pCount.length; i++) {
            if (max < pCount[i]) {
                max = pCount[i];
                maxP = i;
            }
        }

        return maxP;
    }

}
