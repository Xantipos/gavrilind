package ru.tracker;
import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 * @author DmGavrilin
 */
public class Tracker {

    public Item[] items = new Item[100];
    public static final Random RN = new Random();

    private int position = 0;

    public void add(Item item) {
        item.setId(generateId());
        items[position] = item;
        position++;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public void replace(String id, Item itemIn) {

        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                itemIn.setId(id);
                items[i] = itemIn;
                break;
            }
        }
    }

    public void delete(String id) {
        for (int i = 0; i < items.length - 1; i++) {
            Item[] akk = new Item[100];
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, 0, items, 0, i);
                System.arraycopy(items, i + 1,  items, 1, i);
                return;
            }
        }
    }

    public Item[] findAll() {
        if (position > 0) {
            return   Arrays.copyOf(items, position);
        }
        return items;
    }

    public Item[] findByName(String key) {
        Item[] resultname = new Item[100];
        int counter = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                resultname[counter] = items[i];
                counter++;
            }
        }
        return  Arrays.copyOf(resultname, counter);
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                return result = items[i];
            }
        }
        return result;
    }
}

