/**
 * 
 */
package org.hamster.project_euler.p051_075;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P062 implements Solution {

    private static final long[] USED_NUMBER_FLAG = new long[] { 1L /* 0 */, 10L /* 1 */, 100L /* 2 */, 1000L /* 3 */,
            10000L /* 4 */, 100000L /* 5 */, 1000000L /* 6 */, 10000000L /* 7 */, 100000000L /* 8 */,
            1000000000L /* 9 */, };

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        // key -> the number flag each digit represents a number of [9 - 0]
        // value -> count
        Map<Long, Integer> usedNumbers = new HashMap<>();
        List<Long> cubes = new ArrayList<>();
        cubes.add(0L);
        for (int i = 1;; i++) {
            long cube = (long) Math.pow(i, 3);

            long num = cube;
            Long usedNumber = 0L;
            do {
                int digit = (int) (num % 10);
                usedNumber += USED_NUMBER_FLAG[digit];
                num /= 10;
            } while (num > 0);

            Integer value = usedNumbers.get(usedNumber);
            if (value == null) {
                value = 0;
            } else if (value == input - 1) {
                return Math.pow(cubes.indexOf(usedNumber), 3);
            }
            cubes.add(usedNumber);
            usedNumbers.put(usedNumber, value + 1);
        }

    }

}
