package ru.job4j.models;

public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        this.items[position++] = item;
        return item;
    }

    public void update(Item item) {
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                this.items[i] = item;
                break;
            }
        }
    }

    public Item[] findAll() {
        int numberWithoutNull = 0;
        Item[] itemsWithoutNull = new Item[position];
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null) {
                System.arraycopy(this.items, i, itemsWithoutNull, numberWithoutNull++, 1);
            }
        }
        Item[] itemsWithoutNullNewMass = new Item[numberWithoutNull];
        System.arraycopy(itemsWithoutNull, 0, itemsWithoutNullNewMass, 0, numberWithoutNull);
        return itemsWithoutNullNewMass;
    }

    public boolean delete(String id) {
        boolean isFindId = false;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = null;
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

    public Item[] findByName(String key) {
        Item[] itemsFindByName = null;
        int numberSameName = 0;
        Item[] itemsHasSameName = new Item[position];
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                System.arraycopy(this.items, i, itemsHasSameName, numberSameName++, 1);
            }
        }
        Item[] itemsHasSameNameNewMass = new Item[numberSameName];
        System.arraycopy(itemsHasSameName, 0, itemsHasSameNameNewMass, 0, numberSameName);
        return itemsHasSameNameNewMass;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
