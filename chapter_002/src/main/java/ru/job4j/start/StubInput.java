package ru.job4j.start;

public class StubInput implements Input {
    private String[] strings;
    private int count = 0;
    public StubInput(String[] strings) {
        this.strings = strings;
    }

    @Override
    public String ask(String question) {
        return this.strings[count++];
    }
}
