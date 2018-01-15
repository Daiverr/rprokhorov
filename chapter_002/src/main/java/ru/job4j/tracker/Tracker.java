package ru.job4j.tracker;
import java.util.Random;

/**
 * Tracker.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private final Item[] items = new Item[100];

    private int position = 0;
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + new Random().nextInt());
    }

    public void replace(String id, Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && id.equals(this.items[i].getId())) {
                this.items[i] = item;
            }
        }
    }
    public void delete(String id) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && id.equals(items[i].getId())) {
                System.arraycopy(this.items, i + 1 , this.items, i, this.items.length  - (i + 1));
                position--;
            }
        }

    }
    public Item[] getAll() {
        Item[] item = new Item[this.position];
        System.arraycopy(this.items, 0, item, 0, position);
        return item;
    }
    public Item[] findByName(String key) {
        Item[] item = new Item[position];
        int b = 0;
        for (int i = 0; i < this.position; i++) {
            if (key.equals(this.items[i].getName())) {
                item[b++] = this.items[i];
            }
        }
        Item[] item1 = new Item[b];
        System.arraycopy(item, 0, item1, 0, b);
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
