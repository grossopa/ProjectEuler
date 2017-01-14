/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P044 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        // n (3n - 1) / 2
        double min = Double.MAX_VALUE;
        long prevk = 1;
        long GUESS_BOUND = 2500;
        for (int k = 3; k <= GUESS_BOUND; k++) {
            long vk = k * (3 * k - 1);
            for (int j = k - 1; j >= 1; j--) {
                long vj = j * (3 * j - 1);
                if (vk - vj > min) {
                    break;
                }
                if (verify(vk + vj) && verify(vk - vj)) {
                    min = Math.min(vk - vj, min);
                }
            }
            if (vk - prevk > min) {// TODO: What's the better quit condition rather than make a guess for 2500?
                break;
            }
            prevk = vk;
        }
        return min / 2;
    }

    private boolean verify(double number) {
        // (24 * n + 1)^ 0.5 + 1 / 6 must be an integer
        double num1 = Math.sqrt(12 * number + 1);
        if (Math.abs(num1 - ((long) num1)) <= 0.000001D) {
            // System.out.println(num1 + " " + ((num1 + 1) % 6 == 0));
            return (num1 + 1) % 6 == 0;
        }
        return false;
    }

}
