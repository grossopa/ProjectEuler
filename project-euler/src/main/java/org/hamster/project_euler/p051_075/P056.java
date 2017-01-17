/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;

/**
 * ok, let's try not use BigInteger...
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P056 implements Solution {

    private static final long BOUND = 10_000_000_000L;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        long result = 0;

        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                long[] number = doPow(a, b);
                long sum = 0;
                for (long num : number) {
                    while (num > 0) {
                        sum += num % 10;
                        num /= 10;
                    }
                }
                result = Math.max(sum, result);
            }
        }

        return result;
    }

    /**
     * calculate pow using long[] for buffer
     * 
     * @param a
     * @param b
     * @return
     */
    public long[] doPow(int a, int b) {
        long[] buffer = new long[25]; // can hold 25 * 10 digits, well that should be enough
        buffer[0] = a;
        for (int i = 1; i < b; i++) {
            for (int bi = 0;; bi++) {
                if (buffer[bi] == 0) {
                    break;
                }
                buffer[bi] = buffer[bi] * a;
            }

            for (int bi = 0;; bi++) {
                if (buffer[bi] == 0) {
                    break;
                }
                // offset the highest digits to next number
                while (buffer[bi] >= BOUND) {
                    buffer[bi] -= BOUND;
                    buffer[bi + 1]++;
                }
            }
        }
        return buffer;
    }

}
