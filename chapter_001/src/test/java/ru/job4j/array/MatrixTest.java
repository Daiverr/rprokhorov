package ru.job4j.array;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
/**
 * Matrix.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MatrixTest {

    @Test
    public void whenSizeFourThenSixteen() {
        Matrix mt = new Matrix();
        int[][] mass = mt.multiple(4);
        int result = mass[3][3];
        int exp = 16;
        assertThat(result, is(exp));
    }

    @Test
    public void whenSizeEightThenSixtyFour() {
        Matrix mt = new Matrix();
        int[][] mass = mt.multiple(8);
        int result = mass[7][7];
        int exp = 64;
        assertThat(result, is(exp));
    }

    @Test
    public void whenOutOfArray() {
        Matrix mt = new Matrix();
        int[][] mass = mt.multiple(4);
        try {
            int result = mass[5][3];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("error");
        }
    }
}
