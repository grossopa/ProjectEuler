/**
 * 
 */
package org.hamster.project_euler.test.p001_025;

import org.hamster.project_euler.p001_025.P008;
import org.hamster.project_euler.test.base.AbstractSolutionTest;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P008Test extends AbstractSolutionTest<P008> {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testExample()
     */
    @Override
    public void testExample() {
        invokeTest(5832, 4);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testSolution()
     */
    @Override
    public void testSolution() {
        invoke(23514624000D);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P008> problemClass() {
        return P008.class;
    }

}
