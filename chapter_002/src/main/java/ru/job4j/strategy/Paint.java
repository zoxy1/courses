package ru.job4j.strategy;

/**
 * Created by Zoxy1 on 12.10.17.
 */
public class Paint {
    private Output output;

    public Paint(Output output) {
        this.output = output;
    }

    public void draw(Shape shape) {
        this.output.println(shape.pic());
    }
}
