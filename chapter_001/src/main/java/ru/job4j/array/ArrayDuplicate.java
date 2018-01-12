package ru.job4j.array;
import java.util.Arrays;
/**
 * ArrayDuplicate.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicate {
    public String[] remove(String[] array) {
       int a = 0;
       for (int i = 0; i < array.length; i++) {
           for (int j = i; j < array.length; j++) {
               if (array[i].equals(array[j]) & j != i) {
                   String buffer = array[j];
                   array[j] = array[array.length - 1 - a];
                   array[array.length - 1 - a] = buffer;
                   a++;
                   break;
               }
           }
       }
       return Arrays.copyOf(array, (array.length  -   a));
    }
}
