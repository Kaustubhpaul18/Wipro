import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

// Employee class to hold employee details
class Employee {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String address;

    // Constructor
    public Employee(String firstName, String lastName, String mobileNumber, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.address = address;
    }

    // Getters for all fields (needed for sorting and printing)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // Optional: toString method for easy printing (though specific format is requested)
    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %-30s %-15s",
                firstName, lastName, mobileNumber, email, address);
    }
}

public class EmployeeRegister {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Employee> employeeList = new LinkedList<>();

        System.out.print("Enter the Number of Employees: ");
        int numberOfEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("\nEnter Employee " + (i + 1) + " Details:");
            System.out.print("Enter the Firstname: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter the Lastname: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter the Mobile: ");
            String mobileNumber = scanner.nextLine();
            System.out.print("Enter the Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter the Address: ");
            String address = scanner.nextLine();

            employeeList.add(new Employee(firstName, lastName, mobileNumber, email, address));
        }

        // Sort the employee list by first name
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getFirstName().compareToIgnoreCase(emp2.getFirstName());
            }
        });

        System.out.println("\nEmployee List:");
        System.out.printf("%-15s %-15s %-15s %-30s %-15s%n", "FirstName", "SecondName", "MobileNumber", "Email", "Address");

        for (Employee employee : employeeList) {
            System.out.printf("%-15s %-15s %-15s %-30s %-15s%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getMobileNumber(),
                    employee.getEmail(),
                    employee.getAddress());
        }

        scanner.close();
    }
}