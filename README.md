# Employee Record System (Java + MySQL)

A robust, console-based Employee Record Management System developed in Java. This application demonstrates the implementation of Object-Oriented Programming (OOP) concepts, database integration using JDBC, and secure data handling practices. 

It is designed to be a fully functional backend template with interactive console menus, data validation, and exception handling.

## 🚀 Key Features

* **Full CRUD Operations:** Create, Read, Update, and Delete employee records seamlessly.
* **Database Integration:** Connected to a local MySQL database via JDBC.
* **Data Validation:** Implemented Regular Expressions (Regex) to validate email formats before database insertion.
* **Exception Handling:** Built-in `try-catch` blocks to prevent system crashes from invalid user inputs (e.g., entering strings instead of numbers).
* **Prepared Statements:** Uses SQL Prepared Statements to secure the application against SQL Injection attacks.
* **Clean Code:** Highly structured, modular codebase separating the Model (`Employee`), Database Logic (`EmployeeManager`), and User Interface (`Main`).

## 🛠️ Technologies Used

* **Language:** Java (JDK)
* **Database:** MySQL (via XAMPP)
* **Library:** MySQL Connector/J (JDBC Driver)
* **IDE:** IntelliJ IDEA

## ⚙️ Setup and Installation

Follow these steps to run the project on your local machine:

**1. Clone the repository:**
```bash
git clone https://github.com/pavidu-samararathna/EmployeeRecordSystem.git
```

**2. Setup the Database:**
* Start the MySQL server using XAMPP Control Panel.
* Open your MySQL interface (e.g., phpMyAdmin or Command Line) and run the following SQL script to set up the database and table:

```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    position VARCHAR(50) NOT NULL,
    salary DOUBLE NOT NULL
);
```

**3. Configure the Project:**
* Open the project in IntelliJ IDEA (or any Java IDE).
* Ensure that the `mysql-connector-j` `.jar` file is added to your project's External Libraries / Dependencies.

**4. Run the Application:**
* Execute the `Main.java` file.
* Follow the on-screen interactive console menu to manage employee records.

---
*Developed by Pavidu*
