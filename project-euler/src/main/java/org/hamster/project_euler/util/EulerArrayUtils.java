/**
 * 
 */
package org.hamster.project_euler.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class EulerArrayUtils {

    /**
     * get n! permutation of the elements of array a (not in order)
     * 
     * @param s
     */
    public static List<long[]> permutation(long[] s) {
        int l = s.length;
        List<long[]> r = new ArrayList<>((int) EulerMathUtils.factorial(l));
        permutation(Arrays.copyOf(s, l), l, r);
        return r;
    }

    private static void permutation(long[] a, int n, List<long[]> r) {
        if (n == 1) {
            r.add(Arrays.copyOf(a, a.length));
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            permutation(a, n - 1, r);
            swap(a, i, n - 1);
        }
    }

    private static void swap(long[] a, int i, int j) {
        long c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static <T> List<List<T>> combination(List<T> values, int size) {

        if (0 == size) {
            return Collections.singletonList(Collections.<T> emptyList());
        }

        if (values.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<T>> combination = new LinkedList<>();

        T actual = values.iterator().next();

        List<T> subSet = new LinkedList<>();
        subSet.addAll(values);
        subSet.remove(actual);

        List<List<T>> subSetCombination = combination(subSet, size - 1);

        for (List<T> set : subSetCombination) {
            List<T> newSet = new LinkedList<>();
            newSet.addAll(set);
            newSet.add(0, actual);
            combination.add(newSet);
        }

        combination.addAll(combination(subSet, size));

        return combination;
    }

    public static final long sum(long[] set) {
        long result = 0;
        for (long l : set) {
            result += l;
        }
        return result;
    }

    public static final long sum(Iterable<Long> set) {
        long result = 0;
        for (long l : set) {
            result += l;
        }
        return result;
    }

    public static final boolean uniqueElements(long[] sortedlist) {
        for (int i = 1; i < sortedlist.length; i++) {
            if (sortedlist[i] == sortedlist[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static final int indexOf(long[] list, long num) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == num) {
                return i;
            }
        }
        return -1;
    }

}
