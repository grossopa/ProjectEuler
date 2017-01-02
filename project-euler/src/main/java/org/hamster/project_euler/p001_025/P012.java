/**
 * 
 */
package org.hamster.project_euler.p001_025;

import java.util.Map;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P012 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        double current = 0;
        int prevDivisors = 1;
        int totalDivisors = 1;
        for (double i = 2; totalDivisors < input; i++) {
            current = i;
            int divisors = 2;
            
            if (current % 2 == 0) {
                current /= 2;
            }
            
            for (int j = 2; j * j < current; j++) {
                if (current % j == 0) {
                    divisors++;
                }
            }
            
            totalDivisors = prevDivisors * divisors;
            prevDivisors = divisors;
        }
        
        return current * (current + 1) / 2;
    }

}
