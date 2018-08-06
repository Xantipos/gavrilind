package ru.tracker.actions;

import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.storage.Tracker;

public class AddItem implements UserAction {
    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name:");
        String desc = input.ask("Please, provide item description:");
        Item item = new Item(name, desc, 1234L);
        tracker.add(item);
        System.out.println(item.GetDone());
    }

    @Override
    public String info() {
        return "0 Add new Item.";
    }
}