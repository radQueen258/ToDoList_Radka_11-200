package Repositories.Task;

import Models.Task;

import java.sql.SQLException;

public interface TaskRepository {
    void saveTask (Task task) throws SQLException;
}
