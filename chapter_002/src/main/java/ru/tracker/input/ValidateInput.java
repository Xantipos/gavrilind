package ru.tracker.input;

import java.util.*;

public class ValidateInput extends ConsoleInput {

    public int ask(String quetion, int[]range) {

        boolean invalid = true;
        int value = -1;

        do {
            try {
                value = super.ask(quetion, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again blin!");
            }
        } while (invalid);
        return value;
    }
}