package se.lexicon.data;

import se.lexicon.Dao.db.MySqlConnection;
import se.lexicon.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;


public class PeopleIml implements People {

    @Override
    public Person create(Person person) {
        String query = "insert into person (firstName, lastName) values (?,?)";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, person.getFirstname());
            preparedStatement.setString(2, person.getLastName());

            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "New person added to database" : "Person not ok");
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int idKey = 0;
            while (rs.next()) {
                idKey = rs.getInt(1);
            }
            person.setPersonId(idKey);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Collection<Person> findAll() {
        String query = "select * from person";
        Collection<Person> personList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                personList.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Person findById(int personId) {
        String query = "select * from person where personId=?";
        Person person = new Person();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setInt(1, personId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person.setPersonId(resultSet.getInt("personId"));
                person.setFirstname(resultSet.getString("firstName"));
                person.setLastName(resultSet.getString("lastName"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Collection<Person> findByName(String Name) {
        String query = "select * from person where firstName=?";
        Collection<Person> personList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setString(1, Name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                personList.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Person update(Person person) {
        String query = "update person set firstName=?, lastName=? where personId= ?";

        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setString(1, person.getFirstname());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getPersonId());

            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Person updated to database" : "Person not updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public boolean deleteById(int personId) {
        String query = "delete from person where personId= ?";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {

            preparedStatement.setInt(1, personId);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Person deleted from database" : "Person not deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
