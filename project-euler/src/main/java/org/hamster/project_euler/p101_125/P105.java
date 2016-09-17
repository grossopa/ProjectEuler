/**
 * 
 */
package org.hamster.project_euler.p101_125;

import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.base.SolutionUtils;
import org.hamster.project_euler.util.EulerArrayUtils;
import org.hamster.project_euler.util.EulerFileUtils;

/**
 * https://projecteuler.net/problem=105
 * 
 * FINISHED
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P105 implements Solution {

    @Override
    public long solution() {

        List<long[]> items = EulerFileUtils.readAsLong("src/org/hamster/playground/project_euler/p101_125/p105_sets.txt");
        long sum = 0;
        for (long[] item : items) {
            if (P103.isSpecialSum(item)) {
                sum += EulerArrayUtils.sum(item);
            }
        }
        return sum;
    }

    public static final void main(String[] args) {
        SolutionUtils.invoke(P105.class, 73702L);
    }

}
