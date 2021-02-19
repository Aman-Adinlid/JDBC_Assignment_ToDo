package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.ToDoItem;
import java.util.List;

public interface ToDoItems {

    ToDoItem create(ToDoItem todo);

    List<ToDoItem> findAll();

    ToDoItem findById(int todoId);

    List<ToDoItem> findByDoneStatus(boolean done);

    List<ToDoItem> findByAssignee(int assigneeId);

    List<ToDoItem> findByAssignee(Person person);

    List<ToDoItem> findByUnassignedTodoItems();

    ToDoItem update(ToDoItem todo);

    boolean deleteById(int todoId);


}
