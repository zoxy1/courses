package ru.job4j.strategy;

/**
 * Created by Zoxy1 on 12.10.17.
 */
public class MockOutput implements Output {
    private final StringBuilder out = new StringBuilder();

    @Override
    public void println(Object value) {
        this.out.append(value).append("\n");
    }

    public String getOut() {
        return this.out.toString();
    }
}
