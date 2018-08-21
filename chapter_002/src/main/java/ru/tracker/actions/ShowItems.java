package ru.tracker.actions;


import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.storage.Tracker;

class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] showresult = tracker.findAll();
        for (int i = 0; i < showresult.length; i++) {
            System.out.println(showresult[i].getName());
        }
    }
}
