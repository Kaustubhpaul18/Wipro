import java.sql.*;
import java.time.LocalDate;

class DAOClass {
    private Connection con;

    public DAOClass() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "your_username",
                    "your_password");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
    }

    public boolean isValidRollno(int rollno) {
        return String.valueOf(rollno).matches("\\d{4}");
    }

    public boolean isValidName(String name) {
        return name.matches("[A-Z ]{1,20}");
    }

    public boolean isValidStandard(String standard) {
        return standard.matches("I|II|III|IV|V|VI|VII|VIII|IX|X");
    }

    public boolean isValidDOB(String dob) {
        return dob.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public void insert(int rollno, String name, String standard, String dob, double fees) {
        if (!isValidRollno(rollno) || !isValidName(name) || !isValidStandard(standard) || !isValidDOB(dob)) {
            System.out.println("Validation failed. Record not inserted.");
            return;
        }
        try {
            String sql = "INSERT INTO student (rollno, studentname, standard, date_of_birth, fees) "
                    + "VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rollno);
            ps.setString(2, name);
            ps.setString(3, standard);
            ps.setString(4, dob);
            ps.setDouble(5, fees);
            int rows = ps.executeUpdate();
            System.out.println(rows + " record(s) inserted.");
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e);
        }
    }

    public void delete(int rollno) {
        try {
            String selectSQL = "SELECT rollno, studentname, standard FROM student WHERE rollno=?";
            PreparedStatement psSelect = con.prepareStatement(selectSQL);
            psSelect.setInt(1, rollno);
            ResultSet rs = psSelect.executeQuery();
            if (!rs.next()) {
                System.out.println("No student found with roll number " + rollno);
                return;
            }
            String name = rs.getString("studentname");
            String standard = rs.getString("standard");
            String insertLogSQL = "INSERT INTO studentlog (rollno, studentname, standard, leaving_date) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsertLog = con.prepareStatement(insertLogSQL);
            psInsertLog.setInt(1, rollno);
            psInsertLog.setString(2, name);
            psInsertLog.setString(3, standard);
            psInsertLog.setDate(4, Date.valueOf(LocalDate.now()));
            psInsertLog.executeUpdate();
            String deleteSQL = "DELETE FROM student WHERE rollno=?";
            PreparedStatement psDelete = con.prepareStatement(deleteSQL);
            psDelete.setInt(1, rollno);
            int rows = psDelete.executeUpdate();
            System.out.println(rows + " record(s) deleted and logged.");
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e);
        }
    }

    public void modify(int rollno, double newFee) {
        try {
            String sql = "UPDATE student SET fees=? WHERE rollno=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, newFee);
            ps.setInt(2, rollno);
            int rows = ps.executeUpdate();
            System.out.println(rows + " record(s) updated.");
        } catch (SQLException e) {
            System.out.println("Update failed: " + e);
        }
    }

    public void display(Integer rollno) {
        try {
            String sql;
            PreparedStatement ps;
            if (rollno != null) {
                sql = "SELECT * FROM student WHERE rollno=?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, rollno);
            } else {
                sql = "SELECT * FROM student";
                ps = con.prepareStatement(sql);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                        rs.getInt("rollno") + " | " +
                        rs.getString("studentname") + " | " +
                        rs.getString("standard") + " | " +
                        rs.getDate("date_of_birth") + " | " +
                        rs.getDouble("fees")
                );
            }
        } catch (SQLException e) {
            System.out.println("Display failed: " + e);
        }
    }
}

public class JDBCCalls {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Invalid arguments.");
            return;
        }
        DAOClass dao = new DAOClass();
        int option = Integer.parseInt(args[0]);
        switch (option) {
            case 1:
                if (args.length != 6) {
                    System.out.println("Usage: 1 rollno name standard dob(YYYY-MM-DD) fee");
                    return;
                }
                dao.insert(
                        Integer.parseInt(args[1]),
                        args[2],
                        args[3],
                        args[4],
                        Double.parseDouble(args[5])
                );
                break;
            case 2:
                if (args.length != 2) {
                    System.out.println("Usage: 2 rollno");
                    return;
                }
                dao.delete(Integer.parseInt(args[1]));
                break;
            case 3:
                if (args.length != 3) {
                    System.out.println("Usage: 3 rollno newFee");
                    return;
                }
                dao.modify(Integer.parseInt(args[1]), Double.parseDouble(args[2]));
                break;
            case 4:
                if (args.length == 2) {
                    dao.display(Integer.parseInt(args[1]));
                } else {
                    dao.display(null);
                }
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}