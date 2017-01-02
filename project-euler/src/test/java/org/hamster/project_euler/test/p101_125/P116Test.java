/**
 * 
 */
package org.hamster.project_euler.test.p101_125;

import org.hamster.project_euler.p101_125.P116;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P116Test extends AbstractSolutionTest<P116> {

    /*
     * 
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P116> problemClass() {
        return P116.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return TestResult.create(5, 12);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(50, 20492570929D);
    }
}
