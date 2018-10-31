package ru.tracker.storage;
import ru.tracker.model.Item;

import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 * @author DmGavrilin
 */
public class Tracker {

    public List <Item>  items = new ArrayList<>(100);
    public static final Random RN = new Random();

    private int position = 0;

    public void add(Item item) {
        item.setId(generateId());
        items.add(position, item);
        position++;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public boolean replace(String id, Item itemIn) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items.get(i).getId().equals(id)) {
                itemIn.setId(id);
                items.add(i,itemIn);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    public List<Item> findAll() {
          List<Item> result = new ArrayList<>();
          result.addAll(items);
          return result;
    }

    public Item[] findByName(String key) {
        Item[] resultname = new Item[100];
        int counter = 0;
        for (int i = 0; i < position; i++) {
            if (items.get(i).getName().equals(key)) {
                resultname[counter] = items.get(i);
                counter++;
            }
        }
        return  Arrays.copyOf(resultname, counter);
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items.get(i).getId().equals(id)) {
                result = items.get(i);
            }
        }
        return result;
    }
}

