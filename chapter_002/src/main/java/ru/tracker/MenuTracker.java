package ru.tracker;

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
    public int[] ArrayKey() {
        int[] range = new int[getActionsLentgh()];
        for (int i = 0; i < getActionsLentgh(); i++) {
            range[i] = i;
        }
        return range;
    }
    /**
     * Метод заполняет массив.
     */

    public void fillActions(StartUI ui) {
        this.actions.add(new ru.tracker.AddItem());
        this.actions.add(new ru.tracker.ShowItems());
        this.actions.add(new ru.tracker.EditItem());
        this.actions.add(new ru.tracker.DeleteItem());
        this.actions.add(new ru.tracker.FindItemById());
        this.actions.add(new ru.tracker.FindItemsByName());
        this.actions.add(new ru.tracker.ExitProgram(ui));
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
