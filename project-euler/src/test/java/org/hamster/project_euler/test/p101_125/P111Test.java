/**
 * 
 */
package org.hamster.project_euler.test.p101_125;

import org.hamster.project_euler.p101_125.P111;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P111Test extends AbstractSolutionTest<P111> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testExample()
     */
    @Override
    @Test
    public void testExample() {
        invokeTest(273700D, 4);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testSolution()
     */
    @Override
    @Test
    public void testSolution() {
        invoke(612407567715D);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P111> problemClass() {
        return P111.class;
    }

}
