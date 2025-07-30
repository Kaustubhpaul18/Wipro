import java.util.HashSet;
import java.util.Iterator;

public class EmployeeSet {
    public static void main(String[] args) {
        HashSet<String> employees = new HashSet<>();

        employees.add("Alice");
        employees.add("Bob");
        employees.add("Charlie");
        employees.add("David");

        Iterator<String> iterator = employees.iterator();
        System.out.println("Employee names:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
