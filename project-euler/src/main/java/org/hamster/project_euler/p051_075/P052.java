/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P052 implements Solution {

    /**
     * Math.pow(10, n) cache to avoid duplicate calculation
     */
    private static final long[] TEN_POW_CACHE = new long[] { 1L, 10L, 100L, 1000L, 10000L, 100_000L, 1_000_000L, 10_000_000L, 100_000_000L, 1_000_000_000L };

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {

        for (int digit = 1;; digit++) {
            long max = (long) (Math.pow(10, digit) / 6);
            for (long i = (long) Math.pow(10, digit - 1); i <= max; i++) {
                long num = i;
                long numCount = numberCounts(num);
                boolean skip = false;
                for (int j = 0; j < 5; j++) {
                    num += i;
                    long numCount2 = numberCounts(num);

                    if (numCount2 != numCount) {
                        skip = true;
                        break;
                    }
                }
                if (!skip) {
                    return i;
                }
            }
        }
    }

    /**
     * uses a 10 digits long to indicate number used counts
     * 
     * @param n
     * @return
     */
    private long numberCounts(long n) {
        long result = 0000000000;
        while (n > 0) {
            result += TEN_POW_CACHE[(int) (n % 10)];
            n /= 10;
        }
        return result;
    }

}
