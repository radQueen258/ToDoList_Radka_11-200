package Repositories.Config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleRepository {

    private Connection connection;

    public UserRoleRepository() {
        this.connection = connection;
    }

    public void assignRoleToUser(long userId, long roleId) throws SQLException {
        String sql = "INSERT INTO user_role (user_id, role_id) VALUES (?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,userId);
            preparedStatement.setLong(2,roleId);
            preparedStatement.executeUpdate();
        }
    }

    public List<String> getUserRole(long userId) throws SQLException {
        List<String> userRoles = new ArrayList<>();
        String sql = "SELECT r.role_name " +
                "FROM roles r " +
                "JOIN user_role ur ON r.role_id = ur.role_id " +
                "WHERE ur.user_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String roleName = resultSet.getString("role_name");
                userRoles.add(roleName);
            }

        }
        return  userRoles;
    }
}
