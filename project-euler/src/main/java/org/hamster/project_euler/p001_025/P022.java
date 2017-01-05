/**
 * 
 */
package org.hamster.project_euler.p001_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerFileUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P022 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        String names = EulerFileUtils.readAsLines("src/main/java/org/hamster/project_euler/p001_025/P022_names.txt").get(0);
        double result = 0;

        List<String> nameList = new ArrayList<>();
        for (String n : names.split(",")) {
            nameList.add(n.substring(1, n.length() - 1));
        }

        Collections.sort(nameList);

        int index = 1;
        for (String n : nameList) {
            result += calcNameScore(n, index++);
        }

        return result;
    }

    /**
     * Calculate the name score
     * 
     * @param name
     * @param index
     * @return
     */
    public int calcNameScore(String name, int index) {
        char[] chs = name.toUpperCase().toCharArray();
        int score = 0;
        for (char ch : chs) {
            score += ch - 'A' + 1;
        }
        score *= index;
        return score;
    }

}
