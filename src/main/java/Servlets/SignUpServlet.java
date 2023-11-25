package Servlets;

import Models.User;
import Repositories.Account.AccountRepository;
import Repositories.Account.AccountRepositoryJdbclmpl;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ToDoList";

    private AccountRepository accountRepository;
    private Connection connection;

    public SignUpServlet() throws SQLException {
    }

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        accountRepository = new AccountRepositoryJdbclmpl(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/html/SignUpPage.html").forward(request, response);
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private void assignUserRole(long userId) throws SQLException {
//        String sqlGetRoleId = "select role_id from roles where role_name = 'USER'";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlGetRoleId)){
//            preparedStatement.setString(1,roleName);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if(resultSet.next()) {
//                Long roleId = resultSet.getLong("role_id");
//                String sqlAssignRole = "insert into user_role (user_id, role_id value (?,)";
//
//                try {
//                    PreparedStatement preparedStatementAssign = connection.prepareStatement(sqlAssignRole);
//                    preparedStatementAssign.setLong(1, userId);
//                    preparedStatementAssign.setLong(2,roleId);
//                    preparedStatementAssign.executeUpdate();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }

        String sql = "INSERT INTO user_roles (user_id, role_id) VALUES (?,2)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, userId);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountUserEmail = request.getParameter("email");
        String accountUserPass = request.getParameter("password");
        String accountUserNickname = request.getParameter("nickname");
//        System.out.println(accountUserEmail);
//        System.out.println(accountUserNickname);
        String hashedPassword = hashPassword(accountUserPass);


        User user = User.builder()
                .UserEmail(accountUserEmail)
                .UserPassword(hashedPassword)
                .UserNickname(accountUserNickname)
                .build();

        long userId = -1;

        try {
            accountRepository.save(user);

            String sqlUserId = "SELECT user_id FROM users WHERE email = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUserId)) {
                preparedStatement.setString(1, accountUserEmail);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    userId = resultSet.getLong("user_id"); // Retrieve the user_id
                }


//            long userId = -1;
//            HttpSession session = request.getSession();
//            session.setAttribute("userId", userId);
//            System.out.println(userId);       \

                String sql = "insert into user_roles (user_id, role_id) values (?, ?)";
                try(PreparedStatement preparedStatement1 = connection.prepareStatement(sql)) {
                    preparedStatement1.setLong(1,userId);
                    preparedStatement1.setLong(2,2);
                    preparedStatement1.executeUpdate();
                }


                // redirect to take you to login page after registering
                response.sendRedirect("/save");
            } catch (SQLException e) {
                response.sendRedirect("/signUp");
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
