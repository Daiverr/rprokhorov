package ru.job4j.loop;
/**
 * Factorial.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Factorial {

    public int calc(int n) {
        int calc = 1;
        for (int i = 1; i <= n; i++) {
            calc = calc * i;
        }
        return calc;
    }
}
