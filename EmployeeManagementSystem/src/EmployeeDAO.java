import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Member: Alzaki Elehaimir
 * Date: August 2026
 * Program: Employee Management System
 * Description: Data Access Object for Employee Management System.
 * Handles all database CRUD operations for employees including
 * adding, viewing, updating and deleting employee records.
 *
 * Inputs: Employee objects and employee IDs
 * Processing: Executes SQL queries to manage employee data
 * Output: Employee records from the database
 */

public class EmployeeDAO {

    // CREATE - Add new employee
    public void addEmployee(String name, String email, String phone,
                            double salary, String employeeType,
                            double hourlyRate, int hoursWorked) {
        String sql = "INSERT INTO employees (name, email, phone, salary, " +
                     "employeeType, hourlyRate, hoursWorked) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setDouble(4, salary);
            stmt.setString(5, employeeType);
            stmt.setDouble(6, hourlyRate);
            stmt.setInt(7, hoursWorked);
            stmt.executeUpdate();
            System.out.println("Employee added successfully!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    // READ - Display all employees
    public void getAllEmployees() {
        String sql = "SELECT * FROM employees";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\n--- All Employees ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("employeeId") +
                        " | Name: " + rs.getString("name") +
                        " | Email: " + rs.getString("email") +
                        " | Phone: " + rs.getString("phone") +
                        " | Type: " + rs.getString("employeeType") +
                        " | Salary: " + rs.getDouble("salary"));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
        }
    }

    // UPDATE - Update employee salary
    public void updateEmployeeSalary(int employeeId, double newSalary) {
        String sql = "UPDATE employees SET salary = ? WHERE employeeId = ?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, newSalary);
            stmt.setInt(2, employeeId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee salary updated successfully!");
            } else {
                System.out.println("Employee not found.");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    // DELETE - Remove employee
    public void deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE employeeId = ?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, employeeId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found.");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}