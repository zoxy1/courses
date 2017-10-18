package ru.job4j.start;

import java.util.Date;

/**
 * Created by Zoxy1 on 16.10.17.
 */
class EditItem implements UserAction {
    private Input input;
    private Tracker tracker;

    public EditItem(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = this.input.ask("Enter id item:");
        String name = this.input.ask("Enter new name item:");
        String desc = this.input.ask("Enter new description item:");
        long created = new Date().getTime();
        this.tracker.update(new Item(id, name, desc, created));
    }

    @Override
    public String info() {
        return String.format("3. %s", "Edit item");
    }
}

/**
 * Created by Zoxy1 on 16.10.17.
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;

    private int[] ranges;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new AddItem(this.input, this.tracker);
        this.actions[1] = new MenuTracker.ShowItems(this.tracker);
        this.actions[2] = new EditItem(this.input, this.tracker);
        this.actions[3] = new DeleteItem(this.input, this.tracker);
        this.actions[4] = new FindItemById(this.input, this.tracker);
        this.actions[5] = new FindItemByName(this.input, this.tracker);
        this.actions[6] = new Exit();
        ranges = new int[this.actions.length];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = this.actions[i].key();
        }
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public void select(int key) {
        for (UserAction userAction : this.actions) {
            if (userAction.key() == key) {
                userAction.execute(this.input, this.tracker);
            }
        }
    }

    private class AddItem implements UserAction {
        private Input input;
        private Tracker tracker;

        public AddItem(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = this.input.ask("Enter name item:");
            String desc = this.input.ask("Enter description item:");
            long created = new Date().getTime();
            this.tracker.add(new Item(name, desc, created));
        }

        @Override
        public String info() {
            return String.format("1. %s", "Add new item.");
        }
    }

    private static class ShowItems implements UserAction {
        private Tracker tracker;

        public ShowItems(Tracker tracker) {
            this.tracker = tracker;
        }

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            if (this.tracker.findAll().length == 0) {
                System.out.println("Items not found");
            }
            for (Item item : this.tracker.findAll()) {
                System.out.println(String.format("Id:%s, Name:%s, Description:%s", item.getId(), item.getName(), item.getDesc()));
            }
        }

        @Override
        public String info() {
            return String.format("2. %s", "Show all items");
        }
    }

    private class DeleteItem implements UserAction {
        private Input input;
        private Tracker tracker;

        public DeleteItem(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = this.input.ask("Enter id item, which is delete:");
            boolean isDelete = this.tracker.delete(id);
            if (!isDelete) {
                System.out.println("Item with such ID not found:");
            }
        }

        @Override
        public String info() {
            return String.format("4. %s", "Delete item");
        }
    }

    private class FindItemById implements UserAction {
        private Input input;
        private Tracker tracker;

        public FindItemById(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = this.input.ask("Enter id item:");
            Item item = this.tracker.findById(id);
            if (item != null) {
                System.out.println(String.format("Id:%s, Name:%s, Description:%s", item.getId(), item.getName(), item.getDesc()));
            } else {
                System.out.println("Item with such ID not found");
            }
        }

        @Override
        public String info() {
            return String.format("5. %s", "Find item by id");
        }
    }

    private class FindItemByName implements UserAction {
        private Input input;
        private Tracker tracker;

        public FindItemByName(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = this.input.ask("Enter name item:");
            Item[] items = this.tracker.findByName(name);
            if (items.length != 0) {
                for (Item item : items) {
                    System.out.println(String.format("Id:%s, Name:%s, Description:%s", item.getId(), item.getName(), item.getDesc()));
                }
            } else {
                System.out.println("Item with such name not found");
            }
        }

        @Override
        public String info() {
            return String.format("6. %s", "Find item by name");
        }
    }

    private class Exit implements UserAction {

        @Override
        public int key() {
            return 7;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return String.format("7. %s", "Exit");
        }
    }

    public int[] getRanges() {
        return ranges;
    }

}
