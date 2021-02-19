package se.lexicon.data;

import se.lexicon.Dao.db.MySqlConnection;
import se.lexicon.model.Person;
import se.lexicon.model.ToDoItem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
