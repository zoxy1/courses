package ru.job4j.models;

import java.util.Scanner;

/**
 * Created by Zoxy1 on 30.09.17.
 */
public class ConsoleInput {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
