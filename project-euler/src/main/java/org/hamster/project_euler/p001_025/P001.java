/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P001 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public Number solution(double input) {
        double count = 0;
        for (double i = 1; i < input; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                count += i;
            }
        }
        return count;
    }

}
