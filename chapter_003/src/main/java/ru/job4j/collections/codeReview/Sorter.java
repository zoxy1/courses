package ru.job4j.collections.codeReview;

import ru.job4j.collections.sort.User;

import java.util.*;

public class Sorter {

    public Sorter(){ // конструктор без входных параметров можно не писать(вызывается по умолчанию)

    }

    Set<User> sort (List<User> list) { // если метод будет использоваться в других пакетах, то нужно добавить модификатор
        //доступа public, можно заменить все тело метода на return new TreeSet<>(list);
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList;
    }

    List<User> sortnamelength (List<User> list) { // неправильное написание имя метода нужно sortNameLength
        // В языке Java принято использовать lowerCamelCase — для именования экземпляров классов и методов.

        Comparator<User> compar = new Comparator<User>() { // необязательно объявлять перенную типа
            // Comparator<User> compar, лучше использовать анонимный класс или лямбда выражение
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(compar);
        return list;
    }

    List<User> sortboth (List<User> list) {
        Comparator<User> compar1 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}
