package ru.job4j.array;
/**
 * Square.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Square {
    public int[] calculate(int bound) {
        int[] rslt = new int[bound];
        for (int i = 0; i < bound; i++) {
            rslt[i] = i * i;
        }
        return rslt;
    }
}
