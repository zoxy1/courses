package ru.job4j.start;

/**
 * Created by Zoxy1 on 30.09.17.
 */
public class StartUI {
    private Input input;
    private Tracker tracker = new Tracker();

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int key;
        do {
            menu.show();
            key = input.ask("Select:", menu.getRanges());
            menu.select(key);
        } while (key != 7);
    }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}
