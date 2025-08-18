import java.sql.*;

class DAOClass {
    private Connection con;

    public DAOClass() {
        try {
            // Change DB URL, username, password as per your system
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String user = "root";
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
    }

    public void insert(int rollno, String name, String course, String dob, int fee) {
        try {
            String sql = "INSERT INTO student (rollno, name, course, dob, fee) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rollno);
            ps.setString(2, name);
            ps.setString(3, course);
            ps.setString(4, dob);
            ps.setInt(5, fee);
            int rows = ps.executeUpdate();
            System.out.println(rows + " record(s) inserted.");
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e);
        }
    }

    public void delete(int rollno) {
        try {
            String sql = "DELETE FROM student WHERE rollno=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rollno);
            int rows = ps.executeUpdate();
            System.out.println(rows + " record(s) deleted.");
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e);
        }
    }

    public void modify(int rollno, int newFee) {
        try {
            String sql = "UPDATE student SET fee=? WHERE rollno=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, newFee);
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
                    rs.getString("name") + " | " +
                    rs.getString("course") + " | " +
                    rs.getString("dob") + " | " +
                    rs.getInt("fee")
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
            case 1: // insert
                if (args.length != 6) {
                    System.out.println("Usage: 1 rollno name course dob fee");
                    return;
                }
                dao.insert(Integer.parseInt(args[1]), args[2], args[3], args[4], Integer.parseInt(args[5]));
                break;

            case 2: // delete
                if (args.length != 2) {
                    System.out.println("Usage: 2 rollno");
                    return;
                }
                dao.delete(Integer.parseInt(args[1]));
                break;

            case 3: // modify
                if (args.length != 3) {
                    System.out.println("Usage: 3 rollno newFee");
                    return;
                }
                dao.modify(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                break;

            case 4: // display
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
