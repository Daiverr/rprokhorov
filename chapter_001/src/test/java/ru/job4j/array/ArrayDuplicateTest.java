package ru.job4j.array;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
/**
 * ArrayDuplicate.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] result = ad.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] exp = {"Привет", "Мир", "Супер"};
        assertThat(result, is(exp));
    }
}
