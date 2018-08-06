package ru.tracker;

public class FindItemById implements UserAction  {
  @Override
    public int key() {
        return 4;
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

    @Override
    public String info() {
        return "4 Find item by Id.";
    }
}
