package ru.job4j.start;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tracker {

    private List<Item> items = new ArrayList<>();

    public Item add(Item item) {
        items.add(item);
        return item;
    }

    public void update(Item item) {
        boolean isFound = false;
        for (Item itemList : this.items) {
            if (itemList != null && itemList.getId().equals(item.getId())) {
                this.items.set(this.items.indexOf(itemList), item);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Item with such id not found!");
        }
    }

    public List<Item> findAll() {
        List<Item> itemsWithoutNull = new ArrayList<>();
        for (Item item : this.items) {
            if (item != null) {
                itemsWithoutNull.add(item);
            }
        }
        return itemsWithoutNull;
    }

    public boolean delete(String id) {
        boolean isFindId = false;
        Iterator<Item> iterator = this.items.iterator();
        Item item;
        while (iterator.hasNext()) {
            item = iterator.next();
            if (item != null && item.getId().equals(id)) {
                iterator.remove();
                isFindId = true;
                break;
            }
        }
        return isFindId;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public List<Item> findByName(String key) {
        List<Item> itemsHasSameName = new ArrayList<>();
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                itemsHasSameName.add(item);
            }
        }
        return itemsHasSameName;
    }

    public List<Item> getItems() {
        return items;
    }
}
