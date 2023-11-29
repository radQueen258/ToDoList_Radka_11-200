package Repositories.File;

import Models.Filees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileRepositoryJdbclmpl implements FileRepository{

    private final Connection connection;
    private static final String SQL_INSERT = "insert into Files(file_name, file_type, file_content, upload_date) values";

    public FileRepositoryJdbclmpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveFile(Filees file) throws SQLException {

        String sql = SQL_INSERT + "(?,?,?, CURRENT_DATE)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, file.getFileName());
        preparedStatement.setString(2, file.getFileType());
        preparedStatement.setString(3, file.getFileContent());

        preparedStatement.executeUpdate();
        System.out.println("File Executed");

    }
}
