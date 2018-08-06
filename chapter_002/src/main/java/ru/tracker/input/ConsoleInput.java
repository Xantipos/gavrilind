package ru.tracker.input;

import java.util.*;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String quetion) {
        System.out.print(quetion);
        return scanner.nextLine();
    }
}