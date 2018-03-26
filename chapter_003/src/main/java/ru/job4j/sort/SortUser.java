package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public Set<User> sort (List<User> in) {
        Set<User> result= new TreeSet<>();
        for (User user: in) {
            result.add(user);
        }

        return result;
    }
}
