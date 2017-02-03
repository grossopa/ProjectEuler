/**
 * 
 */
package org.hamster.project_euler.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class EulerMathUtils {

    public static final BigInteger TWO = BigInteger.valueOf(2);
    public static final BigInteger ZERO = BigInteger.ZERO;
    public static final BigInteger ONE = BigInteger.ONE;
    public static final BigInteger TEN = BigInteger.valueOf(10);

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

    public static final long reverseNoLeadingZero(long n) {
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

    public static final long reverse(long num) {
        long result = 0;
        while (num > 0) {
            long n = num % 10;
            result = result * 10 + n;
            num = num / 10;
        }
        return result;
    }

    public static final BigInteger reverseBig(BigInteger num) {
        BigInteger result = ZERO;
        while (num.compareTo(ZERO) == 1) {
            BigInteger n = num.remainder(TEN);
            result = result.multiply(TEN).add(n);
            num = num.divide(TEN);
        }
        return result;
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
     * gets prime factors
     * 
     * @param numbers
     * @return
     */
    public static List<Long> primeFactors(long num) {
        long n = num;
        List<Long> factors = new ArrayList<>();
        for (long i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    /**
     * gets prime factors of a number and remove duplication
     * 
     * @param num
     * @return
     */
    public static Set<Long> primeFactorsSet(long num) {
        long n = num;
        Set<Long> factors = new LinkedHashSet<>();
        for (long i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
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
        int[] digits = new int[digitCount];
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
     * 
     * @param num
     * @return
     */
    public static boolean isInteger(double num) {
        return !Double.isNaN(num) && !Double.isInfinite(num) && num == Math.rint(num);
    }

    /**
     * Euclidean algorithm
     * 
     * @param a
     * @param b
     * @return
     */
    public static double gcd(double a, double b) {
        if (a == 0) {
            return b;
        }

        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a;
    }

    /**
     * Euclidean algorithm
     * 
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a, long b) {
        return (long) gcd((double) a, (double) b);
    }

    /**
     * Euclidean algorithm
     * 
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        return (int) gcd((double) a, (double) b);
    }

    /**
     * Copied from http://stackoverflow.com/questions/2685524/check-if-biginteger-is-not-a-perfect-square<br>
     * 
     * Computes the integer square root of a number.
     *
     * @param n
     *            The number.
     *
     * @return The integer square root, i.e. the largest number whose square doesn't exceed n.
     */
    public static BigInteger sqrt(BigInteger n) {
        if (n.signum() >= 0) {
            final int bitLength = n.bitLength();
            BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

            while (!isSqrt(n, root)) {
                root = root.add(n.divide(root)).divide(TWO);
            }
            return root;
        } else {
            throw new ArithmeticException("square root of negative number");
        }
    }

    /**
     * Copied from http://stackoverflow.com/questions/2685524/check-if-biginteger-is-not-a-perfect-square<br>
     * 
     * @param n
     * @param root
     * @return
     */
    private static boolean isSqrt(BigInteger n, BigInteger root) {
        final BigInteger lowerBound = root.pow(2);
        final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);
        return lowerBound.compareTo(n) <= 0 && n.compareTo(upperBound) < 0;
    }

    /**
     * Euler's totient function
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Euler%27s_totient_function">https://en.wikipedia.org/wiki/Euler%27s_totient_function</a>
     * @param num
     * @return
     */
    public static long eulersTotientFunction(long num) {
        Set<Long> primeFactors = primeFactorsSet(num);
        long n = num;
        for (Long pf : primeFactors) {
            n = n * (pf - 1) / pf;
        }
        return n;
    }

}
