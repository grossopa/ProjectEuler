/**
 * 
 */
package org.hamster.project_euler.test.p026_050;

import org.hamster.project_euler.p026_050.P047;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P047Test extends AbstractSolutionTest<P047> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return TestResult.create(2, 14);
    }
    
    @Test
    public void testExample2() throws InstantiationException, IllegalAccessException {
        invoke(3, 644, false);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(4, 134043);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    protected Class<P047> problemClass() {
        return P047.class;
    }

}
