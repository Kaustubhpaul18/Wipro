import java.util.ArrayList;
import java.util.function.Function;

class Employee {
    private final String location;

    public Employee(int id, String name, String location, double salary) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}

public class Given {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "Bangalore", 50000));
        employees.add(new Employee(2, "Bob", "Chennai", 55000));
        employees.add(new Employee(3, "Charlie", "Delhi", 60000));
        employees.add(new Employee(4, "David", "Mumbai", 65000));
        employees.add(new Employee(5, "Eve", "Pune", 70000));

        Function<Employee, String> getLocation = Employee::getLocation;

        ArrayList<String> locations = new ArrayList<>();
        for (Employee emp : employees) {
            locations.add(getLocation.apply(emp));
        }

        System.out.println("Employee Locations: " + locations);
    }
}