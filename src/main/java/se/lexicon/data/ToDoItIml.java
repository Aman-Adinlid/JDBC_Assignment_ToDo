package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.ToDoItem;
import java.util.List;

public class ToDoItIml implements ToDoItems {

    @Override
    public ToDoItem create(ToDoItem todo) {
        return null;
    }

    @Override
    public List<ToDoItem> findAll() {
        return null;
    }

    @Override
    public ToDoItem findById(int todoId) {
        return null;
    }

    @Override
    public List<ToDoItem> findByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public List<ToDoItem> findByAssignee(int assigneeId) {
        return null;
    }

    @Override
    public List<ToDoItem> findByAssignee(Person person) {
        return null;
    }

    @Override
    public List<ToDoItem> findByUnassignedTodoItems() {
        return null;
    }

    @Override
    public ToDoItem update(ToDoItem todo) {
        return null;
    }

    @Override
    public boolean deleteById(int todoId) {
        return false;
    }
}
