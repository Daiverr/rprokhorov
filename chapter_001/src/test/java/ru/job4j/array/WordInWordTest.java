package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * WordInWordTest.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class WordInWordTest {

    @Test
    public void whenStringContainsWord() {
        WordInWord wd = new WordInWord();
        boolean result = wd.contains("Hello", "lo");
        boolean exp = true;
        assertThat(result, is(exp));
    }

    @Test
    public void whenStringNotContainsWord() {
        WordInWord wd = new WordInWord();
        boolean result = wd.contains("Hello", "No");
        boolean exp = false;
        assertThat(result, is(exp));
    }
}
