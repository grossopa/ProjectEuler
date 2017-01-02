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
public class P011 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public Number solution(double input) {
        int[][] numbers = getNumbers();
        
        int row = numbers.length;
        int col = numbers[0].length;
        
        double max = 1;
        
        // left right
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= col - input; j++) {
                double prod = 1;
                for (int c = j; c < j + input; c++) {
                    prod *= numbers[i][c];
                }
                if (max < prod) {
                    max = prod;
                }
            }
        }
        
        // top down
        for (int j = 0; j < col; j++) {
            for (int i = 0; i <= row - input; i++) {
                double prod = 1;
                for (int c = i; c < i + input; c++) {
                    prod *= numbers[c][j];
                }
                
                if (max < prod) {
                    max = prod;
                }
            }
        }
        
        // diagonally left right
        for (int i = 0; i <= row - input; i++) {
            for (int j = 0; j <= col - input; j++) {
                double prod = 1;
                for (int c = 0; c < input; c++) {
                    prod *= numbers[c + i][c + j];
                }
                if (max < prod) {
                    max = prod;
                }
            }
        }
        
     // diagonally right left
        for (int i = row - 1; i >= input - 1; i--) {
            for (int j = 0; j <= col - input; j++) {
                double prod = 1;
                for (int c = 0; c < input; c++) {
                    prod *= numbers[i - c][j + c];
                }
                if (max < prod) {
                    max = prod;
                }
            }
        }
        
        
        return max;
    }
    
    private int[][] getNumbers() {
        List<String> lines = EulerFileUtils.readAsLines("src/main/java/org/hamster/project_euler/p001_025/P011_file.txt");
        
        int[][] result = new int[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String[] nums = lines.get(i).split(" ");
            result[i] = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                result[i][j] = Integer.parseInt(nums[j], 10);
            }
        }
        
        return result;
    }

}
