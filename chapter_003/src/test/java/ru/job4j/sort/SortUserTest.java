package ru.job4j.sort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;

public class SortUserTest {

    @Test
    public void whenCompareByAge() {
        List<User> users = new ArrayList<>();
        users.add(new User("Roman", 28));
        users.add(new User("Vasya", 23));
        SortUser su = new SortUser();
        Set<User> usersSort = su.sort(users);
        assertThat(usersSort.iterator().next().getAge(), is(23));
    }

    @Test
    public void whenCompareByNameLength() {
        List<User> users = new ArrayList<>();
        users.add(new User("Vladimir", 23));
        users.add(new User("Roman", 28));
        SortUser su = new SortUser();
        List<User> usersSort = su.sortNameLength(users);
        assertThat(usersSort.iterator().next().getName(), is("Roman"));
    }

    @Test
    public void whenCompareByAllFields() {
        List<User> users = new ArrayList<>();
        users.add(new User("Vladimir", 23));
        users.add(new User("Roman", 28));
        users.add(new User("Vladimir", 31));
        users.add(new User("Roman", 19));
        SortUser su = new SortUser();
        List<User> usersSort = su.sortByAllFields(users);
        Iterator<User> iterator = usersSort.iterator();
        assertThat(iterator.next().getName(), is("Roman"));
        assertThat(iterator.next().getAge(), is(28));
        assertThat(iterator.next().getName(), is("Vladimir"));

    }
}
