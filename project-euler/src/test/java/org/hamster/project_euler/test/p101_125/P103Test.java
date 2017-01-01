package org.hamster.project_euler.test.p101_125;

import org.hamster.project_euler.p101_125.P103;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.junit.Test;

/**
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P103Test extends AbstractSolutionTest<P103> {

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
        super.invoke(20313839404245D);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    public Class<P103> problemClass() {
        return P103.class;
    }

}
