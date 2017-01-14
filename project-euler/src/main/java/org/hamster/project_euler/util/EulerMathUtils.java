/**
 * 
 */
package org.hamster.project_euler.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class EulerMathUtils {

    public static final BigInteger TWO = BigInteger.valueOf(2);

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

    public static BigInteger combinationCountBig(double m, double n) {
        if (2 * m > n) {
            m = n - m;
        }

        BigInteger result = BigInteger.ONE;
        for (double i = 0; n - i >= n - m + 1; i++) {
            result = result.multiply(BigInteger.valueOf((long) (n - i)));
        }
        return result.divide(factorialBig(m));
    }

    public static double permutationCount(double m, double n) {
        double result = 1;
        for (double i = n; i >= n - m + 1; i--) {
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

    public static final BigInteger factorialBig(double n) {
        BigInteger r = BigInteger.ONE;
        for (long i = 1; i <= n; i++) {
            r = r.multiply(BigInteger.valueOf(i));
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
     * Sieve of Eratosthenes<br>
     * 
     * Finds all primes represented by <tt>boolean[n] == false</tt>
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
        composites[0] = true;
        composites[1] = true;
        return composites;
    }
    
    public static List<Integer> primesAsList(boolean[] composites) {
        List<Integer> result = new LinkedList<>();
        for (int i = 2; i < composites.length; i++) {
            if (!composites[i]) {
                result.add(i);
            }
        }
        return result;
    }
    
    public static List<Integer> primesAsList(int n) {
        boolean[] composites = primes(n);
        return primesAsList(composites);
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
        return isPalindromic(s);
    }
    
    public static final boolean isPalindromic(char[] s) {
        int l = s.length;
        for (int i = 0; i < l / 2; i++) {
            if (s[i] != s[l - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds all prime factors (with count of each)
     * 
     * @param n
     * @return primes / count
     */
    public static final Map<Double, Long> primeFactorization(long n) {
        return primeFactorization((double) n);
    }

    /**
     * Finds all prime factors (with count of each) // TODO is not correct
     * 
     * @param n
     * @return primes / count
     */
    public static final Map<Double, Long> primeFactorization(double n) {
        Map<Double, Long> result = new HashMap<>();
        if (EulerMathUtils.isPrime(n)) {
            result.put(n, 1L);
        }

        double max = Math.sqrt(n);
        double num = n;
        for (double i = 2; i <= max; i++) {
            if (!EulerMathUtils.isPrime(i)) {
                continue;
            }
            while ((int) (num % i) == 0) {
                if (!result.containsKey(i)) {
                    result.put(i, 1L);
                } else {
                    result.put(i, result.get(i) + 1);
                }
                num /= i;
            }
        }
        if (num > 1) {
            result.put(num, 1L);
        }
        return result;
    }

    /**
     * e.g. 12 as 1 + 2 + 3 + 4 + 6 = 16
     * 
     * @param n
     * @return
     */
    public static double divisorSum(double n) {
        double sum = 0;
        for (double i = 1; i <= Math.floor(n / 2); i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * finds all divisors not including n itself
     * 
     * @param n
     * @return
     */
    public static List<Double> divisors(double n) {
        List<Double> result = new ArrayList<>((int) Math.sqrt(n));

        for (double i = 1; i <= Math.floor(n / 2); i++) {
            if (n % i == 0) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * finds digit count
     * 
     * @param n
     * @return
     */
    public static int digitCount(double n) {
        return (int) (Math.log10(n) + 1);
    }
    
    /**
     * gets all digits in an array
     * 
     * @param n
     * @return
     */
    public static int[] digits(double n) {
        int digitCount = digitCount(n);
        int [] digits = new int[digitCount];
        double num = n;
        int index = 0;
        do {
            digits[index++] = (int) (num % 10);
            num = Math.floor(num / 10);
        } while (num > 0);
        return digits;
    }
    
    /**
     * finds first digit
     * 
     * @param n
     * @return
     */
    public static int firstDigit(double n) {
        return (int) (n / Math.pow(10, digitCount(n) - 1));
    }
    
    /**
     * determines a double/float number is actually an Integer
     * @param num
     * @return
     */
    public static boolean isInteger(double num) {
        return Math.abs(num - (long) num) < 0.0000001D;
    }

}
