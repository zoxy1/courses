package ru.job4j.strategy;

/**
 * Created by Zoxy1 on 12.10.17.
 */
public class Square implements Shape {
    @Override
    public String pic() {
        StringBuilder pic = new StringBuilder();
        pic.append("**********\n");
        pic.append("*        *\n");
        pic.append("*        *\n");
        pic.append("*        *\n");
        pic.append("**********");
        return pic.toString();
    }
}
