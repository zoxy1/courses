package ru.job4j.strategy;

import java.io.PrintStream;

/**
 * Created by Zoxy1 on 12.10.17.
 */
public class ConsoleOutput implements Output {
    private final PrintStream out;

    public ConsoleOutput(final PrintStream out) {
        this.out = out;
    }

    @Override
    public void println(Object value) {
        this.out.println(value);
    }
}
