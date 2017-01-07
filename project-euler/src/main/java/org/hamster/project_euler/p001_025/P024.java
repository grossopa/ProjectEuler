/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P024 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int desiredIndex = 1_000_000;

        int[] indexList = new int[10];

        int leftBound = 1;

        // starts with biggest position
        for (int i = 9; i >= 0; i--) {
            double permutationCount = EulerMathUtils.permutationCount(i, i);
            int index = 0;
            while (leftBound < desiredIndex) {
                leftBound += permutationCount;
                index++;
            }

            if (leftBound > desiredIndex) {
                leftBound -= permutationCount;
                index--;
            }
            indexList[i] = index;
        }
        
        boolean[] numberUsed = new boolean[10];
        long result = 0;
        for (int i = 9; i >= 0; i--) {
            int index = indexList[i];
            int cindex = - 1;
            for (int j = 0; j < 10; j++) {
                if (numberUsed[j]) {
                    continue;
                } else {
                    cindex++;
                }
                if (cindex == index) {
                    numberUsed[j] = true;
                    result += j * Math.pow(10, i);
                    break;
                }
            }
        }

        return result;
    }

}
