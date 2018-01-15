package ru.job4j.collections.sort;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> userList) {
        Set<User> users = new TreeSet<>(userList);
        return users;
    }

    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result;
                if (o1.getName().compareTo(o2.getName()) == 0) {
                    result = o1.getAge() - o2.getAge();
                } else {
                    result = o1.getName().compareTo(o2.getName());
                }
                return result;
            }
        });
        return users;
    }
}
