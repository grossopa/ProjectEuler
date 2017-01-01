/**
 * 
 */
package org.hamster.project_euler.test.p126_150;

import org.hamster.project_euler.p126_150.P131;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P131Test extends AbstractSolutionTest<P131> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testExample()
     */
    @Test
    @Override
    public void testExample() {
        invokeTest(4L, 100L);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testSolution()
     */
    @Test
    @Override
    public void testSolution() {
        invoke(173L);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P131> problemClass() {
        return P131.class;
    }

}
