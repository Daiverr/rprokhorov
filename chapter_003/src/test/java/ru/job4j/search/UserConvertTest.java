package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void convertListToMap() {
        User user1 = new User(1, "Roman", "Moscow");
        User user2 = new User(2, "Vanya", "Omsk");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        UserConvert convert = new UserConvert();
        HashMap<Integer, User> result = convert.process(users);
        assertThat(result.get(2).getName(),  is("Vanya"));
    }
}
