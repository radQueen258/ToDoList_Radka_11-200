package Repositories.Account;

import Models.User;
import Repositories.Config.UserRoleRepository;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountRepositoryJdbclmpl extends UserRoleRepository implements AccountRepository {

    private final Connection connection;
    private static final String SQL_INSERT ="insert into users(email, nickname, password, registration_date) values";

    public AccountRepositoryJdbclmpl(Connection connection) {
        super();
        this.connection = connection;
    }


    @Override
    public long getDefaultUserRoleID() throws SQLException {
        String roleQuery = "select role_id from roles where role_name = 'USER' ";

        try(PreparedStatement preparedStatement = connection.prepareStatement(roleQuery)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getLong("role_id");
                }
            }
        }

        throw new SQLException("Default user role 'USER' not found.");
    }

    @Override
    public void save(User user) throws SQLException {

        String sql = SQL_INSERT + "(?,?,?, CURRENT_DATE)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUserEmail());
        preparedStatement.setString(2, user.getUserNickname());
        preparedStatement.setString(3, user.getUserPassword());
//        preparedStatement.setDate(4, user.getUserRegistration());
//        preparedStatement.setBoolean(5, user.getUserEmailVerification());

        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        if (generatedKeys.next()) {
            long userId = generatedKeys.getLong(1);
            long userRoleId = getDefaultUserRoleID();

            assignRoleToUser(userId, userRoleId);

        } else {
            throw new SQLException("User creation failed no ID obtained.");
        }

    }

    @Override
    public boolean login(String email, String password, User user, HttpServletRequest request) throws SQLException {

        String sql = "SELECT user_id, email, password FROM users WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUserEmail());
        ResultSet resultSet = preparedStatement.executeQuery();

        String userAcc = "";
        String passAcc = "";
        long userId = -1;

        while (resultSet.next()) {
            userAcc = resultSet.getString("email");
            passAcc = resultSet.getString("password");
            userId = resultSet.getLong("user_id");
            System.out.println("Retrieved username: " + userAcc);
            System.out.println("Retrieved password: " + passAcc);
        }


        if(userAcc != null && passAcc != null && BCrypt.checkpw(password, passAcc)){
           HttpSession session = request.getSession();
           session.setAttribute("userId", userId);

            List<String> userRoles = getUserRole(userId);

            if (userRoles != null && !userRoles.isEmpty()) {
                session.setAttribute("userRoles", userRoles);
                return true;
            }

        }
        return  false;
    }
}
