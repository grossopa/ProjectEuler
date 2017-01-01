/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P004 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution()
     */
    @Override
    public double solution() {
        return solutionTest(3);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public double solutionTest(double input) {
        int bound = (int) Math.pow(10, input) - 1;
        int low = (int) Math.pow(10, input - 1);
        
        int maxResult = 0;
        for (int i = bound; i >= low; i--) {
            for (int j = bound; j >= low; j--) {
                int cand = i * j;
                
                if (cand > maxResult && EulerMathUtils.isPalindromic(cand)) {
                    maxResult = cand;
                }
            }
        }
        return maxResult;
    }

}
