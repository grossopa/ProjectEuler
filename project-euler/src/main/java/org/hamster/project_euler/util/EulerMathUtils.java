/**
 * 
 */
package org.hamster.project_euler.util;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class EulerMathUtils {
    
    /**
     * return n!
     * 
     * @param n
     * @return
     */
    public static final long factorial(long n) {
        long r = 1;
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }
    
    public static final long reverse(long n) {
        String s = String.valueOf(n);
        int l = s.length();
        char[] ca = s.toCharArray();
        char[] re = new char[l];
        for (int i = 0; i < ca.length; i++) {
            re[i] = ca[ca.length - 1 - i];
        }
        if (re[0] == '0') {
            return Long.MIN_VALUE;
        }
        return Long.valueOf(String.valueOf(re));
    }
    
    public static final boolean onlyWithOddNumbers(long n) {
        String s = String.valueOf(n);
        for (char c : s.toCharArray()) {
            if (c == '0' || c == '2' || c == '4' || c =='6' || c == '8') {
                return false;
            }
        }
        return true;
    }
}
