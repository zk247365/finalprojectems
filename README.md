# Employee Management System

## Project Overview

The **Employee Management System (EMS)** is a Java-based, command-line application developed as part of our final project for OOP2 course at SAIT.

The purpose of the system is to provide a simple way to manage employee records while demonstrating Object-Oriented Programming (OOP), database connectivity, CRUD operations, inheritance, interfaces, abstract classes, custom exception handling, and SQL database integration.

The application allows users to add employees, view employee records, update an employee's salary, and delete employee records. Employee information is stored persistently in a MySQL database.

## Technologies Used

- **Java** — application development and Object-Oriented Programming
- **MySQL** — relational database used to store employee records
- **JDBC (Java Database Connectivity)** — connects the Java application to MySQL
- **Eclipse IDE** — development environment
- **SQL** — database creation and CRUD operations
- **GitHub** — source-code version control and project repository
- **MySQL Connector/J** — JDBC driver required for the Java/MySQL connection

## Main Features

The Employee Management System provides the following functionality:

### 1. Add Employee

Users can add a new employee by entering:

- Employee name
- Email address
- Phone number
- Employee type
- Salary for a full-time employee
- Hourly rate and hours worked for a part-time employee

### 2. View All Employees

Users can display the employee records stored in the MySQL database.

### 3. Update Employee Salary

Users can enter an employee ID and update the employee's salary.

### 4. Delete Employee

Users can enter an employee ID to remove an employee record from the database.

### 5. Database Integration

The application uses JDBC to establish a connection between Java and the MySQL `ems` database. Database operations are performed through the `EmployeeDAO` class.

### 6. Input and Data Validation

Employee information includes validation for required fields, email format, phone number format, employee ID, and non-negative salary values. The command-line interface should also validate numeric and menu input so invalid entries do not terminate the application unexpectedly.

### 7. Exception Handling

The project includes a custom `InvalidEmployeeException` for invalid employee information, as well as SQL exception handling for database operations.

## Object-Oriented Programming

The project demonstrates several OOP concepts required by the assignment.

### Abstract Class

`Employee` is an abstract base class that contains common employee information and functionality.

Common employee information includes:

- Employee ID
- Name
- Email
- Phone number
- Salary

### Inheritance

The project uses inheritance to create specialized employee types:

- `FullTimeEmployee` extends `Employee`
- `PartTimeEmployee` extends `Employee`

This allows common employee functionality to be reused while allowing each employee type to provide its own implementation.

### Interface

The `Payable` interface defines payment-related behavior implemented by employee subclasses.

### Encapsulation

Employee attributes are kept private and accessed through public getter and setter methods. Validation is performed when appropriate values are assigned.

### Custom Exception

`InvalidEmployeeException` is a user-defined exception used to handle invalid employee information and provide meaningful error messages.

## Project Structure

```text
finalprojectems/
│
├── EmployeeManagementSystem/
│   └── src/
│       ├── DatabaseConnection.java
│       ├── Employee.java
│       ├── EmployeeDAO.java
│       ├── EmployeeTest.java
│       ├── FullTimeEmployee.java
│       ├── InvalidEmployeeException.java
│       ├── Main.java
│       ├── PartTimeEmployee.java
│       └── Payable.java
│
├── ems.sql
│
└── README.md
```

## Class Responsibilities

| Class / File | Purpose |
|---|---|
| `Main.java` | Provides the command-line menu and collects user input. |
| `DatabaseConnection.java` | Establishes the JDBC connection to the MySQL database. |
| `EmployeeDAO.java` | Performs database CRUD operations for employee records. |
| `Employee.java` | Abstract base class containing common employee information and validation. |
| `FullTimeEmployee.java` | Represents full-time employees and implements payment behavior. |
| `PartTimeEmployee.java` | Represents part-time employees and implements payment behavior. |
| `Payable.java` | Interface defining payment-related behavior. |
| `InvalidEmployeeException.java` | Custom exception for invalid employee information. |
| `EmployeeTest.java` | Contains tests for employee-related functionality. |
| `ems.sql` | SQL dump used to create and populate the `employees` table. |

## Database

The project uses a MySQL database named:

```text
ems
```

The main database table is:

```text
employees
```

The table stores:

- `employeeId`
- `name`
- `email`
- `phone`
- `salary`
- `employeeType`
- `hourlyRate`
- `hoursWorked`

The `employeeId` field is an auto-incrementing primary key.

