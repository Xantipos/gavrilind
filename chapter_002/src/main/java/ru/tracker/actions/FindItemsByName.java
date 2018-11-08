package ru.tracker.actions;


import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.storage.Tracker;
import java.util.List;
import java.util.ArrayList;

class FindItemsByName extends BaseAction {

public FindItemsByName(int key, String name) {
        super(key, name);
        }


    @Override
    public void execute(Input input, Tracker tracker) {
    String foundname = input.ask("name поиск : ");
             List<Item> nameresult = tracker.findByName(foundname);
                if (nameresult.size() == 0) {
                    System.out.println("Заявка не найдена");
                } else {
                    for (int i = 0; i < nameresult.size(); i++) {
                        System.out.println(nameresult.get(i).getName());
                    }
                }
    }

}
