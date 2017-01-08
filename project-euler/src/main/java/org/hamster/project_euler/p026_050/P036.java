/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

import static org.hamster.project_euler.util.EulerMathUtils.digitCount;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P036 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int maxDigit = digitCount(input) - 1;

        int result = 0;
        for (int i = 1; i <= maxDigit / 2; i++) {
            int bound = (int) Math.pow(10, i);
            for (int n = 1; n < bound; n += 2) {
                int num = 0;
                int t = n;
                do {
                    int reminder = t % 10;
                    num *= 10;
                    num += reminder;
                    t /= 10;
                } while (t > 0);

                int num1 = (int) (num * bound) + n;
                result += isPalindromicTwoRedix(num1);
                if (i != maxDigit / 2 && digitCount(num1) % 2 == 0) {
                    for (int m = 1; m <= 9; m++) {
                        int num2 = (int) (num * (bound * 10) + m * bound + n);
                        result += isPalindromicTwoRedix(num2);
                    }
                }

            }
        }
        return result + 1 + 3 + 5 + 7 + 9;
    }

    private int isPalindromicTwoRedix(int num) {
        return EulerMathUtils.isPalindromic(Integer.toBinaryString(num).toCharArray()) ? num : 0;
    }

}
