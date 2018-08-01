package ru.tracker;

/**
 * @author Dm Gavrilin (mailto:anubite@bk.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Assert;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartUiTest {

    String st =                         new StringBuilder()
            .append("Меню")
            .append(System.lineSeparator())
            .append("0 добавить заявку ")
            .append(System.lineSeparator())
            .append("1 показать текущие заявки ")
            .append(System.lineSeparator())
            .append("2 редактировать заявку номер:")
            .append(System.lineSeparator())
            .append("3 удалить заявку номер:")
            .append(System.lineSeparator())
            .append("4 поиск по id")
            .append(System.lineSeparator())
            .append("5 поиск по имени")
            .append(System.lineSeparator())
            .append("6 выход")
            .append(System.lineSeparator())
            .toString();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", 1234L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeleteValue() {

        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", 1234L);
        tracker.add(item);
        Item item2 = new Item("test name2", "desc2", 1234L);
        tracker.add(item2);
        Item item3 = new Item("test name3", "desc3", 1234L);
        tracker.add(item3);
        Input input = new StubInput(new String[]{"3", item2.getId(), "1", "6"});
        new StartUI(input, tracker).init();
        Assert.assertNull(tracker.findById(item2.getId()));
    }

    @Test
    public void whenFinfbyidThenTrackerHasValue() {

        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", 1234L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenFinfbyNameThenTrackerHasValue() {

        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", 1234L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName())[0].getName(), is("test name"));
    }

    @Test
    public void whenShowallTrackerHasBuffer() {

        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", 1234L);
        tracker.add(item);
        Item item2 = new Item("test name2", "desc2", 1234L);
        tracker.add(item2);
        Item item3 = new Item("test name3", "desc3", 1234L);
        tracker.add(item3);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(st)
                                .append("test name")
                                .append(System.lineSeparator())
                                .append("test name2")
                                .append(System.lineSeparator())
                                .append("test name3")
                                .append(System.lineSeparator())
                                .append(st)
                                .toString()
                )
        );
    }

    @Test
    public void whenSearchIdConsole() {

        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", 1234L);
        tracker.add(item);
        Item item2 = new Item("test name2", "desc2", 1234L);
        tracker.add(item2);
        Item item3 = new Item("test name3", "desc3", 1234L);
        tracker.add(item3);
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(st)
                                .append(item2.getName())
                                .append(System.lineSeparator())
                                .append(st)
                                .toString()
                )
        );
    }

    @Test
    public void whenSearchNameConsole() {

        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", 1234L);
        tracker.add(item);
        Item item2 = new Item("test name2", "desc2", 1234L);
        tracker.add(item2);
        Item item3 = new Item("test name3", "desc3", 1234L);
        tracker.add(item3);
        Input input = new StubInput(new String[]{"5", item3.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(st)
                                .append(item3.getName())
                                .append(System.lineSeparator())
                                .append(st)
                                .toString()
                )
        );
    }
}


