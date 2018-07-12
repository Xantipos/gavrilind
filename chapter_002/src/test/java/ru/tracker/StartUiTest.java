package ru.tracker;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StartUiTest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUi(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = new Item("test name", "desc", 1234L);
        tracker.add(item);
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUi(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
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
        new StartUi(input, tracker).init();
        Assert.assertNull(tracker.findById(item2.getId()));
    }

    @Test
    public void whenFinfbyidThenTrackerHasValue() {

        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", 1234L);
        tracker.add(item);

        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenFinfbyNameThenTrackerHasValue() {

        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", 1234L);
        tracker.add(item);

        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUi(input, tracker).init();
        Item itresult[] = tracker.findByName(item.getName());
        assertThat(tracker.findByName(item.getName())[0].getName(), is("test name"));
    }
}