import java.util.*;

class Employee implements Comparable<Employee> {
    private final int id;
    private final String name;
    private final double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}

public class storing {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "Alice", 50000));
        employees.add(new Employee(1, "Bob", 60000));
        employees.add(new Employee(2, "Charlie", 55000));

        // Sorting the list
        Collections.sort(employees);

        // Listing elements using Iterator
        System.out.println("Using Iterator:");
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Listing elements using for-each loop (since Enumeration is obsolete with ArrayList)
        System.out.println("\nUsing for-each loop:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}