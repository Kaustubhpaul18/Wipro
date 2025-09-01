import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        UserDAO dao = new UserDAO();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (dao.validateUser(username, password)) {
                out.println("<h2>Welcome " + username + "!</h2>");
            } else {
                out.println("<h2>Invalid Username or Password. <a href='login.html'>Try Again</a></h2>");
            }

        } else if ("register".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");

            if (!password.equals(confirmPassword)) {
                out.println("<h2>Passwords do not match! <a href='register.html'>Try Again</a></h2>");
            } else if (dao.userExists(username)) {
                out.println("<h2>User already exists! <a href='register.html'>Try Again</a></h2>");
            } else {
                dao.registerUser(username, password);
                out.println("<h2>User Registered Successfully. <a href='login.html'>Login</a></h2>");
            }

        } else if ("changePassword".equals(action)) {
            String username = request.getParameter("username");
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");

            if (!newPassword.equals(confirmPassword)) {
                out.println("<h2>New Passwords do not match! <a href='changePassword.html'>Try Again</a></h2>");
            } else if (dao.changePassword(username, oldPassword, newPassword)) {
                out.println("<h2>Password Changed Successfully. <a href='login.html'>Login</a></h2>");
            } else {
                out.println("<h2>Invalid Username or Old Password. <a href='changePassword.html'>Try Again</a></h2>");
            }
        }
    }
}
