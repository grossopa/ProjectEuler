/**
 * 
 */
package org.hamster.project_euler.test.p001_025;

import org.hamster.project_euler.p001_025.P002;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P002Test extends AbstractSolutionTest<P002> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P002> problemClass() {
        return P002.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return TestResult.create(89, 44);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(4_000_000D, 4613732);
    }

}
