/**
 * 
 */
package org.hamster.project_euler.p101_125;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerArrayUtils;

/**
 * FINISHED
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P103 implements Solution {

    /**
     * S(B) �� S(C); that is, sums of subsets cannot be equal.<br>
     * If B contains more elements than C then S(B) > S(C).
     * 
     * @param list
     * @return
     */
    public static boolean isSpecialSum(long[] list) {
        // rule 2:
        // sort list from lowest to highest
        // * simply verify any duplication will terminate the process and return false
        // pick (0, n) from left and (l - n + 1, l - 1) from right where n is:
        // for odd: 1 to ceil(l / 2)
        // O(n)

        int len = list.length;
        long[] sortedlist = Arrays.copyOf(list, len);
        Arrays.sort(sortedlist);

        // check duplication
        if (!EulerArrayUtils.uniqueElements(sortedlist)) {
            return false;
        }

        int bound = (len >> 1) + 1;
        for (int i = 1; i <= bound; i++) {
            long lsum = 0;
            long rsum = 0;
            for (int j = 0; j <= i; j++) {
                lsum += sortedlist[j];
                rsum += sortedlist[len - 1 - j];
            }
            if (len % 2 == 0 && bound - 2 == i) {
                continue;
            }

            rsum -= sortedlist[len - 1 - i];

            if (lsum <= rsum) {
                return false;
            }
        }

        // rule 1:
        // we need to compare all posibilies for
        // {a} - {b}
        // to
        // {a.... n} - {b .... n}
        // where n is from 1 to Math.floor (l / 2)
        // O(n^2)
        List<Long> lists = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            lists.add(list[i]);
        }
        for (int i = 2; i < bound; i++) {
            List<List<Long>> subsets = EulerArrayUtils.combination(lists, i);
            long[] sum = new long[subsets.size()];
            for (int j = 0; j < subsets.size(); j++) {
                sum[j] = EulerArrayUtils.sum(subsets.get(j));
            }
            Arrays.sort(sum);
            if (!EulerArrayUtils.uniqueElements(sum)) {
                return false;
            }
        }

        return true;
    }

    public long[] findNearOptimumSet(int n) {
        long[] next = new long[] { 1 };
        for (int i = 0; i < n - 1; i++) {
            next = findNextOptimumSet(next);
        }

        long sum = EulerArrayUtils.sum(next);
        // let's do test here

        int delta = 1;
        int l = next.length;
        this.next = next;
        this.sum = sum;
        minValue = sum;
        minSet = next;
        
        long[] change = new long[l];

        // what's this magic number 8 ?
        for (int i = delta; i < 8; i++) {
            System.out.println("Adjust delta to " + i);
            buildNext(change, 0, i);
        }

        return minSet;
    }
    
    long[] next = null;
    long sum = 0;
    long minValue = 0;
    long[] minSet = null;

    public void buildNext(long[] change, int i, int delta) {
        for (long j = -delta; j <= delta; j++) {
            change[i] = j;
            if (i == change.length - 1) {
                if (!isNecessary(change, delta)) {
                    continue;
                } else {
                    applyChangeToNext(next, change);
                }
            } else {
                buildNext(change, i + 1, delta);
            }
        }
    }

    /**
     * 
     * 
     * @param change
     * @param delta
     * @return
     */
    private boolean isNecessary(long[] change, int delta) {
        // 1. if sum >= 0
        if (EulerArrayUtils.sum(change) >= minValue - sum) {
            return false;
        }

        // 2. if all number within delta
        boolean negative = false;
        for (long c : change) {
            if (c == delta || c == -delta) {
                negative = true;
            }
        }

        if (!negative) {
            return false;
        }

        // other rules??

        return true;
    }

    private void applyChangeToNext(long[] next, long[] change) {
        long[] copy = Arrays.copyOf(next, next.length);
        
        for (int i = 0; i < next.length; i++) {
            copy[i] += change[i];
        }
        
        if (isSpecialSum(copy)) {
            System.out.println("hit " + minValue);
            this.minSet = copy;
            this.minValue = EulerArrayUtils.sum(copy);
        }
    }

    private static long[] findNextOptimumSet(long[] previous) {
        long middle = previous[previous.length >> 1];
        long[] result = new long[previous.length + 1];
        result[0] = middle;
        for (int i = 1; i < result.length; i++) {
            result[i] = previous[i - 1] + middle;
        }
        return result;
    }

    @Override
    public Number solution(double input) {
//        System.out.println(isSpecialSum(new long[] { 81, 82, 99, 85 }));
//        System.out.println(isSpecialSum(new long[] { 81, 88, 75, 42, 87, 84, 86, 65 }));
//        System.out.println(isSpecialSum(new long[] { 157, 150, 164, 119, 79, 159, 161, 139, 158 }));
//
//        System.out.println(Arrays.toString(findNextOptimumSet(new long[] { 2, 3, 4 })));
//        System.out.println(Arrays.toString(findNextOptimumSet(new long[] { 3, 5, 6, 7 })));
//
        long[] result = findNearOptimumSet((int) input);
        
        long finalResult = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            finalResult += (long) (result[i] * Math.pow(100, result.length - 1 - i));
        }
        return finalResult;
    }

}
