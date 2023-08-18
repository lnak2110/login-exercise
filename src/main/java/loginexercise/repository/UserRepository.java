package loginexercise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import loginexercise.config.MySQLConfig;
import loginexercise.entity.User;

public class UserRepository {
    public User findByEmailAndPassword(String email, String password) {
        String query = "SELECT * FROM User u WHERE u.email = ? AND u.password = ?";

        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));

                return user;
            }
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getLocalizedMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Connecttion closed error " + e.getLocalizedMessage());
                }
            }
        }

        return null;
    }
}
