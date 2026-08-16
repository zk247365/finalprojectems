/*
 * Member: Gurleen Kaur
 * Date: 14 August 2026
 * Program: Employee Management System
 * Description: Interface used to define employee pay calculation.
 *
 * Processing:
 * Requires implementing employee classes to provide
 * their own calculatePay() method.
 *
 * Output:
 * Provides a common pay-calculation method for employee types.
 */


public interface Payable {

	double calculatePay();
	
}
