/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P015 implements Solution {

    /**
     * It takes input * 2 steps to reach the right bottom corner, and input number for right and input number for
     * bottom, hence the question would be to put input number of items to input * 2 baskets.
     */
    @Override
    public Number solution(double input) {
        return EulerMathUtils.combinationCountBig(input, input * 2);
    }

}
