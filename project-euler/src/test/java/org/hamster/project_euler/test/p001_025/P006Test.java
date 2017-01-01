/**
 * 
 */
package org.hamster.project_euler.test.p001_025;

import org.hamster.project_euler.p001_025.P006;
import org.hamster.project_euler.test.base.AbstractSolutionTest;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P006Test extends AbstractSolutionTest<P006> {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testExample()
     */
    @Override
    public void testExample() {
        invokeTest(2640, 10);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testSolution()
     */
    @Override
    public void testSolution() {
        invoke(25164150);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P006> problemClass() {
        return P006.class;
    }

}
