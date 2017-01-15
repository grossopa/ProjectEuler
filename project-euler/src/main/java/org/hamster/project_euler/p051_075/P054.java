/**
 * 
 */
package org.hamster.project_euler.p051_075;

import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerFileUtils;

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

    public static final int CARD_COUNT = 5;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        Rank[] ranks = new Rank[10];
        ranks[0] = loyalSuit();
        ranks[1] = straightFlush();
        ranks[2] = fourOfAKind();
        ranks[3] = fullHouse();
        ranks[4] = flush();
        ranks[5] = straight();
        ranks[6] = threeOfAKind();
        ranks[7] = twoPairs();
        ranks[8] = onePair();
        ranks[9] = highCard();
        
        List<String> lines = EulerFileUtils.readAsLines("src/main/java/org/hamster/project_euler/p051_075/P054_poker.txt");
        int winP1 = 0;
        
        for (String line : lines) {
            String[] cardStr = line.split(" ");
            Card[] cardsP1 = new Card[5];
            Card[] cardsP2 = new Card[5];
            for (int i = 0; i < 5; i++) {
                cardsP1[i] = Card.of(cardStr[i]);
            }
            for (int i = 5; i < 10; i++) {
                cardsP2[i] = Card.of(cardStr[i]);
            }
            
            
        }

        return null;
    }
    
    private int doFight(Card[] cardsP1, Card[] cardsP2, Rank[] ranks) {
        Rank rank1 = null;
        Rank rank2 = null;
        
        for (Rank rank : ranks) {
            int val1 = rank.calcValue(cardsP1);
            int val2 = rank.calcValue(cardsP2);
        }
    }

    private Rank highCard() {
        return new Rank(1) {

            @Override
            public int calcValue(Card[] cards) {
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
            public int calcValue(Card[] cards) {
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
            public int calcValue(Card[] cards) {
                int num = 0;
                int count = 0;
                int result = -1;
                for (Card card : cards) {
                    if ((num & card.getVal()) != 0) {
                        count++;
                        result = Math.max(card.getVal(), result);
                        if (count == 2) {
                            // not necessary to consider three of a kind
                            return result;
                        }
                    }
                    num = num | card.getVal();
                }
                return -1;
            }
        };
    }

    public Rank threeOfAKind() {
        return new Rank(4) {

            @Override
            public int calcValue(Card[] cards) {
                int num = 0;
                int result = 0;
                for (Card card : cards) {
                    if ((num & card.getVal()) != 0) {
                        // second time meet the number
                        if (result != 0) {
                            // third time meet the number
                            return result;
                        }
                        result = card.getVal();
                    }
                    num = num | card.getVal();
                }
                return -1;
            }

        };
    }

    public Rank straight() {
        return new Rank(5) {

            @Override
            public int calcValue(Card[] cards) {
                if (cards.length != CARD_COUNT) {
                    return -1;
                }

                int num = 0;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (Card card : cards) {
                    min = Math.min(card.getVal(), min);
                    max = Math.max(card.getVal(), max);
                    if ((num & card.getVal()) != 0) {
                        return -1;
                    }
                    num = num | card.getVal();
                }
                /* 2 ^ 4 */
                return max / min == 16 ? max : -1;
            }
        };
    }

    public Rank flush() {
        return new Rank(6) {

            @Override
            public int calcValue(Card[] cards) {
                CardSuit suit = null;
                int max = 0;
                for (Card card : cards) {
                    if (suit == null) {
                        suit = card.getSuit();
                    } else if (suit != card.getSuit()) {
                        return -1;
                    }
                    max = Math.max(max, card.getVal());
                }
                return max;
            }
        };
    }

    public Rank fullHouse() {
        return new Rank(7) {

            @Override
            public int calcValue(Card[] cards) {
                if (cards.length != CARD_COUNT) {
                    return -1;
                }

                int number1 = 0;
                int number1Count = 0;
                int number2 = 0;
                for (Card card : cards) {
                    if (number1 == 0 || number1 == card.getVal()) {
                        number1 = card.getVal();
                        number1Count++;
                    } else if (number2 == 0 || number2 == card.getVal()) {
                        number2 = card.getVal();
                    }
                    return -1;

                }
                return number1Count == 3 ? number1 : number2;
            }
        };
    }

    public Rank fourOfAKind() {
        return new Rank(8) {

            @Override
            public int calcValue(Card[] cards) {
                if (cards.length != CARD_COUNT) {
                    return -1;
                }

                int number1 = 0;
                int number1Count = 0;
                int number2 = 0;
                int number2Count = 0;
                for (Card card : cards) {
                    if (number1 == 0 || number1 == card.getVal()) {
                        number1 = card.getVal();
                        number1Count++;
                    } else if (number2 == 0 || number2 == card.getVal()) {
                        number2 = card.getVal();
                        number2Count++;
                    }
                    return -1;
                }

                if (number1Count == 4) {
                    return number1;
                } else if (number2Count == 4) {
                    return number2;
                } else {
                    return -1;
                }
            }
        };
    }

    public Rank straightFlush() {
        return new Rank(9) {

            @Override
            public int calcValue(Card[] cards) {
                if (cards.length != CARD_COUNT) {
                    return -1;
                }

                int num = 0;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                CardSuit suit = null;
                for (Card card : cards) {
                    min = Math.min(card.getVal(), min);
                    max = Math.max(card.getVal(), max);
                    if ((num & card.getVal()) != 0) {
                        return -1;
                    }

                    if (suit == null) {
                        suit = card.getSuit();
                    } else if (suit != card.getSuit()) {
                        return -1;
                    }
                    num = num | card.getVal();
                }
                /* 2 ^ 4 */
                return max / min == 16 ? max : -1;
            }
        };
    }

    public Rank loyalSuit() {
        return new Rank(10) {

            @Override
            public int calcValue(Card[] cards) {
                if (cards.length != CARD_COUNT) {
                    return -1;
                }

                int num = 0;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                CardSuit suit = null;
                for (Card card : cards) {
                    min = Math.min(card.getVal(), min);
                    max = Math.max(card.getVal(), max);
                    if ((num & card.getVal()) != 0) {
                        return -1;
                    }

                    if (suit == null) {
                        suit = card.getSuit();
                    } else if (suit != card.getSuit()) {
                        return -1;
                    }
                    num = num | card.getVal();
                }
                /* Ace */
                return max == 8192 ? max : -1;
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

    abstract public int calcValue(Card[] cards);

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
    
    public static final Card of(String s) {
        return new Card(s);
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
    ONE("1", 1), TWO("2", 2), THREE("3", 4), FOUR("4", 8), FIVE("5", 16), SIX("6", 32), SEVEN("7", 64), EIGHT("8",
            128), NINE("9", 256), TEN("T", 512), JACK("J", 1024), QUEEN("Q", 2048), KING("K", 4096), ACE("A", 8192);

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