/**
 * 
 */
package org.hamster.project_euler.p101_125;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.base.SolutionUtils;
import org.hamster.project_euler.util.EulerArrayUtils;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P118 implements Solution {

    @Override
    public long solution() {
        List<long[]> list = EulerArrayUtils.permutation(new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        
        System.out.println(list.size());
        
        // when 5 commas, then 1, 2, 3, 5, 7, 9 must be the digit, so the combitation is P4 
        
        
        
        // comma count
        for (long[] seq : list) {
            
        }
        
        return 0;
    }
    
    /**
     * 
     * @param picked
     * @param group
     */
    public void pick(boolean[] picked, int leftGroup) {
    }
    

    /**
     * range from 0 - 987,654,321
     * 
     * @param n
     * @return
     */
    private boolean isPrime(long n) {
        return EulerMathUtils.isProbablePrime(BigInteger.valueOf(n), EulerMathUtils.AR3);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(EulerMathUtils.factorial(9l));
        SolutionUtils.invoke(P118.class, 0L);
    }

}
