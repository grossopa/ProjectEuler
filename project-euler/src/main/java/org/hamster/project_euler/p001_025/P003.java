/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P003 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution()
     */
    @Override
    public double solution() {
        return solutionTest(600_851_475_143D);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public double solutionTest(double input) {
        int max = (int) Math.sqrt(input);
        
        if ((max & 1) != 0) {
            // is even
            max--;
        }
        
        for (int i = max; i >= 2; i--) {
            if (EulerMathUtils.isPrime(i) && input % i == 0) {
                return i;
            }
        }
        
        return -1;
    }

}
