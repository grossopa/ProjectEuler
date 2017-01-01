/**
 * 
 */
package org.hamster.project_euler.test.p101_125;

import org.hamster.project_euler.p101_125.P105;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P105Test extends AbstractSolutionTest<P105> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testExample()
     */
    @Test
    @Override
    public void testExample() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testSolution()
     */
    @Test
    @Override
    public void testSolution() {
        invoke(73702L);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P105> problemClass() {
        return P105.class;
    }

}
