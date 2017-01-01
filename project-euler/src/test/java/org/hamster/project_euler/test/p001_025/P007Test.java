/**
 * 
 */
package org.hamster.project_euler.test.p001_025;

import org.hamster.project_euler.p001_025.P007;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P007Test extends AbstractSolutionTest<P007> {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testExample()
     */
    @Test
    @Override
    public void testExample() {
        invokeTest(13, 6);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testSolution()
     */
    @Test
    @Override
    public void testSolution() {
        invoke(104743);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P007> problemClass() {
        return P007.class;
    }

}
