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
     * ��������� ���� ��� ���������� ����� ������.
     */
    private static final String ADD = "0";
    private static final String SHOWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    /**
     * ��������� ��� ������ �� �����.
     */
    private static final String EXIT = "6";
    /**
     * ��������� ������ �� ������������.
     */
    private final Input input;

    /**
     * ��������� ������.
     */
    private final Tracker tracker;

    /**
     * ���������� ���������������� ����.
     * @param input ���� ������.
     * @param tracker ��������� ������.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * ������� ���� ���������.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("������� ����� ���� : ");
            if (ADD.equals(answer)) {
                //���������� ������ �������� � ��������� �����.
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
               Item[] showresult = tracker.findAll();
               for (int i = 0; i < showresult.length; i++) {
                System.out.println(showresult[i]);
                }
           
              } else if (EDIT.equals(answer)) {
              String edition = this.input.ask("������� ����� ������������� ������ : ");
              System.out.println("------------ ����� ������ �� ������ --------------");
              String name = this.input.ask("������� ��� ������ :");
              String desc = this.input.ask("������� �������� ������ :");
              Item itemin = new Item(name, desc, 1234L);
              tracker.replace(edition, itemin);
            
              } else if (DELETE.equals(answer)) {
              String deletion = this.input.ask("������� ����� ������ �� �������� : ");
              tracker.delete(deletion);
            
             } else if (FINDID.equals(answer)) {
              String find = this.input.ask("id ����� : ");
              Item finded = tracker.findById(find);
              System.out.println(finded.getName());

            } else if (FINDNAME.equals(answer)) {
             String foundname = this.input.ask("name ����� : ");
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
     * ����� ��������� ���������� ����� ������ � ���������.
     */
    private void createItem() {
        System.out.println("------------ ���������� ����� ������ --------------");
        String name = this.input.ask("������� ��� ������ :");
        String desc = this.input.ask("������� �������� ������ :");
        Item item = new Item(name, desc, 1234L);
        this.tracker.add(item);
        System.out.println("------------ ����� ������ � getId : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("����.");
        System.out.println("0 �������� ������ ");
        System.out.println("1 �������� ������� ������ ");
        System.out.println("2 ������������� ������ �����:");
        System.out.println("3 ������� ������ �����:");
        System.out.println("4 ����� �� id");
        System.out.println("5 ����� �� �����");
        System.out.println("6 �����");
    }
    /**
     * ������� ���������.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}