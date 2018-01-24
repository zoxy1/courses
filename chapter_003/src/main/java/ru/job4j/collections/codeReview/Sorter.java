package ru.job4j.collections.codeReview;

import ru.job4j.collections.sort.User;

import java.util.*;

public class Sorter {

    // конструктор без входных параметров можно не писать(вызывается по умолчанию)
    public Sorter(){ // не хватает пробела после круглых скобок

    }

    /* если метод будет использоваться в других пакетах, то нужно добавить модификатор
     * доступа public, можно заменить все тело метода на return new TreeSet<>(list);
     * лишний пробел после имени метода
     */
    Set<User> sort (List<User> list) {
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList;
    }

    /* Если метод будет использоваться в других пакетах, то нужно добавить модификатор
     * доступа public, лишний пробел после имени метода, неправильное написание имени метода нужно sortNameLength
     * в языке Java принято использовать lowerCamelCase для наименования методов
     */
    List<User> sortnamelength (List<User> list) {

        /* Необязательно объявлять перенную типа Comparator<User> compar,
         * можно использовать анонимный класс или лямбда выражение
         */
        Comparator<User> compar = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(compar);
        return list;
    }

    /* если метод будет использоваться в других пакетах, то нужно добавить модификатор
     * доступа public, лишний пробел после имени методов и круглой скобкой, неправильное написание имени метода
     * нужно sortBoth в языке Java принято использовать lowerCamelCase для наименования методов
     */
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
