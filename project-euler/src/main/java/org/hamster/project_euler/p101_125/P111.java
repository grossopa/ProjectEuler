/**
 * 
 */
package org.hamster.project_euler.p101_125;

import java.math.BigInteger;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.base.SolutionUtils;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * FINISHED
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P111 implements Solution {

    private int[] a = new int[] { 2, 3, 5, 7, 11 };

    public long solution() {
        return solutionTest(10);
    }

    public long solutionTest(int n) {

        int[] number = new int[n];
        long result = 0;
        for (int d = 0; d < 10; d++) {
            for (int i = 1; i < n; i++) {
                long sum = recurse(number, d, 0, i, true);
                if (sum > 0) {
                    result += sum;
                    break;
                }
            }
        }
        return result;

    }

    private long checkNumber(int[] number) {
        if (number[0] == 0) {
            return 0;
        }
        long num = 0;

        for (int i = 0; i < number.length; i++) {
            num = num * 10 + number[i];
        }
        return EulerMathUtils.isProbablePrime(BigInteger.valueOf(num), a) ? num : 0;
    }

    private long recurse(int[] number, int basedigit, int startpos, int level, boolean fill) {
        if (level <= 0) {
            return checkNumber(number);
        }

        long res = 0;
        if (fill) {
            for (int pos = 0; pos < number.length; pos++) {
                number[pos] = basedigit;
            }
        }
        for (int pos = startpos; pos < number.length; pos++) {
            for (int val = 0; val < 10; val++) {
                number[pos] = val;
                res += recurse(number, basedigit, pos + 1, level - 1, false);
                number[pos] = basedigit;
            }
        }
        return res;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SolutionUtils.invokeSolutionTest(P111.class, 273700L, 4);
        SolutionUtils.invoke(P111.class, 612407567715L);
    }

}
