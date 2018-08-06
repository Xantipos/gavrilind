package ru.tracker.actions;


import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.storage.Tracker;

public class ShowItems implements UserAction {
    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] showresult = tracker.findAll();
        for (int i = 0; i < showresult.length; i++) {
            System.out.println(showresult[i].getName());
        }
    }

    @Override
    public String info() {
        return "1 Show all Items.";
    }
}
