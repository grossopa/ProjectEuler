/**
 * 
 */
package org.hamster.project_euler.p001_025;

import org.hamster.project_euler.base.Solution;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P017 implements Solution {

    private static final String[] NUMBERS_20 = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

    private static final String[] TENTH = new String[] {
            "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        int count = 0;
        
        for (int i = 1; i <= Math.min(19, input); i++) {
            count += NUMBERS_20[i].length();
        }
        
        for (int i = 20; i < Math.min(99, input); i++) {
            if (i % 10 == 0) {
                count += TENTH[((int)(i / 10) - 2)].length();
            } else {
                count += TENTH[((int)(i / 10) - 2)].length() + NUMBERS_20[i % 10].length();
            }
        }
        
        if (input == 1000) {
            count *= 10;
            
            count += "and".length() * 891;
            
            count += "hundred".length() * 900;
            
            for (int i = 1; i < 10; i++) {
                count += NUMBERS_20[i].length() * 100;
            }
        
            count += "onethousand".length();
        }
        
        return count;
    }

}
