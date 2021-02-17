package se.lexicon.Dao;

import com.sun.xml.internal.bind.v2.TODO;
import se.lexicon.model.Person;

import java.util.Collection;

public class ToDoItIml implements ToDoItems{
    @Override
    public TODO create(TODO todo) {
        return null;
    }

    @Override
    public Collection<TODO> findAll() {
        return null;
    }

    @Override
    public TODO findById(int id) {
        return null;
    }

    @Override
    public Collection<TODO> findByDoneStatus(boolean todo) {
        return null;
    }

    @Override
    public Collection<TODO> findByAssignee(int todo) {
        return null;
    }

    @Override
    public Collection<TODO> findByAssignee(Person person) {
        return null;
    }

    @Override
    public Collection<TODO> findByUnAssigneeToDoItems() {
        return null;
    }

    @Override
    public TODO update(TODO todo) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
