package ru.tracker;
import org.junit.Assert;
import org.junit.Test;
import ru.tracker.storage.Tracker;
import ru.tracker.model.Item;
import java.util.List;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {

        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.replace(previous.getId(), next), is(true));
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteNameThenReturnNewName() {

        Tracker tracker = new Tracker();
        Item one = new Item("test1", "testDescription", 123L);
        tracker.add(one);
        Item two = new Item("test2", "testDescription2", 1234L);
        tracker.add(two);
        Item three = new Item("test3", "testDescription3", 12345L);
        tracker.add(three);
        assertThat(tracker.delete(two.getId()), is(true));
        tracker.delete(two.getId());
        Assert.assertNull(tracker.findById(two.getId()));
    }

    @Test
    public void whenFindallNameThenReturnLenghtName() {
        List <Item> result = new ArrayList<>(100);
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item three = new Item("test3", "testDescription3", 12345L);
        tracker.add(three);
        result = tracker.findAll();

        assertThat(result.size(), is(3));
        assertThat(result.get(0).getName(), is("test1"));
        assertThat(result.get(1).getName(), is("test2"));
        assertThat(result.get(2).getName(), is("test3"));
    }

    @Test
    public void whenFindByNameThenReturnItemsName() {
        List <Item> result = new ArrayList<>(100);
        Tracker tracker = new Tracker();
        Item one = new Item("test1", "testDescription", 123L);
        tracker.add(one);
        Item two = new Item("test", "testDescription2", 1234L);
        tracker.add(two);
        Item three = new Item("test", "testDescription3", 12345L);
        tracker.add(three);
        result = tracker.findByName("test");
        assertThat(result.size(), is(2));
        assertThat(result.get(0).getName(), is("test"));
        assertThat(result.get(1).getName(), is("test"));
    }

    @Test
    public void whenfindbyidItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item result;
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        result = tracker.findById(item.getId());
        assertThat(result, is(item));
    }
}
