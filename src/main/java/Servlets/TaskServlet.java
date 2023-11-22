package Servlets;

import Models.Task;
import Repositories.Account.AccountRepositoryJdbclmpl;
import Repositories.Task.TaskRepository;
import Repositories.Task.TaskRepositoryJdbclmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ToDoList";

    private TaskRepository taskRepository;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            taskRepository = new TaskRepositoryJdbclmpl(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/html/CreateTask.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TaskName = request.getParameter("task_name");
        String TaskDescription = request.getParameter("description");
        String TaskDeadline1 = request.getParameter("deadline");

        java.sql.Date TaskDeadline = null;
        try {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yy");
            java.util.Date parsedDate = inputDateFormat.parse(TaskDeadline1);
            TaskDeadline = new java.sql.Date(parsedDate.getTime());
        } catch (ParseException e) {
            // Handle parsing exception if the input date format is incorrect
            e.printStackTrace(); // Or log an error message
        }

        Task task = Task.builder()
                .TaskName(TaskName)
                .TaskDescription(TaskDescription)
                .TaskDeadline(TaskDeadline)
                .build();


        try {
            taskRepository.saveTask(task);
            response.sendRedirect("/savedTask");
        } catch (SQLException e) {
            response.sendRedirect("/home");
            throw new RuntimeException(e);
        }
    }
}
