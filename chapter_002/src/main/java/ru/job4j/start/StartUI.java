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
        do {
            menu.show();
            String key = input.ask("Select:");
            if (key.equals("7")) {
                break;
            }
            if (!key.equals("")) {
                menu.select(Integer.valueOf(key));
            }
        } while (true);
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }


}
