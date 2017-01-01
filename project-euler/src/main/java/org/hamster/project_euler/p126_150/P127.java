/**
 * 
 */
package org.hamster.project_euler.p126_150;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * The radical of n, rad(n), is the product of distinct prime factors of n. For example, 504 = 23 × 32 × 7, so rad(504)
 * = 2 × 3 × 7 = 42.<br>
 * 
 * We shall define the triplet of positive integers (a, b, c) to be an abc-hit if:<br>
 * 
 * GCD(a, b) = GCD(a, c) = GCD(b, c) = 1 a < b a + b = c rad(abc) < c
 * 
 * For example, (5, 27, 32) is an abc-hit, because: <br>
 * GCD(5, 27) = GCD(5, 32) = GCD(27, 32) = 1 5 < 27 5 + 27 = 32 rad(4320) = 30 < 32 It turns out that abc-hits are quite
 * rare and there are only thirty-one abc-hits for c < 1000, with ∑c = 12523. <br>
 * 
 * Find ∑c for c < 120000. <br>
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P127 {
    long maxNonPrime = 4;
    LinkedHashSet<Long> primeCache = new LinkedHashSet<Long>(1000);

    Map<Long, Long> radCache = new HashMap<Long, Long>(1000);

    public boolean isABCHit(long a, long b, long c) {
        long r = rad(a) * rad(b) * rad(c);
        return r < c;
    }

    public long rad(long l) {
        if (radCache.containsKey(l)) {
            return radCache.get(l);
        }
        long rad = 1;
        for (long prime : primeCache) {
            if (l % prime == 0) {
                rad *= prime;
            }
        }

        for (long i = maxNonPrime + 1; i <= l; i++) {
            if (isPrime(i)) {
                if (l % i == 0) {
                    rad *= i;
                }
            } else {
                maxNonPrime = i;
            }
        }

        radCache.put(l, rad);

        return rad;
    }

    public boolean isPrime(long n) {
        if (primeCache.contains(n)) {
            return true;
        }
        for (Long prime : primeCache) {
            if (n % prime == 0) {
                return false;
            }
        }
        primeCache.add(n);
        return true;
    }

    public long solution() {

        primeCache.add(2L);
        primeCache.add(3L);

        System.out.println(this.rad(504));
        System.out.println(this.rad(504));

        long result = 0;
        long cbound = 120000;
        for (int a = 1; a < cbound; a++) {
            for (int b = a + 1; a + b < cbound; b++) {
                int c = a + b;
                if (gcd(a, b) != 1 || gcd(a, c) != 1 || gcd(b, c) != 1) {
                    continue;
                }
                if (isABCHit(a, b, c)) {
                    result += c;
                }
            }
        }

        return result;
    }

    private int gcd(int a, int b) {
        int y, x;

        if (a > b) {
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }

        while (x % y != 0) {
            int temp = x;
            x = y;
            y = temp % x;
        }

        return y;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new P127().solution());
    }

}
