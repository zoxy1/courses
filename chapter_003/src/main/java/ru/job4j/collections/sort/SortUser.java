package ru.job4j.collections.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> userList) {
        Set<User> users = new TreeSet<>(userList);
        return users;
    }
}
