/**
 * 
 */
package org.hamster.project_euler.p101_125;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * https://projecteuler.net/problem=116
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P116 implements Solution {

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
        return combination(2, blackCount) + combination(3, blackCount) + combination(4, blackCount);
    }

    private double combination(int tileLength, double blackCount) {
        double result = 0;
        for (int i = 1; i <= blackCount / tileLength; i++) {
            result += EulerMathUtils.combinationCount(i, blackCount - i * (tileLength - 1));
        }
        return result;
    }

}
