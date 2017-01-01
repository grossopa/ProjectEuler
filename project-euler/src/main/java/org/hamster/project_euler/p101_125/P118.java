/**
 * 
 */
package org.hamster.project_euler.p101_125;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerArrayUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P118 implements Solution {

    @Override
    public double solution() {
        List<Long> arr = new ArrayList<>();
        arr.add(1L);
        arr.add(2L);
        arr.add(3L);
        arr.add(4L);
        arr.add(5L);
        arr.add(6L);
        arr.add(7L);
        arr.add(8L);
        arr.add(9L);
        long result = pick(arr, 0, 1);
        return result;
    }

    /**
     * 
     * @param picked
     * @param group
     */
    public long pick(List<Long> left, int last, int lastCount) {
        long result = 0;

        if (left.isEmpty()) {
            return 1;
        }

        for (int i = lastCount; i < left.size() + 1; i++) {
            List<List<Long>> combinations = EulerArrayUtils.combination(left, i);
            for (List<Long> comb : combinations) {
                List<long[]> permutation = EulerArrayUtils.permutation(toArray(comb));
                for (long[] per : permutation) {
                    long num = toNumber(per);
                    if (num < last || !isPrime(num)) {
                        continue;
                    }

                    List<Long> next = new ArrayList<>();
                    next.addAll(left);
                    next.removeAll(comb);
                    result += pick(next, (int) num, i);
                }
            }
        }

        return result;
    }

    public long[] toArray(List<Long> arr) {
        long[] r = new long[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            r[i] = arr.get(i);
        }
        return r;
    }

    public long toNumber(long[] numbers) {
        long result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += (long) numbers[i] * Math.pow(10, i);
        }
        return result;
    }

    public long toNumber(List<Long> numbers) {
        long result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            result += (long) numbers.get(i) * Math.pow(10, i);
        }
        return result;
    }

    /**
     * range from 0 - 987,654,321
     * 
     * @param n
     * @return
     */
    private boolean isPrime(long n) {
        return BigInteger.valueOf(n).isProbablePrime(10);
        // this is not correct????
        // return EulerMathUtils.isProbablePrime(BigInteger.valueOf(n), EulerMathUtils.AR6);
    }

    /* (non-Javadoc)
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public double solutionTest(double input) {
        return 0;
    }

}
