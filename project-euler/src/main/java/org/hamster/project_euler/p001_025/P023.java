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
public class P023 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        
        int bound = 28124;
        boolean[] cache = new boolean[bound];
        boolean[] cache2 = new boolean[bound];
        
        for (int i = 12; i < bound; i++) {
            cache[i] = isAbundant(i);
        }
        
        for (int i = 12; i < bound; i++) {
            for (int j = 12; j < bound; j++) {
                int sum = i + j;
                if (cache[i] && cache[j] && sum < bound) {
                    cache2[sum] = true;
                }
            }
        }
        
        int result = 0;
        for (int i = 1; i < bound; i++) {
            if (!cache2[i]) {
                result += i;
            }
        }
        return result;
    }

    /**
     * it is called abundant if this sum exceeds n.<br>
     * 
     * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16
     * 
     * @param number
     * @return
     */
    public boolean isAbundant(double number) {
        double divisorSum = EulerMathUtils.divisorSum(number);
        return divisorSum > number;
    }

}
