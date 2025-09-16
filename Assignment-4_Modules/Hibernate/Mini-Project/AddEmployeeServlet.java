@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Employee e = new Employee();
        e.setName(req.getParameter("name"));
        e.setGender(req.getParameter("gender"));
        e.setDesignation(req.getParameter("designation"));
        e.setSalary(Double.parseDouble(req.getParameter("salary")));
        e.setCity(req.getParameter("city"));
        e.setEmail(req.getParameter("email"));
        e.setMobile(req.getParameter("mobile"));

        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployee(e);

        req.setAttribute("message", "Employee Added Successfully!");
        req.getRequestDispatcher("success.jsp").forward(req, res);
    }
}
