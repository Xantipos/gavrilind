package ru.tracker.input;


public class StubInput implements Input {

    private String[] value;
    private int position = 0;
    public StubInput(String[] value) {
        this.value = value;
    }

    public String ask(String question) { return this.value[this.position++]; }
    public int ask(String quetion, int[] range) {
        int key;
        return key = this.position++;
        //throw new UnsupportedOperationException("nifiga");
    }
}