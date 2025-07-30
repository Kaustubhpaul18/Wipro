import java.util.*;

// Employee class
class Employee {
    int empId;
    String empName;
    String email;
    String gender;
    float salary;

    // Constructor
    Employee(int empId, String empName, String email, String gender, float salary) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
    }

    // Print employee details
    void GetEmployeeDetails() {
        System.out.println("ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Salary: " + salary);
    }
}

// EmployeeDB class
class EmployeeDB {
    ArrayList<Employee> list = new ArrayList<>();

    boolean addEmployee(Employee e) {
        return list.add(e);
    }

    boolean deleteEmployee(int empId) {
        for (Employee e : list) {
            if (e.empId == empId) {
                list.remove(e);
                return true;
            }
        }
        return false;
    }

    String showPaySlip(int empId) {
        for (Employee e : list) {
            if (e.empId == empId) {
                return "Pay slip for " + e.empName + " is ₹" + e.salary;
            }
        }
        return "Employee not found!";
    }
}

// Main class
public class EmployeeManagementInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDB db = new EmployeeDB();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Show Payslip");
            System.out.println("4. Show All Employees");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    float salary = sc.nextFloat();

                    Employee e = new Employee(id, name, email, gender, salary);
                    db.addEmployee(e);
                    System.out.println("Employee added!");
                }
                case 2 -> {
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    if (db.deleteEmployee(deleteId)) {
                        System.out.println("Employee deleted.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID for payslip: ");
                    int payslipId = sc.nextInt();
                    System.out.println(db.showPaySlip(payslipId));
                }
                case 4 -> {
                    System.out.println("All Employees:");
                    for (Employee emp : db.list) {
                        emp.GetEmployeeDetails();
                        System.out.println("------------------");
                    }
                }
                case 5 -> {
                    System.out.println("Exiting... Bye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
