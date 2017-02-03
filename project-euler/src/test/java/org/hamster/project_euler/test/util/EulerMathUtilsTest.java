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
        Assert.assertEquals(BigInteger.valueOf(1111154321L), EulerMathUtils.reverseBig(BigInteger.valueOf(1234511111L)));
        Assert.assertEquals(BigInteger.valueOf(54321L), EulerMathUtils.reverseBig(BigInteger.valueOf(12345000L)));
        Assert.assertEquals(BigInteger.valueOf(876543210987654321L), EulerMathUtils.reverseBig(BigInteger.valueOf(1234567890123456780L)));
    }

    @Test
    public void testPerformanceDigitCount() {
        long currentTime = System.currentTimeMillis();
        for (int t = 0; t < 5; t++) {
            for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
                digitCount1(i);
            }
        }

        long currentTime2 = System.currentTimeMillis();
        for (int t = 0; t < 5; t++) {
            for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
                digitCount2(i);
            }
        }

        // t1 wins
        Assert.assertTrue(currentTime < currentTime2);
    }

    public static int digitCount1(int n) {
        return (int) (Math.log10(n) + 1);
    }

    public static int digitCount2(int n) {
        n = Math.abs(n);
        if (n >= 10_000) {
            if (n >= 1_000_000) {
                if (n >= 10_000_000) {
                    return 8;
                } else {
                    return 7;
                }
            } else {
                if (n >= 100_000) {
                    return 6;
                } else {
                    return 5;
                }
            }
        } else {
            if (n >= 100) {
                if (n >= 1000) {
                    return 4;
                } else {
                    return 3;
                }
            } else {
                if (n >= 10) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
    }

    @Test
    public void testEulersTotientFunction() {
        Assert.assertEquals(12, EulerMathUtils.eulersTotientFunction(36));
        Assert.assertEquals(1, EulerMathUtils.eulersTotientFunction(2));
        Assert.assertEquals(2, EulerMathUtils.eulersTotientFunction(3));
        Assert.assertEquals(2, EulerMathUtils.eulersTotientFunction(4));
        Assert.assertEquals(4, EulerMathUtils.eulersTotientFunction(5));
        Assert.assertEquals(2, EulerMathUtils.eulersTotientFunction(6));
        Assert.assertEquals(6, EulerMathUtils.eulersTotientFunction(7));
        Assert.assertEquals(4, EulerMathUtils.eulersTotientFunction(8));
        Assert.assertEquals(6, EulerMathUtils.eulersTotientFunction(9));
        Assert.assertEquals(4, EulerMathUtils.eulersTotientFunction(10));
        
    }

}
