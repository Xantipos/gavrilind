package ru.tracker.actions;


import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.storage.Tracker;

class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
      String edition = input.ask("Введите номер редактируемой заявки : ");
              System.out.println("------------ Новые данные по заявке --------------");
              String name = input.ask("Введите имя заявки :");
              String desc = input.ask("Введите описание заявки :");
              Item itemin = new Item(name, desc, 1234L);
                if (tracker.replace(edition, itemin)) {
                    System.out.println("Заявка изменена");
                } else {
                    System.out.println("Item not found");
                }
    }

}