/*
 * Member: Gurleen Kaur
 * Date: 14 August 2026
 * Program: Employee Management System
 * Description: Represents a part-time employee.
 *
 * Inputs:
 * Employee ID, name, email, phone number, salary,
 * hourly rate, and hours worked.
 *
 * Processing:
 * Inherits common employee information from Employee
 * and calculates pay using hourly rate multiplied by hours worked.
 *
 * Output:
 * Returns the calculated part-time employee pay.
 */
public class PartTimeEmployee extends Employee implements Payable {

    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(int employeeId, String name, String email, String phone,
                            double salary, double hourlyRate, int hoursWorked)
            throws InvalidEmployeeException {

        super(employeeId, name, email, phone, salary);

        if (hourlyRate < 0) {
            throw new InvalidEmployeeException("Hourly rate cannot be negative.");
        }

        if (hoursWorked < 0) {
            throw new InvalidEmployeeException("Hours worked cannot be negative.");
        }

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) throws InvalidEmployeeException {

        if (hourlyRate < 0) {
            throw new InvalidEmployeeException("Hourly rate cannot be negative.");
        }

        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) throws InvalidEmployeeException {

        if (hoursWorked < 0) {
            throw new InvalidEmployeeException("Hours worked cannot be negative.");
        }

        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}