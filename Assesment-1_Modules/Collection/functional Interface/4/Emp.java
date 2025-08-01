import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class Emp {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", 9500));
        employees.add(new Employee(2, "Bob", 12000));
        employees.add(new Employee(3, "Charlie", 8500));
        employees.add(new Employee(4, "David", 15000));
        employees.add(new Employee(5, "Eve", 7000));
        employees.add(new Employee(6, "Frank", 11000));
        employees.add(new Employee(7, "Grace", 9900));

        Predicate<Employee> lowSalary = emp -> emp.getSalary() < 10000;

        System.out.println("Employees with salary less than 10000:");
        for (Employee emp : employees) {
            if (lowSalary.test(emp)) {
                System.out.println(emp.getName());
            }
        }
    }
}