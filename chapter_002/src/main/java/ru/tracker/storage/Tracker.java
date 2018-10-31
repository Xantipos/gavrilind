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

    public void add(Item item) {
        item.setId(generateId());
        items.add(item);
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public boolean replace(String id, Item itemIn) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                itemIn.setId(id);
                items.set(i,itemIn);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
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

    public List<Item> findByName(String key) {
        List <Item> resultname = new ArrayList<>(100);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(key)) {
                resultname.add(items.get(i));
            }
        }
        return  resultname;
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                result = items.get(i);
            }
        }
        return result;
    }
}

