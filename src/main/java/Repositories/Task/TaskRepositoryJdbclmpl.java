package Repositories.Task;

import Models.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskRepositoryJdbclmpl implements TaskRepository{

    private final Connection connection;

    private static final String SQL_INSERT = "insert into Tasks(task_name, description, deadline) values";

    public TaskRepositoryJdbclmpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void saveTask(Task task) throws SQLException {
        String sql = SQL_INSERT + "(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, task.getTaskName());
        preparedStatement.setString(2, task.getTaskDescription());
        preparedStatement.setDate(3, task.getTaskDeadline());

        preparedStatement.executeUpdate();
        System.out.println("Task Executed");
    }
}
