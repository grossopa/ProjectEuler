/**
 * 
 */
package org.hamster.project_euler.p201_225;

import java.math.BigInteger;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.base.SolutionUtils;

/**
 * .....
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P201 implements Solution {
    
    public void uniqueSum(long[] set, int k) {
        for (int i = 0; i < k; i++) {
            
        }
    }
    
    private int[] sumlist;

    @Override
    public long solution() {
        int[] set = new int[100];
        for (int i = 0; i < set.length; i++) {
            set[i] = (i + 1) * (i + 1);
        }
        
//        set = new int[]{1,3,6,8,10,11};
        int k = 50;
        
        // pick 50 for min
        int min = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            min += set[i];
            max += set[set.length - i - 1];
        }
        
        System.out.println(min);
        System.out.println(max);
        
        sumlist = new int[max + 1];
        
        pickNumber(set, 0, 0, 0, k);
        
        long result = 0;
        for (int i = min; i <= max; i++) {
            if (sumlist[i] == 1) {
                result += i;
            }
        }
        
        return result;
    }
    
    long handled = 0;
    BigInteger handledBig = BigInteger.ZERO;
    
    public void pickNumber(int[] set, int next, int sum, int count, int k) {
        if (count == k) {
            handled++;
            if (handled == 1000000000) {
                handledBig = handledBig.add(BigInteger.valueOf(handled));
                handled = 0;
                System.out.println(handledBig);
            }
            if (sumlist[sum] <= 1) {
                sumlist[sum]++;
            }
            return;
        }
        for (int i = next; i < set.length; i++) {
            pickNumber(set, i + 1, sum + set[i], count + 1, k);
        }
    }
    
    public static void main(String[] args) {
        SolutionUtils.invoke(P201.class, 156L);
    }

}
