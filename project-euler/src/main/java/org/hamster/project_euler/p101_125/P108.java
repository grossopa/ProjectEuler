/**
 * 
 */
package org.hamster.project_euler.p101_125;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P108 implements Solution {

    /**
     * 1/y + 1/z = 1/n =><br>
     * y = n + n^2/k<br>
     * where k = x - n,
     * 
     * so it's quite clear that k can be divided by n^2 with no remainder. so what we need to find is that¡¶br¡·
     * such n^2 who has more than 1 thousand of combination count of all primes. and considering the<br>
     * duplicated case that x == y then x = 2n, so we need to minus one for the result if i % 2 == 0.
     * 
     * the formula for a number with duplication is C(r + k - 1, r)
     */
    @Override
    public double solutionTest(double minCombinationCount) {
        for (long n = 2;; n++) {
            long t = (long) Math.pow(n, 2);
            long k = 0;
            long total = 0; // total elements
            for (long i = 2; i <= t; i++) {
                boolean isFactor = false;
                while (t % i == 0) {
                    t /= i;
                    isFactor = true;
                    total++;
                }
                if (isFactor) {
                    k++; // types count
                }
            }
            long result = 0;
            for (long r = 1; r <= total; r++) {
                result += combinationSum(r, k);
            }
            
            if (n % 2 == 0) {
                result--;
            }
            
            if (result >= minCombinationCount) {
                return n;
            }
        }
    }
    
    public long combinationSum(long r, long k) {
        // C(r + k - 1, r)
        // (r + k - 1)! / r!(k - 1)!
        // (r + 1)*...*(r + k - 1) / (k - 1)!
        long result = 1;
        for (long rt = r + 1; rt <= r + k - 1; rt++) {
            result *= rt;
        }
        
        result /= EulerMathUtils.factorial(k - 1);
        return result;
        
    }

    @Override
    public double solution() {
        return solutionTest(1001);
    }
/*
    *//**
     * @param args
     *//*
    public static void main(String[] args) {
        SolutionUtils.invokeSolutionTest(P108.class, 4, 3);
        SolutionUtils.invoke(P108.class, 0);
    }*/

}
