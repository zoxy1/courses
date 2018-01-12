package ru.job4j.collections.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class UserTest {
    @Test
    public void usersSortListToSet() {
        SortUser users = new SortUser();
        List<User> userList = Arrays.asList
                (new User("Петр", 30), new User("Антон", 25), new User("Василий", 20));
        for (User user : userList) {
            System.out.println(String.format("Имя:%s Возраст:%d", user.getName(), user.getAge()));
        }
        System.out.println();
        Set<User> sortUser = users.sort(userList);
        for (User user : sortUser) {
            System.out.println(String.format("Имя:%s Возраст:%d", user.getName(), user.getAge()));
        }
    }
}
