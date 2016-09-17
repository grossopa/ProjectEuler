/**
 * 
 */
package org.hamster.project_euler.p101_125;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.base.SolutionUtils;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P111 implements Solution {

    private boolean[] primes;

    /**
     * int[digit][m] = sum;
     */
    private int[][] digitM;

    public long solution() {
        return solutionTest(11); // n + 1
    }

    public long solutionTest(int n) {
        primes = EulerMathUtils.primes((int) Math.pow(10, n - 1));
        int[] tcounts = new int[10];

        digitM = new int[10][n - 1];

        for (int i = primes.length - 1; i >= 0; i--) {
            if (!primes[i]) {
                // clean up
                for (int kk = 0; kk < 10; kk++) {
                    tcounts[kk] = 0;
                }

                // String.valueOf(i); is too slow
                int t = i;
                while (t != 0) {
                    int num = t % 10;
                    tcounts[num]++;
                    t /= 10;
                }

                for (int kk = 0; kk < 10; kk++) {
                    int tc = tcounts[kk];
                    if (tc > 1) {
                        digitM[kk][tc] += i;
                    }
                }
            }
        }

        int result = 0;
        for (int[] digit : digitM) {
            for (int i = digit.length - 1; i >= 0; i--) {
                if (digit[i] != 0) {
                    result += digit[i];
                    break;
                }
            }
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EulerMathUtils.primesBig((long) Math.pow(10, 10) - 1);
        
        SolutionUtils.invokeSolutionTest(P111.class, 273700L, 5);

        //SolutionUtils.invoke(P111.class, 0L);
    }

}
