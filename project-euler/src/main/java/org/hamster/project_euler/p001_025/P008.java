/**
 * 
 */
package org.hamster.project_euler.p001_025;

import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerFileUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P008 implements Solution {

    /* 
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution()
     */
    @Override
    public double solution() {
        return solutionTest(13);
    }

    /* 
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public double solutionTest(double adjacentLength) {
        List<String> lines = EulerFileUtils.readAsLines("src/main/java/org/hamster/project_euler/p001_025/P008_file.txt");
        
        String numberStr = "";
        for (String l : lines) {
            numberStr += l;
        }
        char[] numbers = numberStr.toCharArray();
        
        double max = 0;
        
        boolean isSkip = false;
        for (int i = 0; i < numbers.length - adjacentLength; i++) {
            double val = 1;
            for (int j = (int) (i + adjacentLength - 1); j >= i; j--) {
                int num = Integer.valueOf(String.valueOf(numbers[j]));
                if (num == 0) {
                    isSkip = true;
                    i = j + 1;
                    break;
                } else {
                    val *= num;
                }
            }
            
            if (isSkip) {
                isSkip = false;
                continue;
            }
            
            if (val > max) {
                max = val;
            }
        }
        
        return max;
    }

}
