/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P053 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int result = 0;
        for (int n = 1; n <= 100; n++) {
            int middle = n / 2;
            for (int r = 1; r <= middle; r++) {
                if (EulerMathUtils.combinationCount(r, n) > 1_000_000) {
                    result += n % 2 == 0 ? 2 * (middle - r) + 1 : 2 * (middle - r + 1);
                    break;
                }
            }
        }
        return result;
    }

}
