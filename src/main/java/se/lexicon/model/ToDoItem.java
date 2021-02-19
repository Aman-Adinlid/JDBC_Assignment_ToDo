package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class ToDoItem {

    private int todoId;
    private String title;
    private LocalDate deadLine;
    private String description;
    private boolean done;
    private int assigneeId;


    public ToDoItem() {
    }

    public ToDoItem(int todoId, String title, LocalDate deadLine, String description, boolean done, int assigneeId) {
        this.todoId = todoId;
        this.title = title;
        this.deadLine = deadLine;
        this.description = description;
        this.done = done;
        this.assigneeId = assigneeId;
    }

    public ToDoItem(String title, LocalDate deadLine, String description, boolean done, int assigneeId) {
        this.title = title;
        this.deadLine = deadLine;
        this.description = description;
        this.done = done;
        this.assigneeId = assigneeId;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(int assigneeId) {
        this.assigneeId = assigneeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return todoId == toDoItem.todoId && done == toDoItem.done && assigneeId == toDoItem.assigneeId && Objects.equals(title, toDoItem.title) && Objects.equals(deadLine, toDoItem.deadLine) && Objects.equals(description, toDoItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoId, title, deadLine, description, done, assigneeId);
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "todoId=" + todoId +
                ", title='" + title + '\'' +
                ", deadLine=" + deadLine +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", assigneeId=" + assigneeId +
                '}';
    }

}
