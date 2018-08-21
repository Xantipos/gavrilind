package ru.tracker.actions;

import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.storage.Tracker;

class FindItemById extends BaseAction {

    public FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
      String find = input.ask("id поиск : ");
              Item finded = tracker.findById(find);
                if (finded == null) {
                    System.out.println("Заявка не найдена");
                } else {
                    System.out.println(finded.getName());
                }
    }
}
