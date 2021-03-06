/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P006 implements Solution {


    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public Number solution(double input) {
        double squaresOfSum = 0;
        double sumOfSquares = 0;
        
        for (int i = 1; i <= input; i++) {
            squaresOfSum += i;
            sumOfSquares += i * i;
        }
        
        return squaresOfSum * squaresOfSum - sumOfSquares;
    }

}
