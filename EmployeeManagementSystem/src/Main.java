import java.util.Scanner;

/*
 * Member: Alzaki Elehaimir
 * Date: August 2026
 * Program: Employee Management System
 * Description: Main entry point for the Employee Management System.
 * Provides a command line menu for users to manage employees
 * including adding, viewing, updating and deleting employee records.
 *
 * Inputs: User menu choices and employee information
 * Processing: Calls EmployeeDAO methods to perform database operations
 * Output: Employee records and confirmation messages
 */

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter option: ");

            choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter phone (XXX-XXX-XXXX): ");
                String phone = scanner.nextLine();
                System.out.print("Enter employee type (FullTime/PartTime): ");
                String type = scanner.nextLine();
                double salary = 0;
                double hourlyRate = 0;
                int hoursWorked = 0;
                if (type.equalsIgnoreCase("FullTime")) {
                    System.out.print("Enter salary: ");
                    salary = Double.parseDouble(scanner.nextLine());
                } else {
                    System.out.print("Enter hourly rate: ");
                    hourlyRate = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter hours worked: ");
                    hoursWorked = Integer.parseInt(scanner.nextLine());
                }
                dao.addEmployee(name, email, phone, salary, type, hourlyRate, hoursWorked);

            } else if (choice == 2) {
                dao.getAllEmployees();

            } else if (choice == 3) {
                System.out.print("Enter employee ID to update: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new salary: ");
                double newSalary = Double.parseDouble(scanner.nextLine());
                dao.updateEmployeeSalary(id, newSalary);

            } else if (choice == 4) {
                System.out.print("Enter employee ID to delete: ");
                int id = Integer.parseInt(scanner.nextLine());
                dao.deleteEmployee(id);

            } else if (choice != 5) {
                System.out.println("Invalid option. Please try again.");
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
}