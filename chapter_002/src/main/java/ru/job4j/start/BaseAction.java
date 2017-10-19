package ru.job4j.start;

/**
 * Created by Zoxy1 on 19.10.17.
 */
public abstract class BaseAction implements UserAction {
    private int key;
    private String name;

    public BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public abstract int key();

    public abstract void execute(Input input, Tracker tracker);

    @Override
    public String info() {
        return String.format("%d. %s", this.key, this.name);
    }
}
