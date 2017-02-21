/**
 * 
 */
package org.hamster.project_euler.test.p051_075;

import org.hamster.project_euler.p051_075.P073;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P073Test extends AbstractSolutionTest<P073> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return TestResult.create(8, 3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(12000, 7295372);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    protected Class<P073> problemClass() {
        return P073.class;
    }

}
