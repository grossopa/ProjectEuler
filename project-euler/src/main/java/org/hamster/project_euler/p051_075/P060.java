/**
 *
 */
package org.hamster.project_euler.p051_075;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerMathUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P060 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        boolean isExample = input == 4D;
        boolean[] composites = EulerMathUtils.primes(isExample ? 1_000_000 : 100_000_000);
        // let's make a grave guess that we could solve the question within 10000
        List<Integer> primesList = EulerMathUtils.primesAsList(isExample ? 1_000 : 10_000);
        primesList.remove(0); // 2
        primesList.remove(1); // 5
        Integer[] primes = primesList.toArray(new Integer[] {});

        // 1. to find out all pairs
        Set<Pair> pairs = new HashSet<>();
        for (int i = 0; i < primes.length; i++) {
            int prime1 = primes[i];
            int primeDigit1 = EulerMathUtils.digitCount(prime1);
            for (int j = i + 1; j < primes.length; j++) {
                int prime2 = primes[j];
                int primeDigit2 = EulerMathUtils.digitCount(prime2);
                if (doVerify(prime1, primeDigit1, prime2, primeDigit2, composites)) {
                    pairs.add(Pair.of(prime1, prime2));
                }
            }
        }

        Set<Pairs> pairsOfPairList = new HashSet<>();
        // 2. find out pairs of pairs
        for (Pair p1 : pairs) {
            for (Pair p2 : pairs) {
                if (p1.hasDuplicate(p2)) {
                    continue;
                }

                if (!doVerify(p1.getPrime1(), p1.getDigit1(), p2.getPrime1(), p2.getDigit1(), composites)) {
                    continue;
                }
                if (!doVerify(p1.getPrime1(), p1.getDigit1(), p2.getPrime2(), p2.getDigit2(), composites)) {
                    continue;
                }
                if (!doVerify(p1.getPrime2(), p1.getDigit2(), p2.getPrime2(), p2.getDigit2(), composites)) {
                    continue;
                }
                if (!doVerify(p1.getPrime2(), p1.getDigit2(), p2.getPrime1(), p2.getDigit1(), composites)) {
                    continue;
                }

                pairsOfPairList.add(Pairs.of(p1, p2));
            }
        }

        int minSum = Integer.MAX_VALUE;
        if (isExample) {
            for (Pairs pairsOfPair : pairsOfPairList) {
                int sum = pairsOfPair.getPair1().getPrime1() + pairsOfPair.getPair1().getPrime2()
                        + pairsOfPair.getPair2().getPrime1() + pairsOfPair.getPair2().getPrime2();
                minSum = Math.min(sum, minSum);
            }
        } else {
            Map<Integer, Pairs> matchResults = new HashMap<>();

            List<Integer> candidatePrimes = new ArrayList<>();
            for (Pairs pairsOfPair : pairsOfPairList) {
                candidatePrimes.add(pairsOfPair.getPair1().getPrime1());
                candidatePrimes.add(pairsOfPair.getPair1().getPrime2());
                candidatePrimes.add(pairsOfPair.getPair2().getPrime1());
                candidatePrimes.add(pairsOfPair.getPair2().getPrime2());
            }

            for (int prime : candidatePrimes) {
                int digit = EulerMathUtils.digitCount(prime);
                for (Pairs pairsOfPair : pairsOfPairList) {
                    Pair pair1 = pairsOfPair.getPair1();
                    Pair pair2 = pairsOfPair.getPair2();
                    if (pair1.getPrime1() == prime || pair1.getPrime2() == prime || pair2.getPrime1() == prime
                            || pair2.getPrime2() == prime) {
                        continue;
                    }

                    if (!doVerify(pair1.getPrime1(), pair1.getDigit1(), prime, digit, composites)) {
                        continue;
                    }
                    if (!doVerify(pair1.getPrime2(), pair1.getDigit2(), prime, digit, composites)) {
                        continue;
                    }
                    if (!doVerify(pair2.getPrime1(), pair2.getDigit1(), prime, digit, composites)) {
                        continue;
                    }
                    if (!doVerify(pair2.getPrime2(), pair2.getDigit2(), prime, digit, composites)) {
                        continue;
                    }

                    matchResults.put(prime, pairsOfPair);
                }
            }
            for (Map.Entry<Integer, Pairs> entry : matchResults.entrySet()) {
                Pairs pairsOfPair = entry.getValue();
                int sum = pairsOfPair.getPair1().getPrime1() + pairsOfPair.getPair1().getPrime2()
                        + pairsOfPair.getPair2().getPrime1() + pairsOfPair.getPair2().getPrime2() + entry.getKey();
                minSum = Math.min(sum, minSum);
            }
        }
        return minSum;
    }

    private boolean doVerify(int p1, int pd1, int p2, int pd2, boolean[] composites) {
        int num1 = (int) (p1 + p2 * Math.pow(10, pd1));
        if (!composites[num1]) {
            int num2 = (int) (p2 + p1 * Math.pow(10, pd2));
            return !composites[num2];
        }
        return false;
    }

}

class Pairs {
    private final Pair pair1;
    private final Pair pair2;

    public static final Pairs of(Pair pair1, Pair pair2) {
        return new Pairs(pair1, pair2);
    }

    public Pairs(Pair pair1, Pair pair2) {
        this.pair1 = pair1;
        this.pair2 = pair2;
    }

    public boolean hasDuplicate(Pairs other) {
        return this.pair1.equals(other.pair1) || this.pair1.equals(other.pair2) || this.pair2.equals(other.pair1)
                || this.pair2.equals(other.pair2);
    }

    public Pair getPair1() {
        return pair1;
    }

    public Pair getPair2() {
        return pair2;
    }

    @Override
    public String toString() {
        return "{" + pair1.toString() + ", " + pair2.toString() + "}";
    }

}

class Pair {

    /**
     * create a pair object
     * 
     * @param prime1
     * @param prime2
     * @return
     */
    public static final Pair of(int prime1, int prime2) {
        return new Pair(prime1, prime2);
    }

    private final int prime1;
    private final int prime2;
    private final int digit1;
    private final int digit2;

    private Pair(int prime1, int prime2) {
        this.prime1 = prime1;
        this.prime2 = prime2;
        this.digit1 = EulerMathUtils.digitCount(prime1);
        this.digit2 = EulerMathUtils.digitCount(prime2);
    }

    public int getPrime1() {
        return prime1;
    }

    public int getPrime2() {
        return prime2;
    }

    public int getDigit1() {
        return digit1;
    }

    public int getDigit2() {
        return digit2;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + prime1;
        result = prime * result + prime2;
        return result;
    }

    /**
     * determines whether they have used the same numbers in common.
     * 
     * @param other
     * @return
     */
    public boolean hasDuplicate(Pair other) {
        return prime1 == other.prime1 || prime1 == other.prime2 || prime2 == other.prime1 || prime2 == other.prime2;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pair other = (Pair) obj;
        if (prime1 != other.prime1) {
            return false;
        }
        if (prime2 != other.prime2) {
            return false;
        }
        // ignore ordered comparing
        if (prime1 == other.prime2 && prime2 == other.prime1) {
            return true;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + prime1 + ", " + prime2 + "]";
    }

}
