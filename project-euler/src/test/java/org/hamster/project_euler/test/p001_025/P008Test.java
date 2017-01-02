/**
 * 
 */
package org.hamster.project_euler.test.p001_025;

import org.hamster.project_euler.p001_025.P008;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P008Test extends AbstractSolutionTest<P008> {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P008> problemClass() {
        return P008.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return TestResult.create(4, 5832);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(13, 23514624000D);
    }

}
