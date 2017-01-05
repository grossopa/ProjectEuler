/**
 * 
 */
package org.hamster.project_euler.test.p001_025;

import org.hamster.project_euler.p001_025.P022;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P022Test extends AbstractSolutionTest<P022> {

    @Test
    public void testCalcNameScore() {
        Assert.assertEquals(49714, new P022().calcNameScore("COLIN", 938));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(0, 871198282);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    protected Class<P022> problemClass() {
        return P022.class;
    }

}
