package ru.tracker.actions;


import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.storage.Tracker;

class FindItemsByName extends BaseAction {

public FindItemsByName(int key, String name) {
        super(key, name);
        }


    @Override
    public void execute(Input input, Tracker tracker) {
    String foundname = input.ask("name поиск : ");
             Item[] nameresult = tracker.findByName(foundname);
                if (nameresult.length == 0) {
                    System.out.println("Заявка не найдена");
                } else {
                    for (int i = 0; i < nameresult.length; i++) {
                        System.out.println(nameresult[i].getName());
                    }
                }
    }

}
