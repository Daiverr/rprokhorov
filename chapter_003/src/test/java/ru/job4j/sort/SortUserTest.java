package ru.job4j.sort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SortUserTest {

    @Test
    public void mnb() {
        List<User> users = new ArrayList<>();
        users.add(new User("Roman", 28));
        users.add(new User("Vasya", 23));
        SortUser su = new SortUser();
        Set<User> usersSort = su.sort(users);
        assertThat(usersSort.iterator().next().getAge(), is(23));
    }
}
