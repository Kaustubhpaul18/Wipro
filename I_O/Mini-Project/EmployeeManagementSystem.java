import java.io.*;
import java.util.Scanner;

public class EmployeeManagementSystem {

    private static final String FILENAME = "employees.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMainMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Add an Employee");
        System.out.println("2. Display All");
        System.out.println("3. Exit");
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Age: ");
        String age = scanner.nextLine(); // Reading as String to match sample output format consistency
        System.out.print("Enter Employee Salary: ");
        String salary = scanner.nextLine(); // Reading as String

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            writer.write(id + "," + name + "," + age + "," + salary);
            writer.newLine();
            System.out.println("Employee added successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void displayAllEmployees() {
        System.out.println("\n---Report----");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Assuming the order is ID, Name, Age, Salary as per addEmployee
                if (parts.length == 4) {
                    System.out.printf("%s %s %s %s%n", parts[0], parts[1], parts[2], parts[3]);
                } else {
                    System.out.println("Malformed data in file: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No employees found. File 'employees.txt' does not exist yet.");
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        System.out.println("---End of Report----");
    }
}