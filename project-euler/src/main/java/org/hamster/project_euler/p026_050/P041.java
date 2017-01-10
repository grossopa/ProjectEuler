/**
 * 
 */
package org.hamster.project_euler.p026_050;

import java.util.function.Function;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerCallbackUtils;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P041 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {

        final int[] result = new int[1];

        for (int i = 9; i >= 1; i--) {
            int[] numbers = new int[i];
            for (int n = 0; n < i; n++) {
                numbers[n] = i - n;
            }

            EulerCallbackUtils.permutationDigits(new Function<Integer, Boolean>() {

                /*
                 * (non-Javadoc)
                 * 
                 * @see java.util.function.Function#apply(java.lang.Object)
                 */
                @Override
                public Boolean apply(Integer t) {
                    if (EulerMathUtils.isPrime(t)) {
                        result[0] = t;
                        return false;
                    }
                    return true;
                }

            }, numbers);
            if (result[0] != 0) {
                break;
            }
        }

        return result[0];
    }

}
