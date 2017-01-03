/**
 * 
 */
package org.hamster.project_euler.p001_025;

import java.math.BigInteger;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P020 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        BigInteger big = EulerMathUtils.factorialBig(input);
        char[] chs = big.toString().toCharArray();
        
        int result = 0;
        for (char ch : chs) {
            result += ch - 48;
        }
        
        return result;
    }

}
