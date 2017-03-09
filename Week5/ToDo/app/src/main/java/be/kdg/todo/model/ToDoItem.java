package be.kdg.todo.model;

public class ToDoItem {
    private final long id;
    private final String description;

    public ToDoItem(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }
}
