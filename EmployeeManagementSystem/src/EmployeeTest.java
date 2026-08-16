/*
 * Member: Gurleen Kaur
 * Date: 14 August 2026
 * Program: Employee Management System
 * Description: Tests employee classes, pay calculations,
 * validation, and exception handling.
 *
 * Inputs:
 * Valid and invalid employee information.
 *
 * Processing:
 * Creates full-time and part-time employees,
 * calculates pay, and tests invalid employee information.
 *
 * Output:
 * Displays employee information, calculated pay,
 * and validation error messages.
 */
public class EmployeeTest {

    public static void main(String[] args) {

        try {

            FullTimeEmployee employee1 = new FullTimeEmployee(
                    101,
                    "John Smith",
                    "john@email.com",
                    "403-555-1234",
                    5000
            );

            System.out.println("Employee ID: " + employee1.getEmployeeId());
            System.out.println("Name: " + employee1.getName());
            System.out.println("Email: " + employee1.getEmail());
            System.out.println("Phone: " + employee1.getPhone());
            System.out.println("Salary: " + employee1.getSalary());

            System.out.println("Calculated Pay: " + employee1.calculatePay());
            System.out.println(employee1);

            PartTimeEmployee employee2 = new PartTimeEmployee(
                    102,
                    "Sarah Jones",
                    "sarah@email.com",
                    "403-555-5678",
                    0,
                    25,
                    80
            );

            System.out.println();
            System.out.println("Part-Time Employee");
            System.out.println("Employee ID: " + employee2.getEmployeeId());
            System.out.println("Name: " + employee2.getName());
            System.out.println("Email: " + employee2.getEmail());
            System.out.println("Phone: " + employee2.getPhone());
            System.out.println("Hourly Rate: " + employee2.getHourlyRate());
            System.out.println("Hours Worked: " + employee2.getHoursWorked());
            System.out.println("Calculated Pay: " + employee2.calculatePay());
            System.out.println(employee1);

            
            System.out.println();
            System.out.println("Testing invalid employee:");

            FullTimeEmployee invalidEmployee = new FullTimeEmployee(
                    -1,
                    "",
                    "bad@email.com",
                    "403-555-9999",
                    -5000
            );
            
            

        } catch (InvalidEmployeeException e) {

            System.out.println("Error: " + e.getMessage());

        }
        
        System.out.println();
        System.out.println("Testing invalid part-time employee:");

        try {

            PartTimeEmployee invalidPartTime = new PartTimeEmployee(
                    103,
                    "Mike Brown",
                    "mike@email.com",
                    "403-555-1111",
                    0,
                    -20,
                    40
            );

        } catch (InvalidEmployeeException e) {

            System.out.println("Error: " + e.getMessage());

        }
        
        System.out.println();
        System.out.println("Testing invalid email:");

        try {

            FullTimeEmployee invalidEmail = new FullTimeEmployee(
                    104,
                    "David Brown",
                    "davidemail.com",
                    "403-555-2222",
                    4000
            );

        } catch (InvalidEmployeeException e) {

            System.out.println("Error: " + e.getMessage());

        }
        
        System.out.println();
        System.out.println("Testing invalid phone:");

        try {

            FullTimeEmployee invalidPhone = new FullTimeEmployee(
                    105,
                    "Lisa Brown",
                    "lisa@email.com",
                    "4035553333",
                    4000
            );

        } catch (InvalidEmployeeException e) {

            System.out.println("Error: " + e.getMessage());

        }
    }
}