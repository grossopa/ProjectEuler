/**
 * 
 */
package org.hamster.project_euler.test.util;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;

import org.hamster.project_euler.util.EulerCallbackUtils;
import org.hamster.project_euler.util.EulerCallbackUtils.ContinuedFractionsCallback;
import org.hamster.project_euler.util.EulerMathUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class EulerCallbackUtilsTest {

    @Test
    public void tesetPermutation() {
        int[] numbers = new int[] { 2, 4, 6 };
        final long[] result = new long[(int) EulerMathUtils.permutationCount(3, 3)];
        int[] index = new int[] { 0 };
        EulerCallbackUtils.permutationDigits(new Function<Long, Boolean>() {

            @Override
            public Boolean apply(Long t) {
                result[index[0]] = t;
                index[0]++;
                return true;
            }

        }, numbers);

        long prev = -1;
        for (int i = 0; i < result.length; i++) {
            Assert.assertTrue(prev < result[i]);
            prev = result[i];
        }
    }

    @Test
    public void testContinuedFractions() {
        EulerCallbackUtils.continuedFractions(2, 5, new ContinuedFractionsCallback() {

            @Override
            public boolean apply(List<BigInteger[]> sequence, BigInteger bsqrt, BigInteger left, BigInteger numerator,
                    BigInteger denominator) {
                Assert.assertEquals(BigInteger.valueOf(2), left);
                Assert.assertEquals(BigInteger.valueOf(1), numerator);
                Assert.assertEquals(BigInteger.valueOf(1), denominator);
                return true;
            }

        });

        EulerCallbackUtils.continuedFractions(3, 5, new ContinuedFractionsCallback() {

            @Override
            public boolean apply(List<BigInteger[]> sequence, BigInteger bsqrt, BigInteger left, BigInteger numerator,
                    BigInteger denominator) {
                if (sequence.size() % 2 == 1) {
                    Assert.assertEquals(BigInteger.valueOf(1), left);
                    Assert.assertEquals(BigInteger.valueOf(1), numerator);
                    Assert.assertEquals(BigInteger.valueOf(2), denominator);
                } else {
                    Assert.assertEquals(BigInteger.valueOf(2), left);
                    Assert.assertEquals(BigInteger.valueOf(1), numerator);
                    Assert.assertEquals(BigInteger.valueOf(1), denominator);
                }
                return true;
            }

        });
    }
}
