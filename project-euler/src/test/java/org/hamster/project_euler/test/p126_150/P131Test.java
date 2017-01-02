/**
 * 
 */
package org.hamster.project_euler.test.p126_150;

import org.hamster.project_euler.p126_150.P131;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P131Test extends AbstractSolutionTest<P131> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P131> problemClass() {
        return P131.class;
    }

    /* 
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return TestResult.create(100, 4);
    }

    /* 
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(1000000L, 173);
    }

}
