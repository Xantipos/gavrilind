package ru.tracker.input;

import java.util.*;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String quetion) {
        System.out.print(quetion);
        return scanner.nextLine();
    }

    public int ask(String quetion, int[]range) {
        int key = Integer.valueOf(this.ask(quetion));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException();
        }
            return key;

    }
}