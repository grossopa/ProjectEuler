/**
 * 
 */
package org.hamster.project_euler.test.util;

import java.math.BigInteger;

import org.hamster.project_euler.util.EulerMathUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class EulerMathUtilsTest {

    @Test
    public void testReverse() {
        Assert.assertEquals(54321L, EulerMathUtils.reverse(12345L));
        Assert.assertEquals(1111154321L, EulerMathUtils.reverse(1234511111L));
        Assert.assertEquals(54321L, EulerMathUtils.reverse(12345000L));
        Assert.assertEquals(876543210987654321L, EulerMathUtils.reverse(1234567890123456780L));
    }

    @Test
    public void testReverseBig() {
        Assert.assertEquals(BigInteger.valueOf(54321L), EulerMathUtils.reverseBig(BigInteger.valueOf(12345L)));
        Assert.assertEquals(BigInteger.valueOf(1111154321L),
                EulerMathUtils.reverseBig(BigInteger.valueOf(1234511111L)));
        Assert.assertEquals(BigInteger.valueOf(54321L), EulerMathUtils.reverseBig(BigInteger.valueOf(12345000L)));
        Assert.assertEquals(BigInteger.valueOf(876543210987654321L),
                EulerMathUtils.reverseBig(BigInteger.valueOf(1234567890123456780L)));
    }
}
