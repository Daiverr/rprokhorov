package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();

        for (User user: list) {
            result.put(user.getId(), user);
        }
        //принимает в себя список пользователей и конвертирует его в Map с ключом Integer id и соответствующим ему User.
        return result;
    }
}
