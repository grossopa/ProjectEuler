/**
 * 
 */
package org.hamster.project_euler.util;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.hamster.project_euler.p051_075.P064;

/**
 * Contains methods with Function callback
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public final class EulerCallbackUtils {

    /**
     * 
     * @param function
     *            takes each permutation member of the set as parameter and returns boolean to indicate should continue
     *            or terminate.
     * @param n
     */
    public static void permutationDigits(Function<Long, Boolean> function, int n) {
        Integer[] numbers = new Integer[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        permutationDigits(function, numbers);
    }

    /**
     * 
     * @param function
     * @param numbers
     */
    public static void permutationDigits(Function<Long, Boolean> function, int[] numbers) {
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        permutationDigits(function, nums);
    }

    /**
     * 
     * @param function
     *            takes each permutation member of the set as parameter and returns boolean to indicate should continue
     *            or terminate.
     * @param n
     */
    public static void permutationDigits(Function<Long, Boolean> function, Integer[] numbers) {
        new PermutationIter<Integer>(new Function<Integer[], Boolean>() {

            @Override
            public Boolean apply(Integer[] picked) {
                Long num = 0L;
                for (int p = 0; p < picked.length; p++) {
                    num += Double.valueOf(picked[p] * Math.pow(10, picked.length - p - 1)).longValue();
                }
                return function.apply(num);
            }

        }, numbers).permutations(0, 0, new Integer[numbers.length]);
    }

    public static <T> void permutation(Function<T[], Boolean> function, T[] items) {
        T[] picked = Arrays.copyOf(items, items.length);
        for (int i = 0; i < picked.length; i++) {
            picked[i] = null;
        }
        new PermutationIter<T>(function, items).permutations(0, 0, picked);
    }

    private static final class PermutationIter<T> {
        private final T[] items;
        private final Function<T[], Boolean> function;

        private final long[] itemIndex;
        private boolean shouldContinue = true;

        PermutationIter(Function<T[], Boolean> function, T[] items) {
            this.items = items;
            this.function = function;

            int l = items.length;
            itemIndex = new long[l];
            for (int i = 0; i < l; i++) {
                itemIndex[i] = (long) Math.pow(2, i);
            }
        }

        void permutations(long usedItem, int index, T[] picked) {
            if (!shouldContinue) {
                return;
            }
            int l = itemIndex.length;
            for (int i = 0; i < l; i++) {
                long usedIndexValue = itemIndex[i];
                if ((usedIndexValue & usedItem) != 0) {
                    continue;
                }
                long nextUsed = usedItem | usedIndexValue;
                picked[index] = items[i];
                if (index == l - 1) {
                    shouldContinue = function.apply(picked);
                    if (!shouldContinue) {
                        return;
                    }
                } else {
                    permutations(nextUsed, index + 1, picked);
                }
            }
        }
    }

    /**
     * Calculates each iterate of continued fractions and provides a callback to do necessary calculation, see
     * <a href="https://en.wikipedia.org/wiki/Continued_fraction">Wiki:Continued Fraction</a><br>
     * 
     * @param num
     *            the number to do square
     * @param iterations
     *            iterations count
     * @param func
     *            callback function
     */
    public static void continuedFractions(double num, int iterations, ContinuedFractionsCallback func) {
        double sqrt = Math.sqrt(num);
        // simply ignores the numbers with perfect square
        if (EulerMathUtils.isInteger(sqrt)) {
            return;
        }
        List<BigInteger[]> sequence = new ArrayList<>();
        BigInteger bnum = BigInteger.valueOf((long) num);
        BigInteger bsqrt = BigInteger.valueOf((long) sqrt);

        // first iteration pair
        BigInteger[] calc = new BigInteger[] { bsqrt, bsqrt, ONE };
        for (int i = 0; i < iterations; i++) {
            sequence.add(calc);
            boolean result = func.apply(sequence, bsqrt, calc[0], calc[1], calc[2]);
            if (!result) {
                break;
            }
            calc = continuedFractionsCalc(bnum, calc[1], calc[2]);
        }
    }

    /**
     * Callback function for {@link EulerCallbackUtils#continuedFractions(double, int, ContinuedFractionsCallback)}
     * 
     * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
     * @version 1.0
     */
    public static interface ContinuedFractionsCallback {

        /**
         * <tt>
         * a(i) = left + (sqrt - numerator) / denominator
         * </tt>
         * 
         * @see <a href="https://projecteuler.net/problem=64">https://projecteuler.net/problem=64</a> to understand the
         *      principal of calculation
         * @param sequence
         *            sequence[] {left, numerator, denominator} (includes current one)
         * @Param bsqrt sqrt integer value of num
         * @param left
         *            left number
         * @param numerator
         *            the numerator of right side (negative)
         * @param denominator
         *            the denominator of right side (positive)
         * @return should terminate or not
         */
        boolean apply(List<BigInteger[]> sequence, BigInteger bsqrt, BigInteger left, BigInteger numerator,
                BigInteger denominator);
    }

    /**
     * 
     * @see {@link P064#calculate(int, int, int)}
     * @param num
     * @param mn
     * @param d
     * @return
     */
    private static BigInteger[] continuedFractionsCalc(BigInteger num, BigInteger mn, BigInteger d) {
        BigInteger denominator = num.subtract(mn.multiply(mn));
        BigInteger gcd = denominator.gcd(d);
        denominator = denominator.divide(gcd);
        d = d.divide(gcd);

        BigInteger result = ZERO;
        BigInteger tmn = mn;

        while (tmn.compareTo(ZERO) == 1 || num.compareTo(tmn.multiply(tmn)) == 1) {
            result = result.add(ONE);
            tmn = tmn.subtract(denominator);
        }

        result = result.subtract(ONE);
        tmn = tmn.add(denominator);
        return new BigInteger[] { result, ZERO.subtract(tmn), denominator };
    }

}
