package Repositories.Account;

import Models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepositoryJdbclmpl implements AccountRepository{

    private final Connection connection;
    private static final String SQL_INSERT ="insert into users(email, nickname, password, registration_date) values";

    public AccountRepositoryJdbclmpl(Connection connection) {
        this.connection = connection;
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
        System.out.println("Executed");

    }

    @Override
    public boolean login(String email, String password, User user, HttpServletRequest request) throws SQLException {

        String sql = "SELECT user_id, email, password FROM Users WHERE email = ?";
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


        if(userAcc != null && passAcc != null && userAcc.equals(email) && passAcc.equals(password)){
           HttpSession session = request.getSession();
           session.setAttribute("userId", userId);
            System.out.println(userId);
            return true;
        }else {

            return false;
        }


    }
}
