/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P019 implements Solution {

    private static final int[] MONTH = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int r = 0;

        int week = 2;

        for (int y = 1900; y <= 2000; y++) {
            for (int m = 1; m <= 12; m++) {
                int monthDayCount = getMonthDayCount(m, y);
                // week 1 for Sunday and 7 for Saturday
                for (int d = 1; d <= monthDayCount; d++, week++) {
                    if (week == 8) {
                        week = 1;
                    }
                    if (y > 1900 && week == 1 && d == 1) {
                        // starts with 1901
                        r++;
                    }
                }
            }
        }

        return r;
    }

    public int getMonthDayCount(int m, int y) {
        if (m != 2 || y % 4 != 0 || (y % 100 == 0 && (int) (y / 100) % 4 != 0)) {
            return MONTH[m];
        } else {
            return MONTH[m] + 1;
        }
    }

}
