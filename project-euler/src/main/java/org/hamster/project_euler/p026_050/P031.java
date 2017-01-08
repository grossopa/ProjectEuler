/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P031 implements Solution {

    private int result = 0;

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int[] coins = new int[] { 200, 100, 50, 20, 10, 5, 2, 1 };
        result = 0;
        pick((int) input, 0, coins);
        return result;
    }

    private void pick(int rest, int coinIndex, int[] coins) {
        int coin = coins[coinIndex];
        if (coin == 1) {
            result++;
            return;
        }
        for (int c = 0; c <= rest / coin; c++) {
            int nextRest = rest - coin * c;
            if (nextRest == 0) {
                result++;
            } else {
                pick(nextRest, coinIndex + 1, coins);
            }
        }
    }
}
