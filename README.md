# Employee Payroll App

A console-based Java application designed to manage employee payroll operations. This project demonstrates how core Object-Oriented Programming (OOP) principles can solve real-world business problems while maintaining code quality, scalability, and maintainability.

---

# Project Overview

The Employee Payroll App allows organizations to register employees, authenticate users, generate payslips, manage role-based dashboards, validate input, and safely print or download payroll records.

The application is built using core Java concepts such as:

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Composition
- Aggregation
- File I/O
- Exception Handling
- Collections
- Factory Pattern
- RegEx Validation
- Object Cloning

---

# Features

- Register new employees with validated details
- Store employee data using File I/O
- Authenticate users securely
- Role-based access for managers and employees
- Time-based session management
- Generate monthly payslips
- Calculate salary components, deductions, and net pay
- Print and download payslips safely
- Display role-specific dashboards
- Sort and process payslip records
- Validate user input using RegEx
- Handle errors using custom exceptions

---

# Tech Stack

| Technology | Purpose |
|---|---|
| Java | Core application development |
| OOP | Application design |
| File I/O | Data persistence |
| Collections Framework | Data processing |
| RegEx | Input validation |
| Custom Exceptions | Error handling |
| Console UI | User interaction |

---


# Use Cases

## Use Case 1: Employee Registration

### Objective

Register a new employee with validated personal information and create the foundational entities of the application.

### Key Concepts Used

- Encapsulation
- Composition
- File I/O

### Description

The `Employee` class keeps employee data private using encapsulation. Login details are separated into a distinct `UserAccount` object, demonstrating composition.

### Example

```java
public class Employee {
    private String empId;
    private String role;
    private String name;
    private String email;
    private String phone;
    private UserAccount account;

    public Employee(String empId, String role, String name, String email, String phone, UserAccount account) {
        this.empId = empId;
        this.role = role;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }
}
```

### File Persistence

Employee data is stored in a text file using File I/O so that records remain available after the program exits.

---

## Use Case 2: Secure Authentication and Role-Based Access

### Objective

Authenticate users securely and provide access based on user role.

### Key Concepts Used

- Inheritance
- Polymorphism
- Abstraction
- Session Management

### Description

An abstract `User` class defines common authentication behavior. Specific user roles such as `Manager` and `RegularEmployee` extend the base class and override authentication logic.

### Example

```java
public abstract class User {
    protected String username;
    protected String passwordHash;
    protected String role;

    public abstract boolean authenticate(String username, String password);
}
```

### Session Management

The system maintains a time-based session for logged-in users. If the session expires, access is restricted until the user logs in again.

---

## Use Case 3: Monthly Payslip Generation

### Objective

Generate detailed monthly payslips by separating calculation logic from data representation.

### Key Concepts Used

- Service Layer
- Aggregation
- Composition
- Business Logic Separation

### Description

The `PayrollService` class centralizes salary calculation logic such as allowances, deductions, and net pay calculation.

### Example

```java
public class PayrollService {
    public Payslip generatePayslip(Employee employee, String month, double basic, double hra, double da, double allowances) {
        SalaryComponents salaryComponents = new SalaryComponents(basic, hra, da, allowances);

        // Deduction and net pay calculation logic

        return new Payslip(employee, salaryComponents, month);
    }
}
```

### Relationships

| Relationship | Example |
|---|---|
| Aggregation | Payslip HAS-A Employee |
| Composition | Payslip owns SalaryComponents |

---

## Use Case 4: Print and Download Payslips Safely

### Objective

Print and download payslips while protecting existing data from accidental modification.

### Key Concepts Used

- Immutability
- `final` class
- `Cloneable`
- Deep Copy
- `equals()`
- `hashCode()`

### Description

The `Payslip` class is declared as `final` to prevent inheritance. It implements `Cloneable` so independent copies of payslips can be created safely.

### Example

```java
public final class Payslip implements Cloneable {
    @Override
    public Object clone() {
        SalaryComponents clonedComponents =
            new SalaryComponents(
                components.basicSalary,
                components.hra,
                components.da,
                components.allowances
            );

        return new Payslip(this.employee, clonedComponents, this.month);
    }
}
```

### Object Equality

