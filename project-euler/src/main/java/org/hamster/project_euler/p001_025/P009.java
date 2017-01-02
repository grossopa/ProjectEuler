/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;

/**
 * <tt>
 * a^2 + b^2 = c^2<br>
 * a + b + c = 1000
 * 
 * <br>
 * then the question can be convert to find an integer b that:<br>
 * 1. makes a to be an integer as well<br>
 * <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;1000^2 - 2000b<br>
 * a&nbsp;=&nbsp;--------------<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;2000 - 2b<br>
 * 
 * 2. c = 1000 - a - b > 0
 * </tt>
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P009 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public Number solution(double input) {
        for (int b = 1; b <= 998; b++) {
            double a = (1000_000 - 2000 * b) / (2000 - 2 * b);
            if (a == (int) a && 1000 - a - b > 0 && a * a + b * b == (1000 - a - b) * (1000 - a - b)) {
                return a * b * (1000 - a - b);
            }
        }

        return 0;
    }

}
