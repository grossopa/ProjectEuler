/**
 * 
 */
package org.hamster.project_euler.util;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class EulerMathUtils {

    public static final BigInteger TWO = BigInteger.valueOf(2);
    public static final BigInteger FIVE = BigInteger.valueOf(5);
    public static final BigInteger NINE = BigInteger.valueOf(9);
    public static final BigInteger THREE = BigInteger.valueOf(3);

    public static double combinationCount(double m, double n) {
        if (2 * m > n) {
            m = n - m;
        }

        double result = 1;
        for (double i = 0; n - i >= n - m + 1; i++) {
            result *= n - i;
        }
        return result / EulerMathUtils.factorial(m);
    }
    
    public static double permutationCount(double m, double n) {
        double result = 1;
        for (double i = n; i <= n -m + 1; n++) {
            result *= i;
        }
        return result;
    }

    /**
     * return n!
     * 
     * @param n
     * @return
     */
    public static final double factorial(double n) {
        double r = 1;
        for (double i = 1; i <= n; i++) {
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

    public static final int[] AR1 = new int[] { 2, 3 };
    public static final int[] AR2 = new int[] { 31, 73 };
    public static final int[] AR3 = new int[] { 2, 7, 61 };
    public static final int[] AR4 = new int[] { 2, 3, 5, 7, 11 };
    public static final int[] AR5 = new int[] { 2, 3, 5, 7, 11, 13 };
    public static final int[] AR6 = new int[] { 2, 3, 5, 7, 11, 13, 17 };

    /**
     * Returns a boolean to tell if the number is probable prime<br>
     * It is an implementation of the Rabin-Miller test<br>
     * In order to get a real prime the choice of ar should be made as<br>
     * if n < 1,373,653, it is enough to test ar = {2, 3};<br>
     * if n < 9,080,191, it is enough to test ar = {31, 73};<br>
     * if n < 4,759,123,141, it is enough to test ar = {2, 7, 61};<br>
     * if n < 2,152,302,898,747, it is enough to test ar = {2, 3, 5, 7, 11};<br>
     * if n < 3,474,749,660,383, it is enough to test ar = {2, 3, 5, 7, 11, 13};<br>
     * if n < 341,550,071,728,321, it is enough to test ar = {2, 3, 5, 7, 11, 13, 17}.<br>
     * 
     * @param n
     * @param ar
     * @return
     */
    public static boolean isProbablePrime(BigInteger n, int[] ar) {
        if (/* n <= 1 */ n.compareTo(ONE) <= 0)
            return false;
        if (/* n == 2 */ n.equals(TWO))
            return true;
        if (/* n % 2 == 0 */ n.remainder(TWO).equals(ZERO))
            return false;
        if (/* n < 9 */n.compareTo(NINE) < 0)
            return true;
        if (/* n % 3 == 0 */ n.remainder(THREE).equals(ZERO))
            return false;
        if (/* n % 5 == 0 */ n.remainder(FIVE).equals(ZERO))
            return false;

        for (int i = 0; i < ar.length; i++) {
            if (witness(ar[i], n))
                return false;
        }
        BigInteger.ONE.isProbablePrime(certainty)
        return true;
    }

    private static boolean witness(int a, BigInteger n) {
        int t = 0;
        BigInteger u = n.subtract(ONE);
        while (/* (u & 1) == 0 */ u.and(ONE).equals(ZERO)) {
            t++;
            u = u.shiftRight(1);
        }

        BigInteger xi1 = BigInteger.valueOf(a).modPow(u, n);
        BigInteger xi2;

        for (int i = 0; i < t; i++) {
            xi2 = xi1.multiply(xi1).remainder(n);
            if (xi2.equals(ONE) && !xi1.equals(ONE) && !xi1.equals(n.subtract(ONE))) {
                return true;
            }
            xi1 = xi2;
        }
        if (!xi1.equals(ONE))
            return true;
        return false;
    }
}
