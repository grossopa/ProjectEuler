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
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public Number solution(double input) {
        int[] nums = new int[(int) input];
        for (int i = 1; i <= (int) input; i++) {
            nums[i - 1] = i;
        }
        return performSolution(nums);
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
