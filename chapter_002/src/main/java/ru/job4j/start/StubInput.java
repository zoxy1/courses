package ru.job4j.start;

public class StubInput implements Input {
    private String[] strings;
    private int count = 0;
    public StubInput(String[] strings) {
        this.strings = strings;
    }

    @Override
    public String ask(String question) {
        return this.strings[this.count++];
    }

    @Override
    public int ask(String question, int[] range) {
        System.out.print(question);
        System.out.println();
        return Integer.valueOf(this.strings[this.count++]);
    }
}
