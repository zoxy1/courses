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
                return o1.getName().compareTo(o2.getName());
            }
        });
        //users.sort((o1, o2) ->  o1.getName().compareTo(o2.getName()));
        //users.sort(Comparator.comparing(User::getName));
        return  users;
    }

    public List<User> sortByAllFields (List<User> users) {
        users.
        //- в этом методе необходимо определить Comparator для метода Collections.sort
        // и отсортировать List<User> по обоим полям, сначала сортировка по имени в лексикографическом порядке, потом по возрасту.
    }
}
