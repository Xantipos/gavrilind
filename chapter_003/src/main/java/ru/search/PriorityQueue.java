package ru.search;
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
        //TODO добавить вставку в связанный список.
        if (tasks.size() != 0) {
            int elem = tasks.element().getPriority();
            int newelem = task.getPriority();
            if (elem > newelem) {tasks.add(0,task);}
        } else {tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