The included `ems.sql` file contains the database table definition and sample employee records.

## CRUD Operations

The system implements all four required CRUD operations:

| CRUD Operation | Application Function | SQL Operation |
|---|---|---|
| Create | Add Employee | `INSERT` |
| Read | View All Employees | `SELECT` |
| Update | Update Employee Salary | `UPDATE` |
| Delete | Delete Employee | `DELETE` |

The `EmployeeDAO` class uses `PreparedStatement` for these database operations.

## How to Set Up the Project

### Prerequisites

Before running the application, install:

1. Java JDK
2. Eclipse IDE
3. MySQL Server
4. MySQL Workbench (recommended)
5. MySQL Connector/J JDBC driver

### Step 1 — Clone or Download the Repository

Clone the repository using Git:

```bash
git clone https://github.com/zk247365/finalprojectems.git
```

Alternatively, download the repository as a ZIP file from GitHub and import the project into Eclipse.

### Step 2 — Create the Database

Open MySQL Workbench and run the included:

```text
ems.sql
```

This creates the `employees` table and inserts the sample records.

The Java application expects the database to be available at:

```text
localhost:3306/ems
```

### Step 3 — Configure Database Credentials

Open:

```text
EmployeeManagementSystem/src/DatabaseConnection.java
```

Update the MySQL username and password to match the MySQL account on your computer.

For example:

```java
private static final String URL = "jdbc:mysql://localhost:3306/ems";
private static final String USER = "root";
private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";
```

**Do not commit real database passwords or other credentials to a public GitHub repository.**

### Step 4 — Add MySQL Connector/J

Add the MySQL Connector/J `.jar` file to the Eclipse project's build path.

In Eclipse:

1. Right-click the project.
2. Select **Build Path**.
3. Select **Configure Build Path**.
4. Open **Libraries**.
5. Select **Classpath**.
6. Choose **Add External JARs**.
7. Select the MySQL Connector/J `.jar` file.
8. Apply the changes.

### Step 5 — Run the Application

Run:

```text
Main.java
```

The application displays the following command-line menu:

```text
=== Employee Management System ===
1. Add Employee
2. View All Employees
3. Update Employee Salary
4. Delete Employee
5. Exit
```

Choose an option and follow the prompts displayed in the terminal.

## Example Workflow

A typical workflow is:

1. Start the application.
2. Select **View All Employees** to view existing records.
3. Select **Add Employee** to create a new employee.
4. Enter the required employee information.
5. Select **View All Employees** again to confirm the new record.
6. Select **Update Employee Salary** and provide the employee ID and new salary.
7. View the records again to confirm the update.
8. Select **Delete Employee** and provide the employee ID.
9. View the records again to confirm the employee was removed.
10. Select **Exit** to close the application.

## Input Validation and Error Handling

The application validates employee information to help prevent invalid data.

Examples include:

- Employee ID must be greater than zero.
- Employee name cannot be empty.
- Employee email cannot be empty and must contain a valid basic email format.
- Employee phone number must follow the `XXX-XXX-XXXX` format.
- Salary cannot be negative.
- Part-time hourly rate cannot be negative.
- Part-time hours worked cannot be negative.
- Invalid employee information can trigger `InvalidEmployeeException`.
- Database errors are handled using SQL exception handling.

The final command-line version should reject invalid numeric input and provide an understandable error message instead of terminating unexpectedly.

## Testing

The project includes `EmployeeTest.java` for testing employee-related behavior.

Testing should cover:

- Valid employee creation
- Invalid employee ID
- Empty employee name
- Invalid email
- Invalid phone number
- Negative salary
- Part-time employee validation
- CRUD database operations
- Invalid command-line input

## Security Note

This project is intended as an academic application.

Database credentials should be configured locally rather than stored as publicly accessible credentials in source control. If credentials have previously been committed to a public repository, they should be changed before final submission.

## Project Requirements

The project was developed to demonstrate:

- Java programming
- Object-Oriented Programming
- Classes and objects
- Encapsulation
- Inheritance
- Abstract classes
- Interfaces
- Custom exceptions
- Input validation
- Command-line interaction
- JDBC database connectivity
- SQL CRUD operations
- Persistent data storage
- Testing and error handling

## Group Members

Add the names and student ID numbers of all group members here before final submission.

- **Group Member 1:** Satvi Purohit - 000992175
- **Group Member 2:** Gurleen Kaur - 000988460
- **Group Member 3:** Alzaki Elehaimir - 000900421