package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 6));
        Input input = new StubInput(new String[]{"2", item.getId(), "test name2", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name2"));
    }

    @Test
    public void whenDeleteItemThenTrackerLengthSmaller() { //проверка удаления item
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 6));
        tracker.add(new Item("test name2", "desc", 7));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().length, is(1));
    }

    PrintStream stdout = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenGetAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 6));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), containsString("Заявка: " + item.getId() + " " + item.getName()));
    }

    @Test
    public void whenFindByID() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 6));
        tracker.add(new Item("test name2", "desc", 7));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), containsString(item.getName() + "\n" + item.getDesc()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 6));
        tracker.add(new Item("test name", "desc22", 7));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), containsString(item.getDesc()));
        assertThat(new String(out.toByteArray()), containsString("desc22"));
    }

}
