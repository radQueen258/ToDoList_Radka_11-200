package Repositories.Task;

import Models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryJdbclmpl implements TaskRepository {

    private Connection connection;
    private Statement statement;

    private static final String SQL_INSERT = "insert into tasks(user_id,task_name, description, deadline) values";

    public TaskRepositoryJdbclmpl(Connection connection) {
        this.connection = connection;
    }

    public TaskRepositoryJdbclmpl(Statement statement) {
        this.statement = statement;
    }

    public TaskRepositoryJdbclmpl(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

    @Override
    public void saveTask(Task task) throws SQLException {
        String sql = SQL_INSERT + "(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,task.getUserId());
        preparedStatement.setString(2, task.getTaskName());
        preparedStatement.setString(3, task.getTaskDescription());
        preparedStatement.setDate(4, task.getTaskDeadline());

        preparedStatement.executeUpdate();
        System.out.println("Task Executed");
    }

    @Override
    public List findByUser (long userId) {

        String SQL_SELECT =  "select * from tasks where user_id = ?";

        try {
           Statement statement1 = connection.createStatement();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
//            preparedStatement.setLong(1,userId);
//            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT);

            List<Task> userTasks = new ArrayList<>();

            while (resultSet.next()) {

                Task task1 = Task.builder()
                        .TaskId(resultSet.getLong("task_id"))
                        .UserId(resultSet.getLong("user_id"))
                        .TaskName(resultSet.getString("task_name"))
                        .TaskDescription(resultSet.getString("description"))
                        .TaskDeadline(resultSet.getDate("deadline"))
                        .build();
                userTasks.add(task1);
            }

            return userTasks;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
