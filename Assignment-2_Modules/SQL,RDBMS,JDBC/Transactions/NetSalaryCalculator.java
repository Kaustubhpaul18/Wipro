import java.sql.*;

public class NetSalaryCalculator {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Change DB URL
        String user = "your_username"; // DB username
        String password = "your_password"; // DB password

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Step 1: Fetch all empnos from emp table
            String fetchEmpNos = "SELECT empno FROM emp";
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(fetchEmpNos)) {

                while (rs.next()) {
                    int empno = rs.getInt("empno");

                    // Step 2: Call stored procedure
                    try (CallableStatement cstmt = con.prepareCall("{call get_net_salary(?,?,?)}")) {
                        cstmt.setInt(1, empno);              // Input: empno
                        cstmt.registerOutParameter(2, Types.VARCHAR); // Output: ename
                        cstmt.registerOutParameter(3, Types.DOUBLE);  // Output: net salary

                        cstmt.execute();

                        // Step 3: Get results
                        String ename = cstmt.getString(2);
                        double netSalary = cstmt.getDouble(3);

                        // Step 4: Display result
                        System.out.printf("EmpNo: %d | Name: %s | Net Salary: %.2f%n",
                                empno, ename, netSalary);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
