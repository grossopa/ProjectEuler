/**
 * 
 */
package org.hamster.project_euler.p126_150;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * FINISHED 12s
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P145 implements Solution {

    public long doSolve(long digits) {
        long result = 0;
        for (long i = 1; i <= digits; i++) {
            result += iteratorNumbers(i);
        }
        return result;
    }

    public long iteratorNumbers(long digit) {
        long dnum = (long) Math.pow(10, digit);
        long minBound = (long) (dnum * .1);
        long max = dnum - 1L;

        long result = 0;
        for (long i = minBound; i <= max; i++) {
            long r = EulerMathUtils.reverseNoLeadingZero(i);
            if (r == Long.MIN_VALUE) {
                continue;
            }
            long sum = r + i;
            if (EulerMathUtils.onlyWithOddNumbers(sum)) {
                result++;

            }
        }
        return result;
    }

    @Override
    public Number solution(double input) {
        return doSolve(8);
    }

}
