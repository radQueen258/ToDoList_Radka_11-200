package Repositories.Task;

import Models.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskRepository {
    void saveTask (Task task) throws SQLException;
    List findByUser(long userId);
}
