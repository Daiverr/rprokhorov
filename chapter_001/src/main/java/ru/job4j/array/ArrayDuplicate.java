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
           for (int j = 0; j < array.length; j++) {
               if (array[i].equals(array[j]) & i != j & !array[j].equals("0")) {
                   array[j] = "0";
                   a++;
               }
           }
       }
       Arrays.sort(array);
       array = Arrays.copyOfRange(array, a, array.length);
       return array;
    }
}
