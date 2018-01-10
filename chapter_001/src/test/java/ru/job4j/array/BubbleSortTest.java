package ru.job4j.array;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
/**
 * BubbleSortTest.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSortTest {
     @Test
    public void sortByBubble() {
         BubbleSort bs = new BubbleSort();
         int[] result = bs.sort(new int[]{5, 3, 9, 2, 0});
         int[] exp = {0, 2, 3, 5, 9};
         assertThat(result, is(exp));
     }

    @Test
    public void isAlreadySort() {
        BubbleSort bs = new BubbleSort();
        int[] result = bs.sort(new int[]{1, 2, 3, 4, 5});
        int[] exp = {1, 2, 3, 4, 5};
        assertThat(result, is(exp));
    }

    @Test
    public void iwhenSortIsSmall() {
        BubbleSort bs = new BubbleSort();
        int[] result = bs.sort(new int[]{3, 1});
        int[] exp = {1, 3};
        assertThat(result, is(exp));
    }


}
