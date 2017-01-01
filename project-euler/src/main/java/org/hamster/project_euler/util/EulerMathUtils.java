/**
 * 
 */
package org.hamster.project_euler.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class EulerMathUtils {

    private EulerMathUtils() {
        // do nothing
    }

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
        for (double i = n; i <= n - m + 1; n++) {
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
        int boundl = (int) (n / bound);
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

    /**
     * Uses default Miller�CRabin primality test
     * 
     * @param n
     * @return true if the number is prime
     */
    public static boolean isPrime(int n) {
        return isPrime(BigInteger.valueOf((int) n));
    }

    /**
     * Uses default Miller�CRabin primality test
     * 
     * @param n
     * @return true if the number is prime
     */
    public static boolean isPrime(long n) {
        return isPrime(BigInteger.valueOf(n));
    }

    /**
     * Uses default Miller�CRabin primality test
     * 
     * @param n
     * @return true if the number is prime
     */
    public static boolean isPrime(BigInteger n) {
        return n.isProbablePrime(15);
    }

    /**
     * Uses default Miller�CRabin primality test
     * 
     * @param n
     * @return true if the number is prime
     */
    public static boolean isPrime(double n) {
        return isPrime(BigDecimal.valueOf(n).toBigInteger());
    }
    
    /**
     * A palindromic number reads the same both ways.
     * 
     * @param n
     * @return
     */
    public static final boolean isPalindromic(long n) {
        char[] s = String.valueOf(n).toCharArray();
        int l = s.length;
        for (int i = 0; i < l / 2; i++) {
            if (s[i] != s[l - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
