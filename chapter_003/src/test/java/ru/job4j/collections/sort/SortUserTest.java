package ru.job4j.collections.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void sortByNameLength() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("Петр", 30),
                new User("Антон", 25),
                new User("Светлана", 19),
                new User("Василий", 20)));
        List<User> sortUsers = sortUser.sortNameLength(users);
        for (User user : sortUsers) {
            System.out.println(String.format("Имя:%s Возраст:%d", user.getName(), user.getAge()));
        }
        assertThat(sortUsers.get(0), is(new User("Петр", 30)));
        assertThat(sortUsers.get(1), is(new User("Антон", 25)));
        assertThat(sortUsers.get(2), is(new User("Василий", 20)));
        assertThat(sortUsers.get(3), is(new User("Светлана", 19)));
    }

    @Test
    public void sortByNameAndAge() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("Петр", 30),
                new User("Антон", 25),
                new User("Василий", 22),
                new User("Василий", 20)));
        List<User> sortUsers = sortUser.sortByAllFields(users);
        for (User user : sortUsers) {
            System.out.println(String.format("Имя:%s Возраст:%d", user.getName(), user.getAge()));
        }
        assertThat(sortUsers.get(0), is(new User("Антон", 25)));
        assertThat(sortUsers.get(1), is(new User("Василий", 20)));
        assertThat(sortUsers.get(2), is(new User("Василий", 22)));
        assertThat(sortUsers.get(3), is(new User("Петр", 30)));
    }
}
