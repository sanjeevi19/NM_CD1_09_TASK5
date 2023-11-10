import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHandler {
    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/yourdb";
    private static final String DB_USER = "yourdbuser";
    private static final String DB_PASSWORD = "yourdbpassword";

    public boolean authenticateUser(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);

            // Prepare a SQL query to check the user's credentials
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // If there is a matching record, authentication is successful.

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Authentication failed on error.
        }
    }
}
