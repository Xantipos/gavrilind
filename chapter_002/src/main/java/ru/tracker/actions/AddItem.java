package ru.tracker.actions;

import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.storage.Tracker;

class AddItem extends BaseAction {

    public AddItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter name:");
        String desc = input.ask("Enter description:");
        Item item = new Item(name, desc, 1234L);
        tracker.add(item);
        System.out.println(item.getDone());
    }
}