The `equals()` and `hashCode()` methods are overridden to compare payslip values instead of memory references.

---

## Use Case 5: Role-Based Dashboards

### Objective

Display different dashboards based on user roles using dynamic object creation.

### Key Concepts Used

- Factory Pattern
- Interface
- Runtime Polymorphism
- Collections
- Comparator

### Description

A common `Dashboard` interface is implemented by different dashboard types. The `DashboardFactory` creates the correct dashboard object based on user role.

### Example

```java
public class DashboardFactory {
    public static Dashboard getDashboard(String role) {
        return switch (role.toUpperCase()) {
            case "EMPLOYEE" -> new EmployeeDashboard();
            case "MANAGER" -> new ManagerDashboard();
            default -> null;
        };
    }
}
```

### Data Processing

Collections and Comparators are used to sort and display top payslip entries efficiently.

---

## Use Case 6: Input Validation and Error Handling

### Objective

Validate user input before it enters the system to prevent crashes and data corruption.

### Key Concepts Used

- Custom Exception Hierarchy
- Checked Exceptions
- RegEx
- Graceful Error Handling

### Description

The system uses custom validation exceptions to handle different input failures such as invalid email, phone number, employee ID, and password.

### Example

```java
@SuppressWarnings("serial")
public class EmailValidationException extends ValidationException {
    public EmailValidationException(String message) {
        super(message);
    }
}
```

### Validation Types

| Input | Validation |
|---|---|
| Email | RegEx pattern matching |
| Phone | Numeric and length validation |
| Employee ID | Required format validation |
| Password | Strength validation |
| Salary | Positive numeric validation |
| Role | Valid role checking |

---

# Core OOP Concepts Demonstrated

| OOP Concept | Implementation |
|---|---|
| Encapsulation | Private fields in Employee and UserAccount |
| Composition | Employee owns UserAccount |
| Inheritance | Manager and RegularEmployee extend User |
| Polymorphism | Role-specific authentication |
| Abstraction | Abstract User class and Dashboard interface |
| Aggregation | Payslip has Employee |
| Immutability | final Payslip class |
| Cloneable | Safe payslip copying |

---

# Application Flow

```text
1. Start Application
2. Register Employee
3. Validate Employee Details
4. Store Employee Data
5. Login User
6. Authenticate Credentials
7. Create Session
8. Load Role-Based Dashboard
9. Generate Payslip
10. Print or Download Payslip
11. Logout / Session Expiry
```

---

# Sample Console Menu

```text
========== Employee Payroll App ==========

1. Register Employee
2. Login
3. Generate Payslip
4. View Dashboard
5. Print Payslip
6. Download Payslip
7. Exit

Enter your choice:
```

---

# Sample Employee Registration

```text
Enter Employee ID: EMP101
Enter Name: John Smith
Enter Email: john@example.com
Enter Phone: 9876543210
Enter Role: EMPLOYEE
Create Username: john101
Create Password: ********

Employee registered successfully.
```

---

# Sample Payslip Output

```text
========== Monthly Payslip ==========

Employee ID: EMP101
Name: John Smith
Month: January

Basic Salary: 30000
HRA: 10000
DA: 5000
Allowances: 3000

Gross Salary: 48000
Deductions: 5000
Net Pay: 43000
```

---

# File Storage

The application stores data in text files.

| File | Purpose |
|---|---|
| employees.txt | Stores employee records |
| payslips.txt | Stores generated payslips |

---

# How to Run

## Compile

```bash
javac EmployeePayrollApp.java
```

## Run

```bash
java EmployeePayrollApp
```

---

# Key Java Concepts Practiced

- Classes and Objects
- Constructors
- Access Modifiers
- Getter and Setter Methods
- Abstract Classes
- Interfaces
- Method Overriding
- Method Overloading
- File Handling
- Exception Handling
- Collections
- Comparator
- Factory Pattern
- RegEx
- Object Cloning

---

# Future Enhancements

- Database integration using MySQL
- GUI using JavaFX or Swing
- Spring Boot REST API version
- Role-based authentication with JWT
- PDF payslip generation
- Email payslip to employee
- Admin dashboard
- Payroll analytics
- Unit testing using JUnit
