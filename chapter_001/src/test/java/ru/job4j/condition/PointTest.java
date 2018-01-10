package ru.job4j.condition;


import org.hamcrest.number.IsCloseTo;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PointTest.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PointTest {

    @Test
    public void whenPointisX1Y1andPoint2isX2Y2ThenDouble() {
        Point point = new Point(1, 1);
        Point point2 = new Point(2, 2);
        double result = point.distanceTo(point2);
        double expected = 1.4;
        assertThat(result, IsCloseTo.closeTo(expected, 0.05));
    }
}
