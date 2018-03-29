package ru.job4j.sort;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> in) {
        Set<User> result = new TreeSet<>();
        result.addAll(in);
        return result;
    }

    public List<User> sortNameLength(List<User> in) {
        //необходимо определить Comparator для метода Collections.sort и отсортировать List<User> по длине имени.
        List<User> result = new ArrayList<User>();
        result.addAll(in);
        Collections.sort(result, new UserComparatorLength());
        return result;
    }

    public List<User> sortByAllFields(List<User> in) {
       // отсортировать List<User> по обоим полям, сначала сортировка по имени в лексикографическом порядке, потом по возрасту
        List<User> result = new ArrayList<User>();
        result.addAll(in);
        Collections.sort(result, new UserComparatorAlphabetThanAge());
        return result;
    }
}

class UserComparatorLength implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getName().length(), o2.getName().length());

    }
}

class UserComparatorAlphabetThanAge implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        int result;
        if (o1.getName().compareTo(o2.getName()) == 0) {
            result = Integer.compare(o1.getAge(), o2.getAge());
        } else {
            result = o1.getName().compareTo(o2.getName());
        }
        return result;
    }
}





