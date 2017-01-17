/**
 * 
 */
package org.hamster.project_euler.p051_075;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P055 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int bound = (int) input;
        boolean[] flags = new boolean[bound + 1];
        BigInteger max = BigInteger.valueOf(bound);
        for (int i = 1; i <= input; i++) {
            if (flags[i] == true) {
                continue;
            }
            List<Integer> numberCache = new LinkedList<>();
            numberCache.add(i);
            BigInteger value = BigInteger.valueOf(i);
            for (int j = 0; j <= 50; j++) {
                BigInteger reverse = EulerMathUtils.reverseBig(value);
                if (reverse.equals(value) && j != 0) {
                    // remove last one Lychrel number
                    if (numberCache.get(numberCache.size() - 1) == value.intValue()) {
                        numberCache.remove(numberCache.size() - 1);
                    }
                    for (Integer cache : numberCache) {
                        flags[cache] = true;
                    }

                    break;
                } else {
                    value = reverse.add(value);
                    if (value.compareTo(max) <= 0) {
                        numberCache.add(value.intValue());
                    }
                }
            }
        }

        int result = 0;
        for (boolean flag : flags) {
            if (!flag) {
                result++;
            }
        }

        return result - 1;
    }

}
