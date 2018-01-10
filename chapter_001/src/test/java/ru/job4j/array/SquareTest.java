package ru.job4j.array;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Square.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SquareTest {
    @Test
    public void whenBoundThreeThenResult() {
        Square square = new Square();
        int[] result = square.calculate(4);
        int[] expect = {0, 1, 4, 9};
        assertThat(result, is(expect));
    }
}
