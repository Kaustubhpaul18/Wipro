import java.sql.*;
import java.util.*;

public class StudentApp {

    // Update with your DB credentials
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "system";
    private static final String PASS = "admin";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage:");
            System.out.println("java StudentApp insert");
            System.out.println("java StudentApp delete <rollno>");
            System.out.println("java StudentApp update <rollno> <newFee>");
            System.out.println("java StudentApp display");
            System.out.println("java StudentApp display <rollno>");
            return;
        }

        String operation = args[0].toLowerCase();

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            switch (operation) {
                case "insert":
                    insertStudent(con);
                    break;
                case "delete":
                    if (args.length != 2) {
                        System.out.println("Usage: java StudentApp delete <rollno>");
                        return;
                    }
                    deleteStudent(con, Integer.parseInt(args[1]));
                    break;
                case "update":
                    if (args.length != 3) {
                        System.out.println("Usage: java StudentApp update <rollno> <newFee>");
                        return;
                    }
                    updateFee(con, Integer.parseInt(args[1]), Double.parseDouble(args[2]));
                    break;
                case "display":
                    if (args.length == 1) {
                        displayAll(con);
                    } else if (args.length == 2) {
                        displayOne(con, Integer.parseInt(args[1]));
                    }
                    break;
                default:
                    System.out.println("Invalid operation");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll No (4-digit): ");
        int rollno = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Student Name (uppercase, max 20): ");
        String name = sc.nextLine();
        System.out.print("Enter Standard (I to X): ");
        String standard = sc.nextLine();
        System.out.print("Enter DOB (YYYY-MM-DD): ");
        String dob = sc.nextLine();
        System.out.print("Enter Fees: ");
        double fees = sc.nextDouble();

        String sql = "INSERT INTO Student (Rollno, StudentName, Standard, Date_Of_Birth, Fees) VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, rollno);
            pst.setString(2, name);
            pst.setString(3, standard);
            pst.setString(4, dob);
            pst.setDouble(5, fees);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Student inserted successfully.");
            }
        }
    }

    private static void deleteStudent(Connection con, int rollno) throws SQLException {
        String sql = "DELETE FROM Student WHERE Rollno = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, rollno);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Rollno not found.");
            }
        }
    }

    private static void updateFee(Connection con, int rollno, double fee) throws SQLException {
        String sql = "UPDATE Student SET Fees = ? WHERE Rollno = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, fee);
            pst.setInt(2, rollno);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Fee updated successfully.");
            } else {
                System.out.println("Rollno not found.");
            }
        }
    }

    private static void displayAll(Connection con) throws SQLException {
        String sql = "SELECT * FROM Student";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                printStudent(rs);
            }
        }
    }

    private static void displayOne(Connection con, int rollno) throws SQLException {
        String sql = "SELECT * FROM Student WHERE Rollno = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, rollno);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    printStudent(rs);
                } else {
                    System.out.println("Rollno not found.");
                }
            }
        }
    }

    private static void printStudent(ResultSet rs) throws SQLException {
        System.out.println(
            rs.getInt("Rollno") + " | " +
            rs.getString("StudentName") + " | " +
            rs.getString("Standard") + " | " +
            rs.getDate("Date_Of_Birth") + " | " +
            rs.getDouble("Fees")
        );
    }
}
