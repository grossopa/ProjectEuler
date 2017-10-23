/**
 * 
 */
package org.hamster.project_euler.test.p051_075;

import org.hamster.project_euler.p051_075.P075;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P075Test extends AbstractSolutionTest<P075> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return TestResult.create(48, 6);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(1_500_000, 161_667);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    protected Class<P075> problemClass() {
        return P075.class;
    }

}
