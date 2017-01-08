/**
 * 
 */
package org.hamster.project_euler.p026_050;

import java.util.HashSet;
import java.util.Set;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P032 implements Solution {

    /**
     * 0 - 9
     */
    public static final int[] NUMBER_FLAG_CACHE = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 };

    /**
     * 1 - 9
     */
    public static final int ALL = 2 | 4 | 8 | 16 | 32 | 64 | 128 | 256 | 512;

    private Set<Integer> products = new HashSet<>();

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        products.clear();
        
        // 2 * 3 = 4
        // 1 * 4 = 5
        permutation59(0, 0, new int[5]);

        int result = 0;
        for (Integer product : products) {
            result += product;
        }
        return result;
    }

    private void permutation59(int usedNumber, int index, int[] picked) {
        for (int i = 1; i <= 9; i++) {
            if ((NUMBER_FLAG_CACHE[i] & usedNumber) != 0) {
                continue;
            }
            int nextUsed = usedNumber | NUMBER_FLAG_CACHE[i];
            picked[index] = i;
            if (index == 4) {
                verify(nextUsed, picked);
            } else {
                permutation59(nextUsed, index + 1, picked);
            }
        }
    }

    private void verify(int usedNumber, int[] picked) {
        for (int t = 0; t < 2; t++) {
            int left = 0;
            int right = 0;

            for (int i = 0; i < 1 + t; i++) {
                left += picked[i] * Math.pow(10, i);
            }

            for (int i = 1 + t; i < 5; i++) {
                right += picked[i] * Math.pow(10, i - 1 - t);
            }

            int multiple = left * right;
            boolean match = true;

            int un = usedNumber;
            do {
                int num = multiple % 10;
                multiple /= 10;
                if ((NUMBER_FLAG_CACHE[num] & un) != 0) {
                    // result contains already used Number
                    match = false;
                    break;
                }
                un = un | NUMBER_FLAG_CACHE[num];
            } while (multiple > 0);

            if (match && ALL == un) {
                products.add(left * right);
            }
        }

    }

}
