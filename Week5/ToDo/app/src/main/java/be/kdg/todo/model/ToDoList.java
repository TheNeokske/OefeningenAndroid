package be.kdg.todo.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToDoList {
    private final List<ToDoItem> items;

    public ToDoList() {
        this.items = new ArrayList<>();
    }

    public void addItem(ToDoItem item) {
        this.items.add(item);
    }

    public ToDoItem getItem(int index) {
        return this.items.get(index);
    }

    public int size() {
        return this.items.size();
    }

    public void remove(ToDoItem item) {
        for (Iterator<ToDoItem> iterator = items.iterator(); iterator.hasNext(); ) {
            ToDoItem next =  iterator.next();
            if (next == item) {
                iterator.remove();
                break;
            }
        }
    }
}
