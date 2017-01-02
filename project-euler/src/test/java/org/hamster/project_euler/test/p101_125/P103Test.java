package org.hamster.project_euler.test.p101_125;

import org.hamster.project_euler.p101_125.P103;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;

/**
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P103Test extends AbstractSolutionTest<P103> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P103> problemClass() {
        return P103.class;
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
        return TestResult.create(7, 20313839404245D);
    }

}
