package ru.track;
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
        return String.valueOf(System.currentTimeMillis()+ RN.nextInt());
    }

    public void replace(String id, Item itemIn){
        for (Item item : items){
            if(item.getId().equals(id)){
                item=itemIn;
                break;
            }
        }
    }

    public void delete(String id){
        Item[] akkum = new Item[100];
        System.arraycopy(items,0,akkum,0,items.length);
        for (int i = 0; i < akkum.length; i++ ){
            if(akkum[i].getId().equals(id)){
                int target = i;
                System.arraycopy(akkum,0,items,0,target-1);
                System.arraycopy(akkum,target+1,items,target,akkum.length - target);
            }
        }
    }

    public Item[] findAll(){
        Item[] result = new Item[100];
        int index =0;
        for (Item item : items){
            if(item != null){
                result[index++] = item;
            }
        }
        return result;
    }

    public Item[] findByName(String key){
        Item[] resultname = new Item[100];
        for (Item item : items){
            if(item.getName().equals(key)){
                resultname = this.items;
            }
        }
        return resultname;
    }

    public Item findById(String id){
        Item result = null;
            for (Item item : items){
            if(item.getId().equals(id)){result = item;
            }
            else {break;}
        }
        return result;
    }
}
