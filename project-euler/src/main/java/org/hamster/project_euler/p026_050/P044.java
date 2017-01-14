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
        for (int k = 3; ;k++) {
            //.System.out.println(k);
            long vk = k * (3 * k - 1);
            for (int j = k - 1; k - j >= j; j--) {
                long vj = j * (3 * j - 1);
                if (verify(vk + vj) && verify(vk - vj)) {
                    System.out.println(k + " " + " " + j);
                    min = Math.min(vk - vj, min);
                }
            }
            if (vk - prevk > min) {
                break;
            }
            prevk = vk;
        }
        return min;
    }
    
    private boolean verify(double number) {
        // (24 * n + 1)^ 0.5 + 1 / 6 must be an integer
        double num1 = Math.sqrt(12 * number + 1);
        if (Math.abs(num1 - ((long) num1)) <= 0.000001D) {
            // System.out.println(num1 +  "     " + ((num1 + 1) % 6 == 0));
            return (num1 + 1) % 6 == 0;
        }
        return false;
    }

}
