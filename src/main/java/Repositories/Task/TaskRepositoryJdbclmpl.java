package Repositories.Task;

import Models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryJdbclmpl implements TaskRepository {

    private Connection connection;
    private Statement statement;

    private static final String SQL_INSERT = "insert into tasks(user_id,task_name, description, deadline) values";
    private static final String SQL_SELECT = "select task_id, task_name, description, deadline from tasks where user_id = ?";

//    private static final String SQL_SELECT_FROM_DRIVER = "select user_id,task_name, description, deadline from tasks";

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

        try {
           Statement statement1 = connection.createStatement();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
//            preparedStatement.setLong(1,userId);
//            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT);

            List<Task> userTasks = new ArrayList<>();

            while (resultSet.next()) {

                Task task = Task.builder()
                        .TaskId(resultSet.getLong("task_id"))
                        .UserId(resultSet.getLong("user_id"))
                        .TaskName(resultSet.getString("task_name"))
                        .TaskDescription(resultSet.getString("description"))
                        .TaskDeadline(resultSet.getDate("deadline"))
                        .build();

                userTasks.add(task);
            }

            return userTasks;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//    @Override
//    public List findAll() {
//        try{
//            Statement statement1 = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SQL_SELECT_FROM_DRIVER);
//            List<Task> result = new ArrayList<>();
//
//            while (resultSet.next()) {
//                Task task = Task.builder()
//                        .UserId(resultSet.getLong("user_id"))
//                        .TaskName(resultSet.getString("task_name"))
//                        .TaskDescription(resultSet.getString("description"))
//                        .TaskDeadline(resultSet.getDate("deadline"))
//                        .build();
//
//                result.add(task);
//            }
//
//            return result;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
