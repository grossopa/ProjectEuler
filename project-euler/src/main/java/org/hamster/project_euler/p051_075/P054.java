/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P054 implements Solution {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        return null;
    }

}

/**
 * represents a rule
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
abstract class Rank {
    private final int rank;

    public Rank(int rank) {
        this.rank = rank;
    }

    abstract boolean match(int[] cards);

    abstract boolean win(int[] cardsP1, int[] cardsP2);

    public int getRank() {
        return this.rank;
    }
}

class Card {

    private Card() {

    }
}

enum CardValue {
    ONE("1", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8",
            8), NINE("9", 9), TEN("T", 10), JACK("J", 11), QUEEN("Q", 12), KING("K", 13), ACE("A", 14);

    private final String key;
    private final int val;

    CardValue(String key, int val) {
        this.key = key;
        this.val = val;
    }

    public static final CardValue of(String key) {
        for (CardValue c : CardValue.values()) {
            if (c.getKey().equals(key)) {
                return c;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public int getVal() {
        return val;
    }
}

enum CardSuit {
    S, C, D, H;
}