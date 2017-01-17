/**
 * 
 */
package org.hamster.project_euler.test.p051_075;

import java.math.BigInteger;

import org.hamster.project_euler.p051_075.P056;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P056Test extends AbstractSolutionTest<P056> {

    @Test
    public void testPow() {
        P056 p = new P056();

        long[] buffer = p.doPow(25, 28);
        String s = "";
        for (long b : buffer) {
            if (b == 0) {
                break;
            }
            s = b + s;
        }

        Assert.assertEquals(BigInteger.valueOf(25).pow(28).toString(), s);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#example()
     */
    @Override
    protected TestResult example() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#solution()
     */
    @Override
    protected TestResult solution() {
        return TestResult.create(0, 972);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    protected Class<P056> problemClass() {
        return P056.class;
    }

}
