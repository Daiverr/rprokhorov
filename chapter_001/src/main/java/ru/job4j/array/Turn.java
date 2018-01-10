package ru.job4j.array;
/**
 * Turn.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Turn {
    public int[] back(int[] array) {
        if (array.length % 2 == 0) {
            for (int i = 0; i < (array.length / 2); i++) {
                int buffer = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = buffer;
            }
        } else {
            for (int i = 0; i < ((array.length - 1) / 2); i++) {
                int buffer = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = buffer;
            }
        }
        return array;
    }
}
