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
import javax.servlet.http.HttpSession;
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

    public long getUserIDFromCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            return (long) session.getAttribute("userId");
        } else {
            // Handle the case where the user is not logged in or the user ID is not in the session
            return -1; // Or return any default value indicating no user ID
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TaskName = request.getParameter("task_name");
        String TaskDescription = request.getParameter("description");
        String TaskDeadline1 = request.getParameter("deadline");
        long TaskUserId = getUserIDFromCurrentUser(request);


        System.out.println(TaskDeadline1);
        System.out.println(TaskName);
        System.out.println(TaskDescription);
        System.out.println(TaskUserId);

//        java.sql.Date TaskDeadline2 = null;
//
//
//            try {
//                SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM-dd-yy");
//                java.util.Date parsedDate = inputDateFormat.parse(TaskDeadline1);
//                if (parsedDate != null) {
//                    TaskDeadline2 = new java.sql.Date(parsedDate.getTime());
//                }
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }


        Task task = Task.builder()
                .UserId(TaskUserId)
                .TaskName(TaskName)
                .TaskDescription(TaskDescription)
                .TaskDeadline(Date.valueOf(TaskDeadline1))
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
