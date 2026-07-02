public class Employee {

    private String name;
    private String email;
    private String position;
    private double salary;

    public Employee(String name, String email, String position, double salary) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
}