package ru.tracker.input;
public class Validator implements Input {

    private final Input input;

    public Validator(final Input input) {
        this.input = input;
    }


    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range){
        int key = Integer.valueOf(this.ask(question));
        return key;
    }

 public boolean validate (String question, int[] range){
        int value = 1;
         boolean invalid = true;  
                value = this.input.ask(question, range);
                invalid = false;
        return  invalid;
    }
}