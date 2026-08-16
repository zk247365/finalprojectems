import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Member: Alzaki Elehaimir
 * Date: August 2026
 * Program: Employee Management System
 * Description: Manages the database connection for the Employee
 * Management System. Establishes and provides a connection to the
 * MySQL database using JDBC. Handles connection errors using
 * exception handling to ensure the application runs reliably.
 *
 * Inputs: None
 * Processing: Connects to MySQL ems database using JDBC
 * Output: Returns a live database connection
 */

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/ems";
    private static final String USER = "root";
    private static final String PASSWORD = "admin1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}