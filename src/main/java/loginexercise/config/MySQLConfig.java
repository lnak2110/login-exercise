package loginexercise.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConfig {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_loginexercise",
                    "root", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connecttion error: " + e.getLocalizedMessage());
        }
        return connection;
    }
}
