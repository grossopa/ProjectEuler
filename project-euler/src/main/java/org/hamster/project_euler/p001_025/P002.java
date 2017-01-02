/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P002 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public Number solution(double input) {
        double result = 0;
        double prev1 = 0;
        double prev2 = 1;
        int isEven = 1;
        while (prev1 + prev2 <= input) {
            double number = prev1 + prev2;
            prev1 = prev2;
            prev2 = number;
            if (++isEven == 3) {
                isEven = 0;
                result += number;
            }
        }
        return result;
    }

}
