package Repositories.Account;

import Models.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface AccountRepository {
    long getDefaultUserRoleID() throws SQLException;
    void save(User user) throws SQLException;
    boolean login (String email, String password, User user, HttpServletRequest request) throws SQLException;
}
