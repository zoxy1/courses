package ru.job4j.start;

import java.util.Date;

/**
 * Created by Zoxy1 on 30.09.17.
 */
public class StartUI {
    private Input input;
    private static final String ADD_NEW_ITEM = "0";
    private static final String SHOW_ALL_ITEM = "1";
    private static final String EDIT_ITEM = "2";
    private static final String DELETE_ITEM = "3";
    private static final String FIND_ITEM_BY_ID = "4";
    private static final String FIND_ITEMS_BY_NAME = "5";
    private static final String EXIT_PROGRAM = "6";
    private long id = 0;
    private Tracker tracker = new Tracker();

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        while (true) {
            showMenu();
            String menuItem = input.ask("Select:");
            if (ADD_NEW_ITEM.equals(menuItem)) {
                addNewItem();
            } else if (SHOW_ALL_ITEM.equals(menuItem)) {
                showAllItem();
            } else if (EDIT_ITEM.equals(menuItem)) {
                editItem();
            } else if (DELETE_ITEM.equals(menuItem)) {
                deleteItem();
            } else if (FIND_ITEM_BY_ID.equals(menuItem)) {
                findItemById();
            } else if (FIND_ITEMS_BY_NAME.equals(menuItem)) {
                findItemsByName();
            } else if (EXIT_PROGRAM.equals(menuItem)) {
                break;
            }
        }
    }

    private void addNewItem() {
        String name = input.ask("Enter name item:");
        String desc = input.ask("Enter description item:");
        long created = new Date().getTime();
        this.tracker.add(new Item(String.valueOf(id++), name, desc, created));
    }

    private void showAllItem() {
        Item[] items = this.tracker.findAll();
        if (items != null) {
            for (Item item : items) {
                System.out.println(String.format("Id:%s," + "Name:%s," + "Description:%s", item.getId(), item.getName(), item.getDesc()));
            }
        } else {
            System.out.println("Items not found");
        }
    }

    private void editItem() {
        String id = input.ask("Enter id item:");
        String name = input.ask("Enter new name item:");
        String desc = input.ask("Enter new description item:");
        long created = new Date().getTime();
        this.tracker.update(new Item(id, name, desc, created));
    }

    private void showMenu() {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    private void deleteItem() {
        String id = input.ask("Enter id item, which is delete:");
        boolean isDelete = this.tracker.delete(id);
        if (!isDelete) {
            System.out.println("Item with such ID not found:");
        }
    }

    private void findItemById() {
        String id = input.ask("Enter id item:");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(String.format("Id:%s, Name:%s, Description:%s", item.getId(), item.getName(), item.getDesc()));
        } else {
            System.out.println("Item with such ID not found");
        }
    }

    private void findItemsByName() {
        String name = input.ask("Enter name item:");
        Item[] items = this.tracker.findByName(name);
        if (items != null) {
            for (Item item : items) {
                System.out.println(String.format("Id:%s, Name:%s, Description:%s", item.getId(), item.getName(), item.getDesc()));
            }
        } else {
            System.out.println("Item with such name not found");
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }


}
