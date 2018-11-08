package ru.tracker.actions;

import ru.tracker.StartUI;
import ru.tracker.storage.Tracker;
import ru.tracker.input.Input;
import java.util.List;
import java.util.ArrayList;


public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;

    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

   // Метод заполняет массив ключами
    public List<Integer> arrayKey() {
        List<Integer> range = new ArrayList<>(getActionsLentgh());
        for (int i = 0; i < getActionsLentgh(); i++) {
            range.add(i, actions.get(i).key());
        }
        return range;
    }
    /**
     * Метод заполняет массив.
     */

    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItems(1, "Show all Items"));
        this.actions.add(new EditItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete Item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program", ui));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
