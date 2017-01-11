/**
 * 
 */
package org.hamster.project_euler.util;

import java.util.function.Function;

/**
 * Contains methods with Function callback
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public final class EulerCallbackUtils {

    public static void permutationDigits(Function<Long, Boolean> function, int n) {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        permutationDigits(function, numbers);
    }

    public static void permutationDigits(Function<Long, Boolean> function, int[] numbers) {
        int l = numbers.length;
        int[] numberIndex = new int[l];
        for (int i = 0; i < l; i++) {
            numberIndex[i] = (int) Math.pow(2, numbers[i]);
        }

        new PermutationIterator(numberIndex, numbers, function).permutationDigits(0, 0, new int[l]);
    }

    private static final class PermutationIterator {
        private final int[] numberIndex;
        private final int[] numbers;
        private final Function<Long, Boolean> function;
        private boolean shouldContinue = true;

        PermutationIterator(int[] numberIndex, int[] numbers, Function<Long, Boolean> function) {
            this.numberIndex = numberIndex;
            this.numbers = numbers;
            this.function = function;
        }

        void permutationDigits(int usedNumber, int index, int[] picked) {
            if (!shouldContinue) {
                return;
            }
            int l = numberIndex.length;
            for (int i = 0; i < l; i++) {
                if ((numberIndex[i] & usedNumber) != 0) {
                    continue;
                }
                int nextUsed = usedNumber | numberIndex[i];
                picked[index] = numbers[i];
                if (index == l - 1) {
                    long num = 0;
                    for (int p = 0; p < picked.length; p++) {
                        num += picked[p] * Math.pow(10, l - p - 1);
                    }
                    shouldContinue = function.apply(num);
                    if (!shouldContinue) {
                        return;
                    }
                } else {
                    permutationDigits(nextUsed, index + 1, picked);
                }
            }
        }
    }

}
