package ru.tracker;

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
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
               Item[] showresult = tracker.findAll();
               for (int i = 0; i < showresult.length; i++) {
                System.out.println(showresult[i]);
                }
           
              } else if (EDIT.equals(answer)) {
              String edition = this.input.ask("Введите номер редактируемой заявки : ");
              System.out.println("------------ Новые данные по заявке --------------");
              String name = this.input.ask("Введите имя заявки :");
              String desc = this.input.ask("Введите описание заявки :");
              Item itemin = new Item(name, desc, 1234L);
              tracker.replace(edition, itemin);
            
              } else if (DELETE.equals(answer)) {
              String deletion = this.input.ask("Введите номер заявки на удаление : ");
              tracker.delete(deletion);
            
             } else if (FINDID.equals(answer)) {
              String find = this.input.ask("id поиск : ");
              Item finded = tracker.findById(find);
              System.out.println(finded.getName());

            } else if (FINDNAME.equals(answer)) {
             String foundname = this.input.ask("name поиск : ");
             Item[] nameresult = tracker.findByName(foundname);
             for (int i = 0; i < nameresult.length; i++) {
                System.out.println(nameresult[i].getName());
                }
              

 } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 1234L);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0 добавить заявку ");
        System.out.println("1 показать текущие заявки ");
        System.out.println("2 редактировать заявку номер:");
        System.out.println("3 удалить заявку номер:");
        System.out.println("4 поиск по id");
        System.out.println("5 поиск по имени");
        System.out.println("6 выход");
    }
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}