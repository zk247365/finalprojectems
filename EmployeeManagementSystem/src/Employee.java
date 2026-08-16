/*
 * Member: Gurleen Kaur
 * Date: 14 August 2026
 * Program: Employee Management System
 * Description: Abstract base class for employees.
 *
 * Inputs:
 * Employee ID, name, email, phone number, and salary.
 *
 * Processing:
 * Validates employee information and provides getters,
 * setters, and common employee functionality.
 *
 * Output:
 * Stores and provides employee information for the system.
 */


public abstract class Employee {

    private int employeeId;
    private String name;
    private String email;
    private String phone;
    private double salary;

    public Employee(int employeeId, String name, String email, String phone, double salary)
            throws InvalidEmployeeException {

        if (employeeId <= 0) {
            throw new InvalidEmployeeException("Employee ID must be greater than 0.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidEmployeeException("Employee name cannot be empty.");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new InvalidEmployeeException("Employee email cannot be empty.");
        }

        if (!email.contains("@") || !email.contains(".")) {
            throw new InvalidEmployeeException("Employee email must be in a valid format.");
        }
        
        if (phone == null || phone.trim().isEmpty()) {
            throw new InvalidEmployeeException("Employee phone cannot be empty.");
        }

        if (!phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            throw new InvalidEmployeeException(
                    "Employee phone must use the format XXX-XXX-XXXX."
            );
        }

        if (salary < 0) {
            throw new InvalidEmployeeException("Salary cannot be negative.");
        }

        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) throws InvalidEmployeeException {

        if (employeeId <= 0) {
            throw new InvalidEmployeeException("Employee ID must be greater than 0.");
        }

        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidEmployeeException {

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidEmployeeException("Employee name cannot be empty.");
        }

        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmployeeException {

        if (email == null || email.trim().isEmpty()) {
            throw new InvalidEmployeeException("Employee email cannot be empty.");
        }

        if (!email.contains("@") || !email.contains(".")) {
            throw new InvalidEmployeeException("Employee email must be in a valid format.");
        }

        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws InvalidEmployeeException {

        if (phone == null || phone.trim().isEmpty()) {
            throw new InvalidEmployeeException("Employee phone cannot be empty.");
        }

        if (!phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            throw new InvalidEmployeeException(
                    "Employee phone must use the format XXX-XXX-XXXX."
            );
        }

        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws InvalidEmployeeException {

        if (salary < 0) {
            throw new InvalidEmployeeException("Salary cannot be negative.");
        }

        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId
                + ", Name: " + name
                + ", Email: " + email
                + ", Phone: " + phone
                + ", Salary: " + salary;
    }
}