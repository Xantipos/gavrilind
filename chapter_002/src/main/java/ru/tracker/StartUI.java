package ru.tracker;

import java.util.ArrayList;
import java.util.List;
/**
 * @version $Id$
 * @since 0.1
*0. Add new Item
*1. Show all items
*2. Edit item
*3. Delete item
*4. Find item by Id
*5. Find items by name
*6. Exit Program
*Select:
 * Меню
 */
public class StartUI {

    private final Input input;

    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {

            MenuTracker menu = new MenuTracker(this.input, this.tracker);
            List<Integer> range = new ArrayList<>();
            menu.fillActions();
            for (int i = 0; i < menu.getActionsLentgh(); i++) {
                range.add(i);
            }
            do {
                menu.show();
                String answer = this.input.ask("select:");
                int sel = Integer.valueOf(answer);
                if (sel == 6){break;};
                menu.select(sel);
            } while (!"y".equals(this.input.ask("Exit?(y): ")));
        }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
