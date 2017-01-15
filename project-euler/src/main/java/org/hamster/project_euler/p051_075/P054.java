/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;

/**
 * High Card: Highest value card.<br>
 * One Pair: Two cards of the same value.<br>
 * Two Pairs: Two different pairs.<br>
 * Three of a Kind: Three cards of the same value.<br>
 * Straight: All cards are consecutive values.<br>
 * Flush: All cards of the same suit.<br>
 * Full House: Three of a kind and a pair.<br>
 * Four of a Kind: Four cards of the same value.<br>
 * Straight Flush: All cards are consecutive values of same suit.<br>
 * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.<br>
 * 
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

    private Rank highCard() {
        return new Rank(1) {

            @Override
            public boolean match(Card[] cards) {
                return true;
            }

            @Override
            public Result fight(Card[] cardsP1, Card[] cardsP2) {
                int h1 = getHighestValue(cardsP1);
                int h2 = getHighestValue(cardsP2);
                return Result.of(Integer.compare(h1, h2));
            }

            private int getHighestValue(Card[] cards) {
                int result = -1;
                for (Card c : cards) {
                    result = Math.max(c.getVal(), result);
                }
                return result;
            }

        };
    }

    private Rank onePair() {
        return new Rank(2) {

            @Override
            public boolean match(Card[] cards) {
                int num = 0;
                for (Card card : cards) {
                    if ((num & card.getVal()) != 0) {
                        return true;
                    }
                    num = num | card.getVal();
                }
                return false;
            }

            @Override
            public Result fight(Card[] cardsP1, Card[] cardsP2) {
                return Result.of(Integer.compare(getPairValue(cardsP1), getPairValue(cardsP2)));
            }

            private int getPairValue(Card[] cards) {
                int num = 0;
                for (Card card : cards) {
                    if ((num & card.getVal()) != 0) {
                        return card.getVal();
                    }
                    num = num | card.getVal();
                }
                return -1;
            }

        };
    }

    public Rank twoPairs() {
        return new Rank(3) {

            @Override
            public boolean match(Card[] cards) {
                int num = 0;
                int count = 0;
                for (Card card : cards) {
                    if ((num & card.getVal()) != 0) {
                        count++;
                        if (count == 2) {
                            // not necessary to consider three of a kind
                            return true;
                        }
                    }
                    num = num | card.getVal();
                }
                return false;
            }

            @Override
            public Result fight(Card[] cardsP1, Card[] cardsP2) {
                return Result.of(Integer.compare(getHighestPairValue(cardsP1), getHighestPairValue(cardsP2)));
            }

            private int getHighestPairValue(Card[] cards) {
                int num = 0;
                int max = 0;
                for (Card card : cards) {
                    if ((num & card.getVal()) != 0) {
                        max = Math.max(num, max);
                    }
                    num = num | card.getVal();
                }
                return max;
            }
        };
    }

    public Rank threeOfAKind() {
        return new Rank(4) {

            @Override
            public boolean match(Card[] cards) {
                for (Card card : cards) {
                    
                }
                return false;
            }

            @Override
            public Result fight(Card[] cardsP1, Card[] cardsP2) {
                return null;
            }

        };
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

    abstract public boolean match(Card[] cards);

    abstract public Result fight(Card[] cardsP1, Card[] cardsP2);

    public int getRank() {
        return this.rank;
    }
}

class Card {
    private final CardValue value;
    private final CardSuit suit;

    private Card(String s) {
        value = CardValue.of(s.substring(0, 1));
        suit = CardSuit.valueOf(s.substring(1));
    }

    /**
     * @return the value
     */
    public int getVal() {
        return value.getVal();
    }

    /**
     * @return the suit
     */
    public CardSuit getSuit() {
        return suit;
    }

}

enum CardValue {
    ONE("1", 1), TWO("2", 2), THREE("3", 4), FOUR("4", 8), FIVE("5", 16), SIX("6", 32), SEVEN("7", 64), EIGHT("8", 128), NINE("9", 256), TEN("T",
            512), JACK("J", 1024), QUEEN("Q", 2048), KING("K", 4096), ACE("A", 8192);

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

enum Result {
    WIN(1), LOSE(-1), DRAW(0);

    private final int val;

    Result(int val) {
        this.val = val;
    }

    public static final Result of(int val) {
        for (Result r : Result.values()) {
            if (r.getVal() == val) {
                return r;
            }
        }

        return null;
    }

    public int getVal() {
        return val;
    }

}