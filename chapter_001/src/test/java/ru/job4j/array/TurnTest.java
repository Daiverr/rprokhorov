package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * TurnTest.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TurnTest {

    @Test
    public void turnEvenArray() {
        Turn te = new Turn();
        int[] result = te.back(new int[]{1, 2, 3, 4});
        int[] exp = {4, 3, 2, 1};
        assertThat(result, is(exp));
    }

    @Test
    public void turnOddArray() {
        Turn te = new Turn();
        int[] result = te.back(new int[]{1, 2, 3, 4, 5});
        int[] exp = {5, 4, 3, 2, 1};
        assertThat(result, is(exp));
    }
}

