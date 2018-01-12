package ru.job4j.array;
import java.util.Arrays;
/**
 * WordInWord.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class WordInWord {
    boolean contains(String origin, String sub) {
        char[] a = origin.toCharArray();
        char[] b = sub.toCharArray();
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[0]) {
                for (int j = 0; j < b.length; j++) {
                    if (b[j] == a[i + j]) {
                        c++;
                    }
                    else {
                        c = 0;
                    }
                }
            }
        }
        return c == b.length;
    }
}
