/**
 * 
 */
package org.hamster.project_euler.p051_075;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P064 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int result = 0;
        for (int num = 0; num <= input; num++) {
            double sqrt = Math.sqrt(num);
            if (EulerMathUtils.isInteger(sqrt)) {
                continue;
            }

            List<int[]> sequence = new ArrayList<>();

            int first = (int) sqrt;
            int[] calc = new int[] { first, first, 1 };
            sequence.add(Arrays.copyOf(calc, calc.length));

            boolean cycle = false;
            while (true) {
                calc = calculate(num, calc[1], calc[2]);
                for (int i = 1; i < sequence.size(); i++) {
                    int[] seq = sequence.get(i);
                    if (seq[0] == calc[0] && seq[1] == calc[1] && seq[2] == calc[2]) {
                        cycle = true;
                        int count = sequence.size() - i;
                        if (count % 2 == 1) {
                            result++;
                        }
                    }
                }

                if (cycle) {
                    break;
                } else {
                    sequence.add(Arrays.copyOf(calc, calc.length));
                }
            }
        }

        return result;
    }

    /**
     * sqrt(num) - mn<br>
     * --------------------------<br>
     * d<br>
     * 
     * @param mn
     *            minusNumerator
     * @param d
     *            denominator
     * @return {calcnum, calcmn, calcd}
     */
    public int[] calculate(int num, int mn, int d) {
        int denominator = num - mn * mn;
        int dgcd = EulerMathUtils.gcd(denominator, d);
        denominator /= dgcd;
        d /= dgcd;

        int result = 0;
        int tmn = mn;
        while (tmn > 0 || num > tmn * tmn) {
            result++;
            tmn -= denominator;
        }

        // num * num < tmn
        result -= 1;
        tmn += denominator;

        return new int[] { result, -tmn, denominator };
    }

}
