package se.lexicon.Dao;

import se.lexicon.model.Person;

import java.util.Collection;

public interface People {

    Person create(Person person);

    Collection<Person> findAll();

    Person findById(int id);

    Collection<Person> findByName(String Name);

    Person update(Person person);

    boolean deleteById(int id);


}
