package ru.job4j.start;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrackerTest {
    @Test
    public void addTest() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", "Заявка 1", "Описание 1"));
        tracker.add(new Item("2", "Заявка 2", "Описание 2"));
        int positionExpected = 2;
        assertEquals(positionExpected, tracker.getPosition());
        assertTrue(tracker.getItems()[0].equals(new Item("1", "Заявка 1", "Описание 1")));
        assertTrue(tracker.getItems()[1].equals(new Item("2", "Заявка 2", "Описание 2")));
    }

    @Test
    public void updateTest() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", "Заявка 1", "Описание 1"));
        tracker.add(new Item("2", "Заявка 2", "Описание 2"));
        tracker.update(new Item("1", "Заявка 1", "Описание 1 обновлено!"));
        assertTrue(tracker.findById("1").getDesc().equals("Описание 1 обновлено!"));
    }

    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", "Заявка 1", "Описание 1"));
        tracker.add(new Item("2", "Заявка 2", "Описание 2"));
        tracker.delete("1");
        assertTrue(tracker.findById("1") == null);
    }

    @Test
    public void findAllTest() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", "Заявка 1", "Описание 1"));
        tracker.add(new Item("2", "Заявка 2", "Описание 2"));
        tracker.add(new Item("3", "Заявка 3", "Описание 3"));
        tracker.delete("1");
        Item[] itemsResultAll = tracker.findAll();
        assertTrue(tracker.getItems()[1].equals(itemsResultAll[0]));
        assertTrue(tracker.getItems()[2].equals(itemsResultAll[1]));
    }

    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", "Заявка 1", "Описание 1"));
        tracker.add(new Item("2", "Заявка 2", "Описание 2"));
        tracker.add(new Item("3", "Заявка 2", "Описание 3"));
        Item[] resultItems = tracker.findByName("Заявка 2");
        assertTrue(resultItems[0].equals(new Item("2", "Заявка 2", "Описание 2")));
        assertTrue(resultItems[1].equals(new Item("3", "Заявка 2", "Описание 3")));
    }

    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", "Заявка 1", "Описание 1"));
        tracker.add(new Item("2", "Заявка 2", "Описание 2"));
        tracker.add(new Item("3", "Заявка 3", "Описание 3"));
        Item itemExpected = tracker.findById("3");
        assertTrue(itemExpected.equals(new Item("3", "Заявка 3", "Описание 3")));
    }
}
