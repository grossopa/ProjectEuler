/**
 * 
 */
package org.hamster.project_euler.p026_050;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P045 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {

        long t = 285;
        long p = 165;
        long h = 143;

        long result = 0;

        if (input == 0) {
            t++;
        }

        long vt = 0;
        long vp = 0;
        long vh = 0;

        while (true) {
            if (vt == 0) {
                vt = t * (t + 1) / 2;
            }
            if (vp == 0) {
                vp = p * (3 * p - 1) / 2;
            }
            if (vh == 0) {
                vh = h * (2 * h - 1);
            }

            long min = Math.min(Math.min(vt, vp), vh);
            if (vt == vp && vp == vh) {
                result = vt;
                break;
            } else if (vt == min) {
                vt = 0;
                t++;
            } else if (vp == min) {
                vp = 0;
                p++;
            } else if (vh == min) {
                vh = 0;
                h++;
            }
        }

        return result;
    }

}
