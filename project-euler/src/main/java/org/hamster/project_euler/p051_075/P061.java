/**
 * 
 */
package org.hamster.project_euler.p051_075;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamster.project_euler.base.Solution;

/**
 * Triangle P3,n=n(n+1)/2<br>
 * Square P4,n=n2<br>
 * Pentagonal P5,n=n(3n−1)/2<br>
 * Hexagonal P6,n=n(2n−1)<br>
 * Heptagonal P7,n=n(5n−3)/2<br>
 * Octagonal P8,n=n(3n−2)<br>
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class P061 implements Solution {

    public static final int[] CHAIN_POS = new int[] { 1, 2, 4, 8, 16, 32 };
    public static final int ALL = 1 + 2 + 4 + 8 + 16 + 32;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        List<Map<Integer, List<Integer>>> chains = new ArrayList<>();

        for (int i = 3; i <= 8; i++) {
            Map<Integer, List<Integer>> chain = new HashMap<>();
            chains.add(chain);
            for (int n = 1;; n++) {
                int num = formula(i, n);
                if (num < 1000) {
                    continue;
                } else if (num > 9999) {
                    break;
                }
                int first = num / 100;
                if (!chain.containsKey(first)) {
                    chain.put(first, new ArrayList<>());
                }
                chain.get(first).add(num % 100);
            }
        }

        for (Map.Entry<Integer, List<Integer>> chainEntry : chains.get(0).entrySet()) {
            int first = chainEntry.getKey();
            for (Integer last : chainEntry.getValue()) {
                int sum = findTheOnlyResult(first, last, 0, new int[] { first * 100 + last, 0, 0, 0, 0, 0 },
                        1 /* mark the first chain as used */, chains);
                if (sum != -1) {
                    return sum;
                }
            }
        }

        return -1;
    }

    private int findTheOnlyResult(int first, int previousLast, int index, int[] chainNumbers, int usedChain,
            List<Map<Integer, List<Integer>>> chains) {
        if (usedChain == ALL) {
            int sum = 0;
            for (int num : chainNumbers) {
                sum += num;
            }
            return previousLast == first ? sum : -1;
        }
        for (int i = 1; i < chains.size(); i++) {
            Map<Integer, List<Integer>> chain = chains.get(i);
            int chainPos = CHAIN_POS[i];
            if ((usedChain & chainPos) != 0 || !chain.containsKey(previousLast)) {
                continue;
            }
            for (int last : chain.get(previousLast)) {
                if (index < 5) {
                    chainNumbers[index + 1] = previousLast * 100 + last;
                }
                int result = findTheOnlyResult(first, last, index + 1, chainNumbers, usedChain | chainPos, chains);
                if (result != -1) {
                    return result;
                }
            }
        }
        return -1;
    }

    /**
     * returns the first 2 digits and last 2 digits
     * 
     * @param i
     * @param n
     * @return
     */
    private int formula(int i, int n) {
        int num = 0;

        switch (i) {
        case 3:
            num = triangle(n);
            break;
        case 4:
            num = square(n);
            break;
        case 5:
            num = pentagonal(n);
            break;
        case 6:
            num = hexagonal(n);
            break;
        case 7:
            num = heptagonal(n);
            break;
        case 8:
            num = octagonal(n);
            break;
        default:
            throw new IllegalArgumentException("invalid i : " + i);
        }

        return num;

    }

    private int triangle(int n) {
        return n * (n + 1) / 2;
    }

    private int square(int n) {
        return n * n;
    }

    private int pentagonal(int n) {
        return n * (3 * n - 1) / 2;
    }

    private int hexagonal(int n) {
        return n * (2 * n - 1);
    }

    private int heptagonal(int n) {
        return n * (5 * n - 3) / 2;
    }

    private int octagonal(int n) {
        return n * (3 * n - 2);
    }
}