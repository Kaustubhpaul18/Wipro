import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {
        // Employee data initialization using arrays
        int[] empNo = {1001, 1002, 1003, 1004, 1005, 1006, 1007};
        String[] empName = {"Ashish", "Sushma", "Rahul", "Chahat", "Ranjan", "Suman", "Tanmay"};
        String[] joinDate = {"01/04/2009", "23/08/2012", "12/11/2008", "29/01/2013", "16/07/2005", "1/1/2000", "12/06/2006"};
        char[] designationCode = {'e', 'c', 'k', 'r', 'm', 'e', 'c'}; // Corrected from image, Ranjan is 'm'
        String[] department = {"R&D", "PM", "Acct", "Front Desk", "Engg", "Manufacturing", "PM"};
        double[] basic = {20000, 30000, 10000, 12000, 50000, 23000, 29000};
        double[] hra = {8000, 12000, 8000, 6000, 20000, 9000, 12000};
        double[] it = {3000, 9000, 1000, 2000, 20000, 4400, 10000};

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        int searchEmpId = scanner.nextInt();

        boolean found = false;
        for (int i = 0; i < empNo.length; i++) {
            if (empNo[i] == searchEmpId) {
                found = true;

                // Calculate DA based on designation code using switch-case
                double da = 0;
                String designation = ""; // To store the full designation name
                switch (designationCode[i]) {
                    case 'e':
                        da = 20000;
                        designation = "Engineer";
                        break;
                    case 'c':
                        da = 32000;
                        designation = "Consultant";
                        break;
                    case 'k':
                        da = 12000;
                        designation = "Clerk";
                        break;
                    case 'r':
                        da = 15000;
                        designation = "Receptionist";
                        break;
                    case 'm':
                        da = 40000;
                        designation = "Manager";
                        break;
                    default:
                        // Handle unexpected designation code if necessary
                        break;
                }

                // Calculate Salary
                double salary = basic[i] + hra[i] + da - it[i];

                System.out.println("EmpNo\tEmpName\tDepartment\tDesignation\tSalary");
                System.out.printf("%d\t%s\t%s\t\t%s\t\t%.0f%n",
                                  empNo[i], empName[i], department[i], designation, salary);
                break; // Exit loop once employee is found
            }
        }

        if (!found) {
            System.out.println("There is no employee with empid : " + searchEmpId);
        }

        scanner.close();
    }
}