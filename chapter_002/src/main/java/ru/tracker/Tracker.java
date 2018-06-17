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
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                int target = i;
                System.arraycopy(items, 0, items, 0, target - 1);
                System.arraycopy(items, target + 1,  items, target, items.length - target);
            }
        }
    }

    public Item[] findAll() {
        for (Item item : items) {
            if (item == null) {
                return   Arrays.copyOf(items, position);
            }
        }
        return items;
    }

    public Item[] findByName(String key) {
        Item[] resultname = new Item[100];
        int counter = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                resultname[counter] = item;
                counter++;
            }
        }
        return  Arrays.copyOf(resultname, counter);
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return result = item;
            }
        }
        return result;
    }
}

