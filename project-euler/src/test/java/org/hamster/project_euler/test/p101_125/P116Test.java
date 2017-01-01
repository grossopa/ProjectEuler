/**
 * 
 */
package org.hamster.project_euler.test.p101_125;

import org.hamster.project_euler.p101_125.P116;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P116Test extends AbstractSolutionTest<P116> {

    @Override
    public Class<P116> problemClass() {
        return P116.class;
    }

    @Test
    @Override
    public void testSolution() {
        invoke(20492570929D);
    }

    @Test
    @Override
    public void testExample() {
        invokeTest(12, 5);
    }
}
