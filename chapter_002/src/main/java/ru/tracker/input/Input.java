package ru.tracker.input;

public interface Input {
    String ask(String quetion);

    int ask(String quetion, int[] range);
}