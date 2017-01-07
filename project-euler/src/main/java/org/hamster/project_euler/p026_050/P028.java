/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P028 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double totalSideLength) {
        int result = 1;
        
        for (int sideLength = 3; sideLength <= totalSideLength; sideLength += 2) {
            int prt = (sideLength - 2) * (sideLength - 2);
            
            int rt = sideLength * sideLength;
            int rb = prt + sideLength - 1;
            int lb = rb + sideLength - 1;
            int lt = lb + sideLength - 1;
            
            result += rt + rb + lb + lt;
        }
        return result;
    }

}
