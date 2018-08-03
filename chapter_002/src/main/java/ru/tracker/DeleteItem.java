package ru.tracker;


public class DeleteItem implements UserAction  {
  @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
     String deletion = input.ask("Введите номер заявки на удаление : ");
              tracker.delete(deletion);
                if (tracker.delete(deletion)) {
                    System.out.println("Заявка изменена");
                } else {
                    System.out.println("Item not found");
                }  
    }

    @Override
    public String info() {
        return "3 Delete Item.";
    }
}
