/**
 * 
 */
package org.hamster.project_euler.p001_025;

import java.math.BigInteger;
import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerFileUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P013 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        List<String> numberStrs = getNumbers();

        BigInteger result = BigInteger.ZERO;
        for (String s : numberStrs) {
            result = result.add(new BigInteger(s));
        }
        return Double.parseDouble(result.toString(10).substring(0, 10));
    }

    private List<String> getNumbers() {
        return EulerFileUtils.readAsLines("src/main/java/org/hamster/project_euler/p001_025/P013_file.txt");
    }

}
