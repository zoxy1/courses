package ru.job4j.collections.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
        Set<User> userSet = new TreeSet<>(userList);
        assertThat(sortUser, is(userSet));
    }
}
