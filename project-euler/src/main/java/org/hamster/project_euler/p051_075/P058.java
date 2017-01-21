/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.p026_050.P028;

/**
 * iterative algorithm relates to {@link P028}
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P058 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int result = 1;
        double percent = 1;
        
        for (int sideLength = 3; percent < 0.1; sideLength += 2) {
            int prt = (sideLength - 2) * (sideLength - 2);
            
            int rb = sideLength * sideLength;
            int rt = prt + sideLength - 1;
            int lt = rt + sideLength - 1;
            int lb = lt + sideLength - 1;
            
            result += rt + rb + lb + lt;
        }
        return result;
    }

}
