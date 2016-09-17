/**
 * 
 */
package org.hamster.project_euler.p126_150;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.base.SolutionUtils;

/**
 * FINISHED
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P136 implements Solution {
    
    private int[] record;

    @Override
    public long solution() {
        int bound = 50000000 + 1;
        record = new int[bound];
        
        // i is 3a - z
        // j is a + z
        for (int i = 1; i < bound; i++) {
            for (int j = 1; i * j < bound; j++) {
                // a = (i + j) / 4
                // z = (3j - i) / 4
                int temp = (3 * j - i);
                if (temp > 0 && (i + j) % 4 == 0 && temp % 4 == 0) {
                    record[i * j]++;
                }
            }
        }
        
        long result = 0;
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 1) {
                result++;
            }
        }
        
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SolutionUtils.invoke(P136.class, 2544559L);
    }

}
