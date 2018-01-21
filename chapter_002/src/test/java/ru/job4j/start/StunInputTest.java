package ru.job4j.start;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class StunInputTest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameNameAndDescription() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "test name", "desc", "2", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getItems().get(0).getName(), is("test name"));
        assertThat(tracker.getItems().get(0).getDesc(), is("desc"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("1", "Andrey", "description"));
        Input input = new StubInput(new String[]{"3", item.getId(), "test name", "test description", "2", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
        assertThat(tracker.findById(item.getId()).getDesc(), is("test description"));
    }

    @Test
    public void whenDeleteItemThenTrackerNotHasThisItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("0", "Andrey", "test description1"));
        tracker.add(new Item("1", "Max", "test description2"));
        tracker.add(new Item("2", "Serg", "test description3"));
        Input input = new StubInput(new String[]{"4", "1", "7"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById("1"));
    }

    @Test
    public void whenUserAddItemsThenTrackerHasAllThisItems() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "test name1", "desc1", "1", "test name2", "desc2", "2", "7"});
        Item item0 = new Item("0", "test name1", "desc1");
        Item item1 = new Item("1", "test name2", "desc2");
        new StartUI(input, tracker).init();
        List<Item> itemsResultAll = tracker.findAll();
        assertThat(itemsResultAll.get(0), is(item0));
        assertThat(itemsResultAll.get(1), is(item1));
    }

    @Test
    public void whenFindByIdThenTrackerHasItemWithThisId() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "Andrey", "desc1", "1", "Max", "desc2", "1", "Andrey", "desc3", "5", "2", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById("1").getName(), is("Max"));
        assertThat(tracker.findById("1").getDesc(), is("desc2"));

    }

    @Test
    public void whenFindByNameThenTrackerHasItemsWithThisName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "Andrey", "desc1", "1", "Max", "desc2", "1", "Andrey", "desc3", "6", "Andrey", "7"});
        new StartUI(input, tracker).init();
        List<Item> itemsResultAll = tracker.findByName("Andrey");
        assertThat(itemsResultAll.get(0).getName(), is("Andrey"));
        assertThat(itemsResultAll.get(1).getName(), is("Andrey"));
    }

}
