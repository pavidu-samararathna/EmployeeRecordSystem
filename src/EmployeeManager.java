import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeManager {

    public static void addEmployee(Employee employee) {
        String query = "INSERT INTO employees (name, email, position, salary) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setDouble(4, employee.getSalary());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Success: New employee added.");
            }

        } catch (SQLException e) {
            System.err.println("Database Error: Failed to add employee.");
            System.err.println(e.getMessage());
        }
    }

    public static void getAllEmployees() {
        String query = "SELECT * FROM employees";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("\n--- Employee Records ---");

            while (resultSet.next()) {
                int id = resultSet.getInt("emp_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");

                System.out.printf("ID: %d | Name: %s | Email: %s | Position: %s | Salary: Rs.%.2f%n",
                        id, name, email, position, salary);
            }
            System.out.println("------------------------\n");

        } catch (SQLException e) {
            System.err.println("Database Error: Failed to retrieve employee records.");
            System.err.println(e.getMessage());
        }
    }

    public static void updateEmployee(int id, String newPosition, double newSalary) {
        String query = "UPDATE employees SET position = ?, salary = ? WHERE emp_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newPosition);
            preparedStatement.setDouble(2, newSalary);
            preparedStatement.setInt(3, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Success: Employee details updated.");
            } else {
                System.out.println("Warning: No employee found with the given ID.");
            }

        } catch (SQLException e) {
            System.err.println("Database Error: Failed to update employee details.");
            System.err.println(e.getMessage());
        }
    }

    public static void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE emp_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Success: Employee deleted.");
            } else {
                System.out.println("Warning: No employee found with the given ID.");
            }

        } catch (SQLException e) {
            System.err.println("Database Error: Failed to delete employee.");
            System.err.println(e.getMessage());
        }
    }
}