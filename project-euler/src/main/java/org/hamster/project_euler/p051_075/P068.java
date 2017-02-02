/**
 * 
 */
package org.hamster.project_euler.p051_075;

import java.util.function.Function;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerCallbackUtils;

/**
 * Uses a single array <tt>int[gon * 2]</tt> to represent the n-gon ring. Elements from <tt>[0]</tt> to
 * <tt>[gon - 1]</tt> represent the outer circle (clocker or clockwise doesn't matter) and <tt>[gon]</tt> to
 * <tt>[gon * 2 - 1]</tt> represent the inner circle.<br>
 * <br>
 * 
 * The 3 elements in the same line can be represented as:<br>
 * <tt>[0] - [gon - 2]:<br>
 * t[i], t[i + gon], t[i + gon + 1]</tt><br>
 * <tt>[gon - 1]:<br>
 * t[i], t[i + gon], t[gon]</tt><br>
 * <br>
 * 
 * Then just to iterate all the permutation and figure out the desired answer.<br>
 * <br>
 * 
 * FIXME: how to remove duplication? By hash?
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P068 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        final int gon = (int) input;
        final long[] result = new long[1];

        Integer[] numbers = new Integer[gon * 2];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        EulerCallbackUtils.permutation(new Function<Integer[], Boolean>() {

            @Override
            public Boolean apply(Integer[] t) {
                int sum = 0;
                int min = Integer.MAX_VALUE;
                // starts with minimal numbers
                int minStart = 0;

                for (int i = 0; i < gon; i++) {
                    if (t[i] < min) {
                        min = t[i];
                        minStart = i;
                    }

                    int tsum = t[i] + t[i + gon] + t[i == gon - 1 ? gon : i + gon + 1];
                    if (sum == 0) {
                        sum = tsum;
                    } else if (sum != tsum) {
                        // break here as the sum is not same
                        return true;
                    }
                }

                // now we have the n-gon ring
                String resultStr = "";
                for (int i = 0; i < gon; i++) {
                    int index = minStart + i > gon - 1 ? minStart + i - gon : minStart + i;
                    resultStr += t[index] + "" + t[index + gon] + "" + t[index == gon - 1 ? gon : index + gon + 1];
                }

                if (resultStr.length() == (gon == 3 ? 9 : 16)) {
                    long resultNum = Long.valueOf(resultStr);
                    result[0] = Math.max(result[0], resultNum);
                }
                return true;
            }

        }, numbers);

        return result[0];
    }

}
