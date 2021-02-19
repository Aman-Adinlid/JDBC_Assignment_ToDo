package se.lexicon;

import se.lexicon.data.People;
import se.lexicon.data.PeopleIml;
import se.lexicon.data.ToDoItIml;
import se.lexicon.data.ToDoItems;
import se.lexicon.model.Person;

import java.util.Collection;
import java.util.List;


public class App {
    public static void main(String[] args) {
        People dao = new PeopleIml();
        ToDoItems dao1 = new ToDoItIml();


        //Create Person
        //Person createPerson = dao.create(new Person("Aman", "Andersson"));
        //System.out.println(createPerson);

        //findAll
        //Collection<Person> findAll = dao.findAll();
        //findAll.forEach(System.out::println);

        //findById
        //Person findById = dao.findById(4);
        //System.out.println(findById);

        //findByName
        //Collection<Person> personList = dao.findByName("Aman");
        // personList.forEach(System.out::println);

        //Update
        //Person update = new Person(4,"Aman","Andersson");
        //Person person = dao.update(update);

        //delete
        // boolean deletePerson = dao.deleteById(5);

        System.out.println("______________________________________");

    }
}
