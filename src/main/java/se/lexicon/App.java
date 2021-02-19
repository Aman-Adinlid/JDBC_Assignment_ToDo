package se.lexicon;

import se.lexicon.data.People;
import se.lexicon.data.PeopleIml;
import se.lexicon.data.ToDoItIml;
import se.lexicon.data.ToDoItems;
import se.lexicon.model.Person;
import se.lexicon.model.ToDoItem;

import java.time.LocalDate;
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

        //Create ToDoItem
        //ToDoItem add= new ToDoItem(1, "Test",LocalDate.parse("2021-01-09"), "good", true, 1);
        // ToDoItem addedTodoItem = dao1.create(add);
        //System.out.println(addedTodoItem);

        // findAll
        //Collection<ToDoItem> findAll = dao1.findAll();
        //findAll.forEach(System.out::println);


        // findById
        //ToDoItem findById = dao1.findById(1);
        //System.out.println(findById);

        // findByDoneStatus
        //Collection <ToDoItem> findByDoneStatus = dao1.findByDoneStatus(false);
        //System.out.println(findByDoneStatus);

        // findByAssignee  id
        //Collection<ToDoItem> findByAssignee = dao1.findByAssignee(2);
        //System.out.println(findByAssignee);


        // findByAssignee (person)
        //Collection<ToDoItem> findByAssignee = dao1.findByAssignee( new Person (4, "Aman", "Andersson"));
        //findByAssignee.forEach(System.out::println);


        // findByUnassignedItem
        // ToDoItem createUnassignedItem = new ToDoItem(1,"Test",LocalDate.parse("2021-01-09"), "good", true, 1);
        // ToDoItem addToList = dao1.create(createUnassignedItem);
        // System.out.println(addToList);


        // Update
        //ToDoItem update = new ToDoItem(1,"test",LocalDate.parse("2021-02-19"),"bad",true,2);
        //ToDoItem updatedTodoItem = dao1.update(update);
        //System.out.println(updatedTodoItem);


        //delete
        dao1.deleteById(2);

    }
}
