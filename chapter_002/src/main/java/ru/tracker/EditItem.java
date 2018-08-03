package ru.tracker;


public class EditItem implements UserAction {
 @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
      String edition = input.ask("Введите номер редактируемой заявки : ");
              System.out.println("------------ Новые данные по заявке --------------");
              String name = input.ask("Введите имя заявки :");
              String desc = input.ask("Введите описание заявки :");
              Item itemin = new Item(name, desc, 1234L);
              tracker.replace(edition, itemin);
                if (tracker.replace(edition, itemin)) {
                    System.out.println("Заявка изменена");
                } else {
                    System.out.println("Item not found");
                }
    }

    @Override
    public String info() {
        return "2 Edit item.";
    }
}