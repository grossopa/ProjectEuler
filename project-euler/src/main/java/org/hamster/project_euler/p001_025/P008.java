/**
 * 
 */
package org.hamster.project_euler.p001_025;

import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerFileUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P008 implements Solution {

    /* 
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution()
     */
    @Override
    public double solution() {
        return 0;
    }

    /* 
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solutionTest(double)
     */
    @Override
    public double solutionTest(double adjacentLength) {
        List<String> lines = EulerFileUtils.readAsLines("src/main/java/org/hamster/project_euler/p001_025/P008_file.txt");
        
        String numbers = "";
        for (String l : lines) {
            numbers += l;
        }
        
        
        
        return 0;
    }

}
