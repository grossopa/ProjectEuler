/**
 * 
 */
package org.hamster.project_euler.p051_075;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerFileUtils;

/**
 * 
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
        Rank[] ranks = getRanks();

        List<String> lines = EulerFileUtils
                .readAsLines("src/main/java/org/hamster/project_euler/p051_075/P054_poker.txt");
        int winP1 = 0;

        for (String line : lines) {
            String[] cardStr = line.split(" ");
            Card[] cardsP1 = new Card[5];
            Card[] cardsP2 = new Card[5];
            for (int i = 0; i < 5; i++) {
                cardsP1[i] = Card.of(cardStr[i]);
            }
            for (int i = 5; i < 10; i++) {
                cardsP2[i - 5] = Card.of(cardStr[i]);
            }

            // order from smallest to largest
            Comparator<Card> comparator = new Comparator<Card>() {

                @Override
                public int compare(Card o1, Card o2) {
                    return Integer.compare(o1.getVal(), o2.getVal());
                }
            };

            Arrays.sort(cardsP1, comparator);
            Arrays.sort(cardsP2, comparator);

            // get rank details for P1 and P2
            int[] rank1 = doRank(cardsP1, ranks);
            int[] rank2 = doRank(cardsP2, ranks);

            // first to compare rank
            if (rank1[0] > rank2[0]) {
                winP1++;
                continue;
            } else if (rank1[0] == rank2[0]) {
                // ranks are equal then compare value
                if (rank1[1] > rank2[1]) {
                    winP1++;
                } else if (rank1[1] == rank2[1]) {
                    // ranks and values are equal then compare one by one
                    // also verified there's no draw game
                    int largest = doLargest(cardsP1, cardsP2);
                    if (largest == 1) {
                        winP1++;
                    }
                }
            }
        }

        return winP1;
    }

    /**
     * 
     * @return the rank calculators in order
     */
    public Rank[] getRanks() {
        Rank[] ranks = new Rank[10];
        ranks[0] = loyalFlush();
        ranks[1] = straightFlush();
        ranks[2] = fourOfAKind();
        ranks[3] = fullHouse();
        ranks[4] = flush();
        ranks[5] = straight();
        ranks[6] = threeOfAKind();
        ranks[7] = twoPairs();
        ranks[8] = onePair();
        ranks[9] = highCard();
        return ranks;
    }

    /**
     * evaluates each rank and returns either -1 for not matching the pattern or the value of the cards under such
     * pattern. It's easy to understand each checker are in right order to focus on YES check and ignore NO check.
     * 
     * @param cards
     * @param ranks
     * @return
     */
    private int[] doRank(Card[] cards, Rank[] ranks) {
        int val = -1;
        int r = -1;
        do {
            r++;
            val = ranks[r].calcValue(cards);
        } while (val == -1);
        return new int[] { 9 - r, val };
    }

    /**
     * compare the largest card
     * 
     * @param cardsP1
     * @param cardsP2
     * @return
     */
    private int doLargest(Card[] cardsP1, Card[] cardsP2) {
        for (int i = cardsP1.length - 1; i >= 0; i--) {
            if (cardsP1[i].getVal() > cardsP2[i].getVal()) {
                return 1;
            } else if (cardsP1[i].getVal() < cardsP2[i].getVal()) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * High Card: Highest value card.
     */
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

    /**
     * One Pair: Two cards of the same value.
     */
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

    /**
     * Two Pairs: Two different pairs.
     */
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

    /**
     * Three of a Kind: Three cards of the same value.
     */
    public Rank threeOfAKind() {
        return new Rank(4) {

            @Override
            public int calcValue(Card[] cards) {
                int num = 0;
                int result = 0;
                for (Card card : cards) {
                    if ((num & card.getVal()) != 0) {
                        // second time meet the number
                        if (result == card.getVal()) {
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

    /**
     * Straight: All cards are consecutive values.
     */
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

    /**
     * Flush: All cards of the same suit.
     */
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

    /**
     * Full House: Three of a kind and a pair.
     */
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

    /**
     * Four of a Kind: Four cards of the same value.
     */
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

    /**
     * Straight Flush: All cards are consecutive values of same suit.
     */
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

    /**
     * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
     */
    public Rank loyalFlush() {
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

    /**
     * represents a rule
     * 
     * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
     * @version 1.0
     */
    public static abstract class Rank {
        private final int rank;

        public Rank(int rank) {
            this.rank = rank;
        }

        abstract public int calcValue(Card[] cards);

        public int getRank() {
            return this.rank;
        }
    }

    public static class Card {
        private final CardValue value;
        private final CardSuit suit;

        private Card(String s) {
            value = CardValue.of(s.substring(0, 1));
            suit = CardSuit.valueOf(s.substring(1));
        }

        public static final Card of(String s) {
            return new Card(s);
        }

        public int getVal() {
            return value.getVal();
        }

        public CardSuit getSuit() {
            return suit;
        }
    }

    public static enum CardValue {
        ONE("1", 1), TWO("2", 2), THREE("3", 4), FOUR("4", 8), FIVE("5", 16), SIX("6", 32), SEVEN("7", 64), EIGHT("8",
                128), NINE("9", 256), TEN("T", 512), JACK("J", 1024), QUEEN("Q", 2048), KING("K", 4096), ACE("A", 8192);

        private final String key;
        private final int val;

        /**
         * 
         * @param key
         * @param val
         *            uses 2-based value for used card check
         */
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

    public static enum CardSuit {
        S, C, D, H;
    }

}
