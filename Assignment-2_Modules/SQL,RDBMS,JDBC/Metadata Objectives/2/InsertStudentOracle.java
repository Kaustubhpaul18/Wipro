import java.sql.*;

public class InsertStudentOracle {

    public static boolean isValidRollno(int rollno) {
        return String.valueOf(rollno).matches("\\d{4}");
    }

    public static boolean isValidName(String name) {
        // Allows 1–20 uppercase letters with optional spaces between words
        return name.matches("[A-Z ]{1,20}");
    }

    public static boolean isValidStandard(String standard) {
        return standard.matches("I|II|III|IV|V|VI|VII|VIII|IX|X");
    }

    public static boolean isValidDOB(String dob) {
        // Checks if date is in YYYY-MM-DD format
        return dob.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("Usage: rollno studentName standard dateOfBirth(YYYY-MM-DD) fees");
            return;
        }

        int rollno = Integer.parseInt(args[0]);
        String studentName = args[1];
        String standard = args[2];
        String dob = args[3];
        double fees = Double.parseDouble(args[4]);

        // Validations
        if (!isValidRollno(rollno)) {
            System.out.println("Invalid Rollno! Must be a 4-digit number.");
            return;
        }
        if (!isValidName(studentName)) {
            System.out.println("Invalid Student Name! Must be up to 20 uppercase letters (spaces allowed).");
            return;
        }
        if (!isValidStandard(standard)) {
            System.out.println("Invalid Standard! Must be Roman numeral from I to X.");
            return;
        }
        if (!isValidDOB(dob)) {
            System.out.println("Invalid Date of Birth! Must be in YYYY-MM-DD format.");
            return;
        }

        Connection con = null;
        PreparedStatement ps = null;
        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle DB
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "your_username",
                    "your_password");

            String sql = "INSERT INTO student (rollno, studentname, standard, date_of_birth, fees) "
                       + "VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, rollno);
            ps.setString(2, studentName);
            ps.setString(3, standard);
            ps.setString(4, dob);
            ps.setDouble(5, fees);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record(s) inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace(); // Full stack trace for debugging
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
