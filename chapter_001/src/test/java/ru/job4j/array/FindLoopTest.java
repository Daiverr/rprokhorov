package ru.job4j.array;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

/**
 * FindLoopTest.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class FindLoopTest {
    @Test
    public void whenElInArratThenIndex() {
        FindLoop fl = new FindLoop();
        int result = fl.indexOf(new int[]{1, 5, 6, 7}, 5);
        int exp = 1;
        assertThat(result, is(exp));
    }

    @Test
    public void whenElNotInArratThenError() {
        FindLoop fl = new FindLoop();
        int result = fl.indexOf(new int[]{1, 5, 6, 7}, 8);
        int exp = -1;
        assertThat(result, is(exp));
    }
}
