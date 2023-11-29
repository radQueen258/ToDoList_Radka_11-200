package Repositories.File;

import Models.Filees;

import java.sql.SQLException;

public interface FileRepository {

    void saveFile(Filees file) throws SQLException;
}
