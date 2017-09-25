package ru.job4j.models;

import org.junit.Test;

public class TrackerTest {
    @Test
    public void findAllTest() {

        Tracker traker = new Tracker();
        traker.add(new Item("1", "Заявка 1"));
        traker.add(new Item("2", "Заявка 2"));
        traker.add(new Item("3","Заявка 3"));
        traker.add(new Item("4","Заявка 4"));
        traker.add(new Item("5","Заявка 5"));


        Item[] itemsResultAll = traker.findAll();
        traker.delete("3");
        Item[] itemsResultDelete = traker.findAll();

        Item itemFindById = traker.findById("1");
        traker.add(new Item("6", "Заявка 6"));
        Item[] itemsAddItem = traker.findAll();

        traker.update(new Item("6", "Заявка 6", "Добавлено описание"), "6");

    }
}
