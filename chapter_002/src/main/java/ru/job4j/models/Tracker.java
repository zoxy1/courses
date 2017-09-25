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
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null) {
                numberWithoutNull++;
            }
        }
        Item[] itemsWithoutNull = new Item[numberWithoutNull];
        int index = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null) {
                itemsWithoutNull[index] = this.items[i];
                index++;
            }
        }
        return itemsWithoutNull;
    }

    public void delete(String id) {
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = null;
                break;
            }
        }
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
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                numberSameName++;
            }
        }
        if (numberSameName != 0) {
            itemsFindByName = new Item[numberSameName];
            int index = 0;
            for (int i = 0; i < position; i++) {
                if (this.items[i] != null && this.items[i].getName().equals(key)) {
                    itemsFindByName[index] = this.items[i];
                    index++;
                }
            }
        }
        return itemsFindByName;
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
