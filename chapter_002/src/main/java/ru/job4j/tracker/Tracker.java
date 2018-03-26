package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.Random;

/**
 * Tracker.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();

    private int position = 0;
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        this.position++;
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + new Random().nextInt());
    }

    public void replace(String id, Item item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) != null && id.equals(this.items.get(i).getId())) {
                this.items.get(i).setName(item.getName());
                this.items.get(i).setDesc(item.getDesc());
                this.items.get(i).setCreated(item.getCreated());
            }
        }
    }
    public void delete(String id) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) != null && id.equals(items.get(i).getId())) {
                this.items.remove(i);
                position--;
            }
        }

    }
    public ArrayList<Item> getAll() {
        ArrayList<Item> item = new ArrayList<>();
        item.addAll(this.items);
        return item;
    }
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> item = new ArrayList<>();
        int b = 0;
        for (int i = 0; i < this.position; i++) {
            if (key.equals(this.items.get(i).getName())) {
                item.add(this.items.get(i));
                b++;
            }
        }
        ArrayList<Item> item1 = new ArrayList<>();
        item1.addAll(item);
        return item1;

    }
    public Item findById(String id) {
        Item item = null;
        for (Item item1: this.items) {
            if (item1 != null && id.equals(item1.getId())) {
                item = item1;
            }
        }
        return item;
    }
}
