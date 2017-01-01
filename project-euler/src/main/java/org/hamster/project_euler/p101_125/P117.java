/**
 * 
 */
package org.hamster.project_euler.p101_125;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P117 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution()
     */
    @Override
    public double solution() {
        return solutionTest(50);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public double solutionTest(double blackCount) {
        double result = 0;
        for (int i = 0; i < blackCount; i++) { // 2
            for (int j = 0; j < blackCount; j++) { // 3
                for (int k = 0; k < blackCount; k++) { // 4
                    double length = blackCount - i - j * 2 - k * 3;
                    if (length < i + j + k) {
                        continue;
                    }
                    
                    result += EulerMathUtils.combinationCount(i + j + k, length)
                            * EulerMathUtils.combinationCount(i, i + j + k)
                            * EulerMathUtils.combinationCount(j, j + k);
                }
            }
        }

        return result;
    }

}
