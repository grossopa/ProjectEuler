/**
 * 
 */
package org.hamster.project_euler.p001_025;

import java.util.LinkedList;
import java.util.List;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P014 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int bound = (int) input;
        int[] cache = new int[bound];
        cache[1] = 1;
        List<Double> bufferList = new LinkedList<>();
        for (int i = 2; i < bound; i++) {
            double num = i;
            bufferList.clear();
            while (num > 1 && (num >= bound || cache[(int) num] == 0)) {
                bufferList.add(0, num);
                if (num % 2 == 1) {
                    num = 3 * num + 1;
                } else {
                    num /= 2;
                }
            }
            
            int count = cache[(int) num];
            
            int offset = 0;
            for (double buffer : bufferList) {
                if (buffer >= bound) {
                    offset++;
                    continue;
                }
                cache[(int) buffer] = count + (++offset);
            }
        }

        int max = 0;
        int result = 0;
        for (int i = 0; i < cache.length; i++) {
            if (max < cache[i]) {
                max = cache[i];
                result = i;
            }
        }
        
        return result;
    }

}
