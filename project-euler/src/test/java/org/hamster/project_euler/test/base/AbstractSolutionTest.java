/**
 * 
 */
package org.hamster.project_euler.test.base;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamster.project_euler.base.Solution;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * 
 * @param FixMethodOrder
 *            to ensure example executed prior than solution
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AbstractSolutionTest<P extends Solution> {

    /**
     * 
     * @return the test case for example
     */
    protected abstract TestResult example();

    /**
     * 
     * @return the test case for actual solution
     */
    protected abstract TestResult solution();

    /**
     * 
     * @return the problem class
     */
    protected abstract Class<P> problemClass();

    /**
     * test the give example
     * 
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void testExample() throws InstantiationException, IllegalAccessException {
        TestResult example = example();
        if (example == null) {
            System.out.println(problemClass().getSimpleName() + " Skip example test");
            return;
        }
        invoke(example.getInput(), example.getResult(), false);
    }

    /**
     * text the answer
     * 
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void testSolution() throws InstantiationException, IllegalAccessException {
        TestResult solution = solution();
        if (solution == null) {
            System.out.println(problemClass().getSimpleName() + " Not resolved yet");
            return;
        }
        invoke(solution.getInput(), solution.getResult(), true);
    }

    /**
     * Invokes the <tt>solution</tt> method and verifies the result
     * 
     * @param expectedResult
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public final void invoke(double input, Number expectedResult, boolean showAnswer)
            throws InstantiationException, IllegalAccessException {
        Number result = problemClass().newInstance().solution(input);
        if (showAnswer) {
            System.out.println(problemClass().getSimpleName() + " answer is : " + toBigDecimal(result).toPlainString());
        }

        MatcherAssert.assertThat(toBigDecimal(result),
                Matchers.closeTo(toBigDecimal(expectedResult), BigDecimal.valueOf(0.00001D)));
    }

    protected static BigDecimal toBigDecimal(Number num) {
        if (num instanceof BigDecimal) {
            return (BigDecimal) num;
        }

        if (num instanceof BigInteger) {
            return new BigDecimal((BigInteger) num);
        }

        return BigDecimal.valueOf(num.doubleValue());
    }
}
