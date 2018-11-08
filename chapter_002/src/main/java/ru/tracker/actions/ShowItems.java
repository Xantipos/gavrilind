package ru.tracker.actions;


import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.storage.Tracker;
import java.util.List;
import java.util.ArrayList;

class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        List<Item> showresult = tracker.findAll();
        for (int i = 0; i < showresult.size(); i++) {
            System.out.println(showresult.get(i).getName());
        }
    }
}
