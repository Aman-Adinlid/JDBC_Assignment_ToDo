package se.lexicon.Dao;

import com.sun.xml.internal.bind.v2.TODO;
import se.lexicon.model.Person;

import java.util.Collection;

public interface ToDoItems {

    TODO create(TODO todo);

    Collection<TODO> findAll();

    TODO findById(int id);

    Collection<TODO> findByDoneStatus(boolean todo);

    Collection<TODO> findByAssignee(int todo);

    Collection<TODO> findByAssignee(Person person);

    Collection<TODO> findByUnAssigneeToDoItems();

    TODO update(TODO todo);

    boolean deleteById(int id);

}
