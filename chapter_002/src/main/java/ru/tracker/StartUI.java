package ru.tracker;


import ru.tracker.actions.MenuTracker;
import ru.tracker.input.ConsoleInput;
import ru.tracker.input.Input;
import ru.tracker.storage.Tracker;

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

    public boolean work = true;

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
            menu.fillActions(this);
            int[] range = menu.ArrayKey();
            do {
                menu.show();
                String answer = this.input.ask("select:");
                int sel = Integer.valueOf(answer);
                menu.select(sel);
                 } while (work == true);
        }

    public void stop() {
        this.work = false;
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
