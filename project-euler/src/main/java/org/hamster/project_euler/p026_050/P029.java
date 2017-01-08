/**
 * 
 */
package org.hamster.project_euler.p026_050;

import java.util.HashSet;
import java.util.Set;

import org.hamster.project_euler.base.Solution;

/**
 * TODO: what's the best solution?
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P029 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        Set<Double> calculateResult = new HashSet<Double>();
        for (int a = 2; a <= input; a++) {
            for (int b = 2; b <= input; b++) {
                calculateResult.add(Math.pow(a, b));
            }
        }

        return calculateResult.size();
    }

}
