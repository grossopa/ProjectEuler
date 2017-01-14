/**
 * 
 */
package org.hamster.project_euler.test.p026_050;

import org.hamster.project_euler.p026_050.P050;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P050Test extends AbstractSolutionTest<P050> {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return TestResult.create(1000, 953);
    }
    
    @Test
    public void testExample2() throws InstantiationException, IllegalAccessException {
        invoke(100, 41, false);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(1_000_000, 997_651);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    protected Class<P050> problemClass() {
        return P050.class;
    }

}
