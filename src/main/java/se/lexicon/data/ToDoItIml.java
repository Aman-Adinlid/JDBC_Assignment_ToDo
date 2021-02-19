package se.lexicon.data;

import se.lexicon.Dao.db.MySqlConnection;
import se.lexicon.model.Person;
import se.lexicon.model.ToDoItem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;


public class ToDoItIml implements ToDoItems {

    @Override
    public ToDoItem create(ToDoItem todo) {
        String query = "insert into todoItem (title,description,deadline,done,assigneeId) value (?,?,?,?,?)";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setString(3, todo.getDeadLine().toString());
            preparedStatement.setBoolean(4, todo.isDone());
            preparedStatement.setInt(5, todo.getAssigneeId());
            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "TodoItem added to list" : "todoItem not added to list");
            ResultSet resultSet1 = preparedStatement.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;

    }

    @Override
    public Collection<ToDoItem> findAll() {
        String query = "select * from todoItem";
        Collection<ToDoItem> toDoItemList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                toDoItemList.add(new ToDoItem(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toDoItemList;
    }

    @Override
    public ToDoItem findById(int todoId) {
        String query = "select * from todoItem where todoId = ?";
        ToDoItem todoItem = new ToDoItem();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setInt(1, todoId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                todoItem.setTodoId(resultSet.getInt(1));
                todoItem.setTitle(resultSet.getString(2));
                todoItem.setDescription(resultSet.getString(3));
                todoItem.setDeadLine(resultSet.getDate(4).toLocalDate());
                todoItem.setDone(resultSet.getBoolean(5));
                todoItem.setAssigneeId(resultSet.getInt(6));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todoItem;
    }

    @Override
    public Collection<ToDoItem> findByDoneStatus(boolean done) {
        String query = "select * from todoItem where done = ?";
        Collection<ToDoItem> toDoItemArrayList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setBoolean(1, done);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                toDoItemArrayList.add(new ToDoItem(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toDoItemArrayList;
    }

    @Override
    public Collection<ToDoItem> findByAssignee(int assigneeId) {

        String query = "select * from todoItem where assigneeId = ?";
        Collection<ToDoItem> toDoItems = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setInt(1, assigneeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                toDoItems.add(new ToDoItem(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toDoItems;
    }

    @Override
    public Collection<ToDoItem> findByAssignee(Person person) {
        String query = "select * from todItem where assigneeId =?";
        Collection<ToDoItem> toDoItemArrayList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setInt(1, person.getPersonId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                toDoItemArrayList.add(new ToDoItem(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toDoItemArrayList;

    }

    @Override
    public Collection<ToDoItem> findByUnassignedTodoItems() {
        String query = "Select * from todoItem where UnassignedId = null";
        Collection<ToDoItem> toDoItemCollection = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                toDoItemCollection.add(new ToDoItem(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toDoItemCollection;
    }

    @Override
    public ToDoItem update(ToDoItem todo) {
        String query = "update todoItem set title=?, description=?, deadline=?, done=?, assigneeId=? where todoId= ?";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setString(3, todo.getDeadLine().toString());
            preparedStatement.setBoolean(4, todo.isDone());
            preparedStatement.setInt(5, todo.getAssigneeId());
            preparedStatement.setInt(6, todo.getTodoId());
            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "TodoItem updated" : "TodoItem not updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    @Override
    public boolean deleteById(int todoId) {

    }
}
