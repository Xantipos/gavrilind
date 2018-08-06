package ru.tracker;


public class FindItemsByName implements UserAction  {
  @Override
    public int key() {
        return 5;
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

    @Override
    public String info() {
        return "5 Find items by name.";
    }
}
