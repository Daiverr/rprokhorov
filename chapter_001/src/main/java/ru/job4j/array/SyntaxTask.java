package ru.job4j.array;
import java.util.Arrays;
/**
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SyntaxTask {
   public int[] combine(int[] a, int[] b) {
       int[] c = new int[a.length + b.length];
       System.arraycopy(a, 0, c, 0 ,a.length);
       System.arraycopy(b, 0, c, a.length, b.length);
       Arrays.sort(c);

       return c;
    }
}
