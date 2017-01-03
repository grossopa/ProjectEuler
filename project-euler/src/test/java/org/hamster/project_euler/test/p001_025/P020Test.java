/**
 * 
 */
package org.hamster.project_euler.test.p001_025;

import org.hamster.project_euler.p001_025.P020;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P020Test extends AbstractSolutionTest<P020> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return TestResult.create(10, 27);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(100, 648);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    protected Class<P020> problemClass() {
        return P020.class;
    }

}
