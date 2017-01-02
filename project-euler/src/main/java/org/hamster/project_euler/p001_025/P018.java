/**
 * 
 */
package org.hamster.project_euler.p001_025;

import java.util.LinkedList;
import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerFileUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P018 implements Solution {

    /**
     * Iterates each number of a line starts from the top, and for each number we should find the biggest sum of previous
     * routine to reach it, thus for item[0] the only routine of the last line is lastSum[0] and for last item[num - 1]
     * the only routine of the last line is position lastSum[lastSum.length - 1], for any element in between there are 2
     * choices and we always choose the larger one.
     */
    @Override
    public Number solution(double input) {
        List<int[]> numbers = getNumbers();

        int[] lastSum = new int[1];
        lastSum[0] = numbers.get(0)[0];

        for (int r = 1; r < numbers.size(); r++) {
            int[] row = numbers.get(r);
            int[] sum = new int[r + 1];

            sum[0] = lastSum[0] + row[0];

            for (int num = 1; num < row.length - 1; num++) {
                sum[num] = Math.max(lastSum[num - 1], lastSum[num]) + row[num];
            }
            sum[row.length - 1] = lastSum[lastSum.length - 1] + row[row.length - 1];
            lastSum = sum;
        }

        int max = 0;
        for (int i = 0; i < lastSum.length; i++) {
            max = max > lastSum[i] ? max : lastSum[i];
        }

        return max;
    }

    private List<int[]> getNumbers() {
        List<int[]> result = new LinkedList<>();

        List<String> lines = EulerFileUtils.readAsLines(getTestFile());
        for (String line : lines) {
            String[] strs = line.split(" ");
            int[] row = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                row[i] = Integer.parseInt(strs[i], 10);
            }
            result.add(row);
        }
        return result;
    }
    
    protected String getTestFile() {
        return "src/main/java/org/hamster/project_euler/p001_025/P018_file.txt";
    }

}
