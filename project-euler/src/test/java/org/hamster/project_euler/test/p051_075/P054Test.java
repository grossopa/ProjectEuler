/**
 * 
 */
package org.hamster.project_euler.test.p051_075;

import org.hamster.project_euler.p051_075.P054;
import org.hamster.project_euler.p051_075.P054.Card;
import org.hamster.project_euler.test.base.AbstractSolutionTest;
import org.hamster.project_euler.test.base.TestResult;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P054Test extends AbstractSolutionTest<P054> {

    private Card[] getCards(String str) {
        String[] strarr = str.split(",");
        Card[] cards = new Card[5];
        for (int i = 0; i < 5; i++) {
            cards[i] = Card.of(strarr[i]);
        }
        return cards;
    }

    @Test
    public void testStraight() {
        int val = new P054().straight().calcValue(getCards("2H,3H,4H,5C,6H"));
        Assert.assertEquals((int) Math.pow(2, 5), val);
    }

    @Test
    public void testThreeOfAKind() {
        int val = new P054().threeOfAKind().calcValue(getCards("4C,6S,6C,8D,8S"));
        Assert.assertEquals((int) -1, val);
    }

    @Test
    public void testThreeOfAKind2() {
        int val = new P054().threeOfAKind().calcValue(getCards("2D,4S,4D,8C,8H"));
        Assert.assertEquals((int) -1, val);
    }

    @Test
    public void testTwoPairs() {
        int val = new P054().twoPairs().calcValue(getCards("2D,4S,4D,8C,8H"));
        Assert.assertEquals((int) Math.pow(2, 7), val);
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
        return TestResult.create(0, 376);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.test.base.AbstractSolutionTest#problemClass()
     */
    @Override
    protected Class<P054> problemClass() {
        return P054.class;
    }

}
