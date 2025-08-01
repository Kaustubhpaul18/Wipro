import java.io.*;
import java.util.Date;

class Employee implements Serializable {
    String name;
    Date dateOfBirth;
    String department;
    String designation;
    double salary;

    // Constructor
    Employee(String name, Date dateOfBirth, String department, String designation, double salary) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }
}

public class SimpleEmployeeSerialization {
    public static void main(String[] args) {
        // Create an employee object
        Employee emp = new Employee("John", new Date(), "IT", "Engineer", 50000);

        // Save the object to file (serialization) using try-with-resources
        try (FileOutputStream fileOut = new FileOutputStream("data");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(emp);
            System.out.println("Object saved to file 'data'.");
        } catch (IOException ex) {
            System.err.println("Error during serialization: " + ex.getMessage());
            return;
        }

        // Read the object back (deserialization) using try-with-resources
        try (FileInputStream fileIn = new FileInputStream("data");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Employee e = (Employee) in.readObject();

            // Print employee details
            System.out.println("\nEmployee Details:");
            System.out.println("Name: " + e.name);
            System.out.println("DOB: " + e.dateOfBirth);
            System.out.println("Department: " + e.department);
            System.out.println("Designation: " + e.designation);
            System.out.println("Salary: " + e.salary);
        } catch (IOException ex) {
            System.err.println("Error during deserialization: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Employee class not found: " + ex.getMessage());
        }
    }
}
