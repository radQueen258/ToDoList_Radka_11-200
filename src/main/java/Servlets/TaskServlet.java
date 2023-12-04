package Servlets;

import Models.Task;
import Repositories.Account.AccountRepositoryJdbclmpl;
import Repositories.Task.TaskRepository;
import Repositories.Task.TaskRepositoryJdbclmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/task")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2MB
        maxFileSize =  1024 * 1024 * 10, //10MB
        maxRequestSize = 1024 * 1024 * 50 ) //50MB
public class TaskServlet extends HttpServlet {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ToDoList";

    private Connection connection;

    private TaskRepository taskRepository;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("userSessionId") != null) {
            return (long) session.getAttribute("userSessionId");
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


//        System.out.println(TaskDeadline1);
//        System.out.println(TaskName);
//        System.out.println(TaskDescription);
        System.out.println(TaskUserId);

        Part filePart = request.getPart("file");
        String fileName = "";
        byte[] fileContent = null;

        if (filePart != null && filePart.getSize() > 0) {
            String uploadPath = "/mnt/Radqueen/Projects Java/ToDoList_Radka_11-200/src/main/java/SavedFiles";
            fileName = filePart.getSubmittedFileName() + " ";
            String fileType = filePart.getContentType();

            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);

            fileContent = Files.readAllBytes(Paths.get(filePath));

            try {

                String sql = "insert into files (user_id, file_name, file_type, file_content, upload_date) values (?,?,?,?, CURRENT_DATE)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, TaskUserId);
                preparedStatement.setString(2, fileName);
                preparedStatement.setString(3, fileType);
                preparedStatement.setBytes(4, fileContent);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            Files.deleteIfExists(Paths.get(filePath));
        }

        Date taskDeadline = Date.valueOf(TaskDeadline1);
        Date currentDate = new Date(System.currentTimeMillis());

        if (taskDeadline.before(currentDate)) {
            response.sendRedirect("/task?error=invalidDeadline");
            return;
        } else {

            Task task = Task.builder()
                    .UserId(TaskUserId)
                    .TaskName(TaskName)
                    .TaskDescription(TaskDescription)
                    .TaskDeadline(Date.valueOf(TaskDeadline1))
                    .build();


            try {
                taskRepository.saveTask(task);
                response.sendRedirect("/taskByUser");
            } catch (SQLException e) {
                response.sendRedirect("/home");
                throw new RuntimeException(e);
            }
        }
    }
}
