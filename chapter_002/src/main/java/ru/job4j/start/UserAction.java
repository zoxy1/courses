package ru.job4j.start;

/**
 * Created by Zoxy1 on 16.10.17.
 */
public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
