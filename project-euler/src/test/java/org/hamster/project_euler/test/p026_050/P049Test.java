/**
 * 
 */
package org.hamster.project_euler.test.p026_050;

import org.hamster.project_euler.p026_050.P049;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P049Test extends AbstractSolutionTest<P049> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return TestResult.create(0, 148748178147D);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(1, 296962999629D);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    protected Class<P049> problemClass() {
        return P049.class;
    }

}
