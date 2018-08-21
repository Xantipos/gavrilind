package ru.tracker.actions;


import ru.tracker.input.Input;
import ru.tracker.storage.Tracker;

class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
     String deletion = input.ask("Введите номер заявки на удаление : ");
                if (tracker.delete(deletion)) {
                    System.out.println("Заявка удалена");
                } else {
                    System.out.println("Item not found");
                }  
    }
}
