package ru.tracker.input;

import java.util.*;

public class ValidateInput implements Input {

    private final Input input;
    public Validator validator = new Validator(new ConsoleInput());

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range){
        if(validator.validate(question,range))
            throw new NumberFormatException("Введите верное значение");
            int value = this.input.ask(question, range);
            return  value;
        /**
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return  value;
         */
    }
}