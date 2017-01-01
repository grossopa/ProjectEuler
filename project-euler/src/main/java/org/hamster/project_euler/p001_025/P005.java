/**
 * 
 */
package org.hamster.project_euler.p001_025;

import java.util.HashMap;
import java.util.Map;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P005 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution()
     */
    @Override
    public double solution() {
        int [] nums = new int[20];
        for (int i = 1; i <= 20; i++) {
            nums[i - 1] = i;
        }
        return performSolution(nums);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public double solutionTest(double input) {
        return performSolution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
    }

    public double performSolution(int[] nums) {
        Map<Double, Long> maxFactors = new HashMap<>();
        for (int num : nums) {
            Map<Double, Long> factors = EulerMathUtils.primeFactorization(num);
            for (Map.Entry<Double, Long> factor : factors.entrySet()) {
                if (!maxFactors.containsKey(factor.getKey()) || maxFactors.get(factor.getKey()) < factors.get(factor.getKey())) {
                    maxFactors.put(factor.getKey(), factor.getValue());
                }
            }
        }

        double result = 1;
        for (Map.Entry<Double, Long> maxFactor : maxFactors.entrySet()) {
            result *= Math.pow(maxFactor.getKey(), maxFactor.getValue());
        }
        return result;
    }

}
