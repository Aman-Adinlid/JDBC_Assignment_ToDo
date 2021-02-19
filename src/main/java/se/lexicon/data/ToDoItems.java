package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.ToDoItem;

import java.util.Collection;
import java.util.List;

public interface ToDoItems {

    ToDoItem create(ToDoItem todo);

    Collection<ToDoItem> findAll();

    ToDoItem findById(int todoId);

    Collection<ToDoItem> findByDoneStatus(boolean done);

    Collection<ToDoItem> findByAssignee(int assigneeId);

    Collection<ToDoItem> findByAssignee(Person person);

    Collection<ToDoItem> findByUnassignedTodoItems();

    ToDoItem update(ToDoItem todo);

    boolean deleteById(int todoId);


}
