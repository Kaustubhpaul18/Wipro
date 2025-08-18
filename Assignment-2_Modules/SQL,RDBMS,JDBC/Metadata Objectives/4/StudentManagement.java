import java.sql.*;
import java.util.Scanner;

class DAOClass {
    private Connection con;

    public DAOClass() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "password"
        );
    }

    public void insertStudent(int rollno, String name, String std, String dob, double fees) throws Exception {
        String sql = "INSERT INTO student VALUES (?, ?, ?, TO_DATE(?, 'DD-MON-YYYY'), ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rollno);
            ps.setString(2, name);
            ps.setString(3, std);
            ps.setString(4, dob);
            ps.setDouble(5, fees);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Record Inserted" : "Insert Failed");
        }
    }

    public void deleteStudent(int rollno) throws Exception {
        String sql = "DELETE FROM student WHERE rollno = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rollno);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Record Deleted" : "Roll No not found");
        }
    }

    public void modifyFee(int rollno, double newFee) throws Exception {
        String sql = "UPDATE student SET fees = ? WHERE rollno = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, newFee);
            ps.setInt(2, rollno);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Fee Updated" : "Roll No not found");
        }
    }

    public void displayStudents() throws Exception {
        String sql = "SELECT rollno, studentname, standard, TO_CHAR(date_of_birth,'DD-MON-YYYY'), fees FROM student";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
                                   rs.getString(3) + " " + rs.getString(4) + " " + rs.getDouble(5));
            }
        }
    }

    public void close() throws Exception {
        if (con != null) con.close();
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            DAOClass dao = new DAOClass();
            while (true) {
                System.out.println("\n1. Insert\n2. Delete\n3. Modify Fee\n4. Display\n5. Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter Roll No: ");
                        int r1 = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String n = sc.nextLine();
                        System.out.print("Enter Standard: ");
                        String s = sc.nextLine();
                        System.out.print("Enter DOB (DD-MON-YYYY): ");
                        String d = sc.nextLine();
                        System.out.print("Enter Fees: ");
                        double f = sc.nextDouble();
                        dao.insertStudent(r1, n, s, d, f);
                        break;
                    case 2:
                        System.out.print("Enter Roll No to delete: ");
                        int r2 = sc.nextInt();
                        dao.deleteStudent(r2);
                        break;
                    case 3:
                        System.out.print("Enter Roll No to modify fee: ");
                        int r3 = sc.nextInt();
                        System.out.print("Enter new fee: ");
                        double nf = sc.nextDouble();
                        dao.modifyFee(r3, nf);
                        break;
                    case 4:
                        dao.displayStudents();
                        break;
                    case 5:
                        dao.close();
                        System.out.println("Program exited.");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
