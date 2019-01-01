package ru.tracker.storage;
import ru.tracker.model.Item;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @version $Id$
 * @since 0.1
 * @author DmGavrilin
 */
public class Tracker {

    public List<Item>  items = new ArrayList<>(100);
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
                items.set(i, itemIn);
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

        return items.stream()
                .filter(Item -> Item.getName().contains(key))
                .collect(Collectors.toList());
    }

    public Item findById(String id) {
        Item result = null;
        Optional<Item> temp = items.stream()
                .filter(Item -> Item.getId().contains(id))
                .findFirst();
        if (temp.isPresent()) {
            result = temp.get();
        }
        return result;
    }
}

