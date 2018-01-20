package ru.job4j.pseudo;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TriangleTest {
    @Test
    public void whenDrawTriagle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(),
                is(
                        new StringBuilder()
                                .append("  +  ")
                                .append(System.lineSeparator())
                                .append(" +++ ")
                                .append(System.lineSeparator())
                                .append("+++++")
                                .toString()
                )
        );
    }
}
