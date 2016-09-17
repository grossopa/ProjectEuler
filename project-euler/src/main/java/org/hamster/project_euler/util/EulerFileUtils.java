/**
 * 
 */
package org.hamster.project_euler.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class EulerFileUtils {
    public static final List<long[]> readAsLong(String path) {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(path));
            String line = null;
            List<long[]> result = new LinkedList<>();
            while ((line = bf.readLine()) != null) {
                String[] sl = line.split(",");
                long[] ll = new long[sl.length];
                for (int i = 0; i < sl.length; i++) {
                    ll[i] = Long.valueOf(sl[i]);
                }
                result.add(ll);
            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }
}
