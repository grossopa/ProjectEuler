/**
 * 
 */
package org.hamster.project_euler.p026_050;

import java.util.HashSet;
import java.util.Set;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerFileUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P042 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 1; i < 1000; i++) {
            numbers.add((i * (i + 1)) >> 1);
        }
        int result = 0;
        String[] words = EulerFileUtils.readAsLines("src/main/java/org/hamster/project_euler/p026_050/P042_words.txt").get(0).split(",");
        for (String w : words) {
            String word = w.substring(1, w.length() - 1);
            char[] chs = word.toCharArray();
            int sum = 0;
            for (char ch : chs) {
                sum += ch - 'A' + 1;
            }
            if (numbers.contains(sum)) {
                result++;
            }
        }
        return result;
    }

}
