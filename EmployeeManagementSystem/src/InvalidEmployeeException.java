/*
 * Member: Gurleen Kaur
 * Date: 14 August 2026
 * Program: Employee Management System
 * Description: Custom exception for invalid employee information.
 *
 * Input:
 * Error message describing the invalid employee information.
 *
 * Processing:
 * Extends Java's Exception class and passes the error message
 * to the parent exception class.
 *
 * Output:
 * Provides a meaningful error message when invalid employee
 * information is entered.
 */
public class InvalidEmployeeException extends Exception {

    public InvalidEmployeeException(String message) {
        super(message);
    }
}