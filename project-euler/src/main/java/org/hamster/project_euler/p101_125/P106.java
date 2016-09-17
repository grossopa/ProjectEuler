/**
 * 
 */
package org.hamster.project_euler.p101_125;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.base.SolutionUtils;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * NOT FINISHED
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P106 implements Solution {

    public long combinationCount(int m, int n) {
        if (2 * m > n) {
            m = n - m;
        }

        long result = 1;
        for (int i = 0; n - i >= n - m + 1; i++) {
            result *= n - i;
        }
        return result / EulerMathUtils.factorial(m);

    }

    public long total(int t) {
        long count = 0;
        for (int i = t; i >= (t >> 1) + 1; i--) {
            // total elements to be considered
            for (int j = 1; j <= (i >> 1); j++) {
                // first time pick number
                int rt = t - j;
                for (int k = 1; k <= rt; k++) {
                    System.out.println(j + " " + i + " " + k + " " + rt );
                    count += combinationCount(j, i) * combinationCount(k, rt) * (k == j ? 0.5 : 1);
                }
            }
            
        }

        return count;
    }

    @Override
    public long solution() {
        System.out.println(combinationCount(2, 5));
        
        System.out.println(combinationCount(2, 7) * combinationCount(2, 5) / 2 + combinationCount(3, 7) * combinationCount(3,4) / 2);
        
        System.out.println(total(4));
        System.out.println(total(7));
        return 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SolutionUtils.invoke(P106.class, 0);
    }

}
