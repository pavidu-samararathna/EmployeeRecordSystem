import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("=== Employee Record System ===");

        while (isRunning) {
            try {
                System.out.println("\n1. Add Employee | 2. View All | 3. Update Employee | 4. Delete Employee | 5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();

                        String email = "";
                        while (true) {
                            System.out.print("Enter Email: ");
                            email = scanner.nextLine();

                            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                                break;
                            }
                            System.out.println("Error: Invalid email format. Expected format: user@domain.com");
                        }

                        System.out.print("Enter Position: ");
                        String position = scanner.nextLine();

                        double salary = 0;
                        while (true) {
                            try {
                                System.out.print("Enter Salary: ");
                                salary = scanner.nextDouble();
                                scanner.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Invalid salary amount. Please enter numerical values only.");
                                scanner.nextLine();
                            }
                        }

                        Employee newEmp = new Employee(name, email, position, salary);
                        EmployeeManager.addEmployee(newEmp);
                        break;

                    case 2:
                        EmployeeManager.getAllEmployees();
                        break;

                    case 3:
                        System.out.print("Enter ID of employee to update: ");
                        int updId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter New Position: ");
                        String updPosition = scanner.nextLine();

                        double updSalary = 0;
                        while (true) {
                            try {
                                System.out.print("Enter New Salary: ");
                                updSalary = scanner.nextDouble();
                                scanner.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Invalid salary amount. Please enter numerical values only.");
                                scanner.nextLine();
                            }
                        }

                        EmployeeManager.updateEmployee(updId, updPosition, updSalary);
                        break;

                    case 4:
                        System.out.print("Enter ID of employee to delete: ");
                        int delId = scanner.nextInt();
                        EmployeeManager.deleteEmployee(delId);
                        break;

                    case 5:
                        isRunning = false;
                        System.out.println("System Closed.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input detected. Please enter a valid numerical ID or Menu Choice.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
}