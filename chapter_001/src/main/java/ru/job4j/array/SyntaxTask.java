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
       int x = 0;
       int y = 0;
       for(int i=0;i<c.length;i++) {
           if (x==a.length ) {
               System.arraycopy(b, y, c, i, b.length-y);
               break;
           } else if (y==b.length ) {
               System.arraycopy(a, x, c, i, a.length - x);
               break;
           } else if(a[x] < b[y]) {
               c[i] = a[x++];
           } else {
               c[i] = b[y++];
           }
       }
       return c;
   }
}
