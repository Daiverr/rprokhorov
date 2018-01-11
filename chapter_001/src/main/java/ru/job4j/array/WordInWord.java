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
        boolean rslt = false;
        char[] a = origin.toCharArray();
        char[] b = sub.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[0]) {
                char[] c = Arrays.copyOfRange(a, i, i + b.length);
                if (Arrays.equals(c, b)) {
                    rslt = true;
                    break;
                }
            }
        }
        return rslt;
    }
}
