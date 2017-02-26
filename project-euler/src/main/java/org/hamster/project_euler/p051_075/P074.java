/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerArrayUtils;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P074 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int bound = (int) input;
        int result = 0;
        long[] cache = new long[10];
        boolean[] skip = new boolean[bound + 1];

        for (int i = 0; i < 10; i++) {
            cache[i] = (long) EulerMathUtils.factorial(i);
        }

        for (int i = 1; i <= bound; i++) {
            if (skip[i] == true) {
                continue;
            }

            long[] link = new long[61];
            link[0] = i;
            long last = i;
            boolean shouldBreak = false;
            for (int j = 1; j < link.length; j++) {
                long num = calc(last, cache);
                if (EulerArrayUtils.indexOf(link, num) >= 0) {
                    if (j == link.length - 1) {
                        result++;
                    }
                    shouldBreak = true;
                    break;
                } else {
                    if (num < bound) {
                        skip[(int) num] = true;
                    }
                }
                if (shouldBreak) {
                    break;
                }
                last = num;
                link[j] = num;
            }
        }
        return result;
    }

    private long calc(long num, long[] cache) {
        long result = 0;
        while (num > 0) {
            long n = num % 10;
            num /= 10;
            result += cache[(int) n];
        }
        return result;
    }

}
