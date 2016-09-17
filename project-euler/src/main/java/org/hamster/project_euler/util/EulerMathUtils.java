/**
 * 
 */
package org.hamster.project_euler.util;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class EulerMathUtils {

    /**
     * return n!
     * 
     * @param n
     * @return
     */
    public static final long factorial(long n) {
        long r = 1;
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    public static final long reverse(long n) {
        String s = String.valueOf(n);
        int l = s.length();
        char[] ca = s.toCharArray();
        char[] re = new char[l];
        for (int i = 0; i < ca.length; i++) {
            re[i] = ca[ca.length - 1 - i];
        }
        if (re[0] == '0') {
            return Long.MIN_VALUE;
        }
        return Long.valueOf(String.valueOf(re));
    }

    public static final boolean onlyWithOddNumbers(long n) {
        String s = String.valueOf(n);
        for (char c : s.toCharArray()) {
            if (c == '0' || c == '2' || c == '4' || c == '6' || c == '8') {
                return false;
            }
        }
        return true;
    }

    /**
     * finds all primes represented by <tt>boolean[n] == false</tt>
     * 
     * @param n
     * @return the boolean list
     */
    public static boolean[] primes(int n) {
        boolean[] composites = new boolean[n + 1];
        int sqrt = (int) Math.sqrt(n);
        for (int m = 2; m <= sqrt; m++) {
            if (!composites[m]) {
                for (int k = m * m; k <= n; k += m) {
                    composites[k] = true;
                }
            }
        }
        return composites;
    }
    
    public static boolean[][] primesBig(long n) {
        if (n < Integer.MAX_VALUE) {
            throw new IllegalArgumentException("please use primes() instead.");
        }
        int bound = 100000000; // 10^9
        int boundl = ((int) (n / bound));
        boolean[][] composites = new boolean[boundl + 1][bound];
        int sqrt = (int) Math.sqrt(n);
        for (int m = 2; m <= sqrt; m++) {
            if (!composites[0][m]) {
                for (long k = m * m; k <= n; k += m) {
                    int index1 = (int) (k / bound);
                    int index2 = (int) (k - index1 * bound);
                    composites[index1][index2] = true;
                }
            }
        }
        return composites;
    }
}
