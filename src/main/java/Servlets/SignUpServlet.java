package Servlets;

import Models.User;
import Repositories.Account.AccountRepository;
import Repositories.Account.AccountRepositoryJdbclmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ToDoList";

    private AccountRepository accountRepository;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            accountRepository = new AccountRepositoryJdbclmpl(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/html/SignUpPage.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountUserEmail = request.getParameter("email");
        String accountUserPass = request.getParameter("password");
        String accountUserNickname = request.getParameter("nickname");

        User user = User.builder()
                .UserEmail(accountUserEmail)
                .UserPassword(accountUserPass)
                .UserNickname(accountUserNickname)
                .build();

        try {
            accountRepository.save(user);
            // redirect to take you to login page after registering
            response.sendRedirect("/save");
        } catch (SQLException e) {
            response.sendRedirect("/signUp");
            throw new RuntimeException(e);
        }
    }
}
