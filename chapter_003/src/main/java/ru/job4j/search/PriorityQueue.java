package ru.job4j.search;
/**
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import java.util.Iterator;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        Iterator<Task> iterator = tasks.listIterator();
        if (iterator.hasNext()) {
            Task element = iterator.next();
            if (element.getPriority() > task.getPriority()) {
                tasks.add(tasks.indexOf(element), task);
            }
        } else {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
