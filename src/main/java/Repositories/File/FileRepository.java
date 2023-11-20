package Repositories.File;

import Models.File;

import java.sql.SQLException;

public interface FileRepository {

    void saveFile(File file) throws SQLException;
}
