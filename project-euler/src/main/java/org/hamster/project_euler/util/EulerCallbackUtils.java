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

    public static <R> void permutationDigits(Function<Integer, R> function, int n) {
        int[] numbers = new int[n]; 
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        permutationDigits(function, numbers);
    }

    public static <R> void permutationDigits(Function<Integer, R> function, int[] numbers) {
        int l = numbers.length;
        int[] numberIndex = new int[l];
        for (int i = 0; i < l; i++) {
            numberIndex[i] = (int) Math.pow(2, numbers[i]);
        }

        permutationDigits(0, 0, new int[l], numberIndex, numbers, function);

    }

    private static <R> void permutationDigits(int usedNumber, int index, int[] picked, int[] numberIndex, int[] numbers, Function<Integer, R> function) {
        int l = numberIndex.length;
        for (int i = 0; i < l; i++) {
            if ((numberIndex[i] & usedNumber) != 0) {
                continue;
            }
            int nextUsed = usedNumber | numberIndex[i];
            picked[index] = numbers[i];
            if (index == l - 1) {
                int num = 0;
                for (int p = 0; p < picked.length; p++) {
                    num += picked[p] * Math.pow(10, l - p - 1);
                }
                function.apply(num);
            } else {
                permutationDigits(nextUsed, index + 1, picked, numberIndex, numbers, function);
            }
        }
    }
}
