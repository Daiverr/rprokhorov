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
       int v = 0;
       System.arraycopy(a, 0, c, 0, a.length);
       for(int i = 0; ; i++) {
           if(b[i] < c[i]) {

           }
       }
       return c;
    }
    public static void main(String[] args) {
       int[] n = new SyntaxTask().combine(new int[]{1,2,3,4,5}, new int[]{3,5,9,11});
       for(int i: n) {
           System.out.println(i);
       }
    }
}
