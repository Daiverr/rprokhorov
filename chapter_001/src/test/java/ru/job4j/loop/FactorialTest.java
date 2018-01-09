package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * FactorialTest.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class FactorialTest {

    @Test
    public void whenIntFiveThenFactoril120() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        int expect = 120;
        assertThat(result, is(expect));
    }
}
