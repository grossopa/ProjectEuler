/**
 * 
 */
package org.hamster.project_euler.p051_075;

import org.hamster.project_euler.base.Solution;
import org.hamster.project_euler.util.EulerFileUtils;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class P059 implements Solution {

    /*
     * (non-Javadoc)
     *
     * @see org.hamster.project_euler.base.Solution#solution(double)
     */
    @Override
    public Number solution(double input) {
        // make a guess for the common word .. lots of guesses
        char[] word1 = "make".toCharArray();
        char[] word2 = "the".toCharArray();
        int chara = 'a';

        String line = EulerFileUtils.readAsLines("src/main/java/org/hamster/project_euler/p051_075/P059_cipher.txt").get(0);
        String[] charStrs = line.split(",");
        int[] chars = new int[charStrs.length];
        for (int i = 0; i < charStrs.length; i++) {
            chars[i] = Integer.parseInt(charStrs[i]);
        }

        int[] password = new int[3];
        for (int a = 0; a < 26; a++) {
            password[0] = chara + a;
            for (int b = 0; b < 26; b++) {
                password[1] = chara + b;
                for (int c = 0; c < 26; c++) {
                    password[2] = chara + c;

                    int idx1 = 0;
                    int idx2 = 0;
                    boolean decrypt1 = false;
                    boolean decrypt2 = false;
                    int passIndex = 0;
                    int result = 0;
                    for (int i = 0; i < chars.length; i++) {
                        int xor = chars[i] ^ password[passIndex++];
                        result += xor;
                        if (passIndex == 3) {
                            passIndex = 0;
                        }
                        if (!decrypt1) {
                            if (word1[idx1] == xor) {
                                idx1++;
                            } else {
                                idx1 = 0;
                            }
                            if (idx1 == word1.length) {
                                decrypt1 = true;
                            }
                        }
                        
                        if (!decrypt2) {
                            if (word2[idx2] == xor) {
                                idx2++;
                            } else {
                                idx2 = 0;
                            }
                            if (idx2 == word2.length) {
                                decrypt2 = true;
                            }
                        }
                    }

                    if (decrypt2 && decrypt1) {
                        return result;
                    }

                }
            }
        }

        return -1;
    }

}
