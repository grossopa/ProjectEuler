/**
 * 
 */
package org.hamster.project_euler.test.p101_125;

import org.hamster.project_euler.p101_125.P117;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P117Test extends AbstractSolutionTest<P117> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testExample()
     */
    @Test
    @Override
    public void testExample() {
        invokeTest(15, 5);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#testSolution()
     */
    @Test
    @Override
    public void testSolution() {
        invoke(100808458960497D);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P117> problemClass() {
        return P117.class;
    }

}
