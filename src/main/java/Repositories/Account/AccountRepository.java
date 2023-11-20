package Repositories.Account;

import Models.User;

import java.sql.SQLException;

public interface AccountRepository {
    void save(User user) throws SQLException;
    boolean login (String email, String password, User user) throws SQLException;
}
