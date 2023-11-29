//package Servlets;
//
//import Models.Filees;
//import Repositories.File.FileRepository;
//import Repositories.File.FileRepositoryJdbclmpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Arrays;
//
//@WebServlet("/upload")
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2MB
//        maxFileSize =  1024 * 1024 * 10, //10MB
//        maxRequestSize = 1024 * 1024 * 50 ) //50MB
//public class FileServlet extends HttpServlet {
//
//    private static final String DB_USER = "postgres";
//    private static final String DB_PASSWORD = "postgres";
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ToDoList";
//
//    private Connection connection;
//    private FileRepository fileRepository;
//    @Override
//    public void init() throws ServletException {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//            fileRepository = new FileRepositoryJdbclmpl(connection);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/html/CreateTask.html").forward(request,response);
//    }
//
//    private String extractFileName (Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        String[] tokens = contentDisp.split(";");
//
//        for (String token : tokens) {
//            if (token.trim().startsWith("filename")) {
//                return token.substring(token.indexOf("=") + 2, token.length() - 1);
//            }
//        }
//
//        return "";
//    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String uploadPath = "/mnt/Radqueen/Projects Java/ToDoList_Radka_11-200/src/main/java/SavedFiles";
//
//        Part filePart = request.getPart("file");
//        String fileName = extractFileName(filePart);
//        String fileType = filePart.getContentType();
//
//        String filePath = uploadPath + File.separator + fileName;
//        filePart.write(filePath);
//
//        byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
//
//        Filees filees = Filees.builder()
//                .FileName(fileName)
//                .FileType(fileType)
//                .FileContent(Arrays.toString(fileContent))
//                .build();
//
//        try {
//            fileRepository.saveFile(filees);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//
//            String sql = "insert into files (file_name, file_type, file_content, upload_date) values (?,?,?, CURRENT_DATE)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, fileName);
//            preparedStatement.setString(2, fileType);
//            preparedStatement.setBytes(3, fileContent);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("File Executed");

//        Files.deleteIfExists(Paths.get(filePath));

//    }
//}
