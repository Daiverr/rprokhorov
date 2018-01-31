package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SyntaxTaskTest {

    @Test
    public void whenTwoSortedArraysCombine() {
        SyntaxTask st = new SyntaxTask();
        int[] result = st.combine(new int[]{1, 2, 3, 4, 5}, new int[]{3, 5, 9, 11});
        int[] expect = new int[]{1, 2, 3, 3, 4, 5, 5, 9, 11};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTwoSortedArraysCombine2() {
        SyntaxTask st = new SyntaxTask();
        int[] result = st.combine(new int[]{0, 0, 1}, new int[]{3, 5, 9, 11});
        int[] expect = new int[]{0, 0, 1, 3, 5, 9, 11};
        assertThat(result, is(expect));
    }
}
