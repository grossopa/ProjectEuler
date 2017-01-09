/**
 * 
 */
package org.hamster.project_euler.test.util;

import java.util.function.Function;

import org.hamster.project_euler.util.EulerCallbackUtils;
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
        final int[] result = new int[(int) EulerMathUtils.permutationCount(3, 3)];
        int[] index = new int[] { 0 };
        EulerCallbackUtils.permutationDigits(new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer t) {
                result[index[0]] = t;
                index[0]++;
                return 1;
            }

        }, numbers);

        int prev = -1;
        for (int i = 0; i < result.length; i++) {
            Assert.assertTrue(prev < result[i]);
            prev = result[i];
        }
    }
}
