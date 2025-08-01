import java.util.ArrayList;

public class EmployeeFilter {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", 25, "Pune"));
        employees.add(new Employee(102, "Bob", 30, "Mumbai"));
        employees.add(new Employee(103, "Charlie", 28, "Pune"));
        employees.add(new Employee(104, "David", 32, "Delhi"));
        employees.add(new Employee(105, "Eve", 29, "Pune"));

        ArrayList<Employee> puneEmployees = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp.location.equalsIgnoreCase("Pune")) {
                puneEmployees.add(emp);
            }
        }

        System.out.println("Employees in Pune:");
        for (Employee emp : puneEmployees) {
            emp.printDetails();
        }
    }
}
