/*
 * Member: Gurleen Kaur
 * Date: 14 August 2026
 * Program: Employee Management System
 * Description: Represents a full-time employee.
 *
 * Inputs:
 * Employee ID, name, email, phone number, and salary.
 *
 * Processing:
 * Inherits common employee information from Employee
 * and calculates full-time employee pay using salary.
 *
 * Output:
 * Returns the employee's salary as calculated pay.
 */


public class FullTimeEmployee extends Employee implements Payable {

    public FullTimeEmployee(int employeeId, String name, String email, String phone, double salary)
            throws InvalidEmployeeException {

        super(employeeId, name, email, phone, salary);
    }

    @Override
    public double calculatePay() {
        return getSalary();
    }
}