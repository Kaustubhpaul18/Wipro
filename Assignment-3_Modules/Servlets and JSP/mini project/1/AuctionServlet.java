import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/AuctionServlet")
public class AuctionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String itemId = request.getParameter("itemId");
        String itemName = request.getParameter("itemName");
        String bidderName = request.getParameter("bidderName");
        String email = request.getParameter("email");
        String amountStr = request.getParameter("amount");
        String autoInc = request.getParameter("autoIncrement");

        boolean error = false;
        StringBuilder errorMsg = new StringBuilder();

        if (itemId == null || itemId.trim().isEmpty()) {
            error = true;
            errorMsg.append("Required field! Item ID<br>");
        }
        if (itemName == null || itemName.trim().isEmpty()) {
            error = true;
            errorMsg.append("Required field! Item Name<br>");
        }
        if (bidderName == null || bidderName.trim().isEmpty()) {
            error = true;
            errorMsg.append("Required field! Your Name<br>");
        }
        if (email == null || email.trim().isEmpty()) {
            error = true;
            errorMsg.append("Required field! Your Email Address<br>");
        }
        if (amountStr == null || amountStr.trim().isEmpty()) {
            error = true;
            errorMsg.append("Required field! Amount Bid<br>");
        }

        if (error) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2 style='color:red;'>Required Data Missing! Enter and Resubmit.</h2>");
            out.println("<a href='auction.html'>Go Back</a><br><br>");
            out.println(errorMsg.toString());
            return;
        }

        // Populate JavaBean
        Bid bid = new Bid();
        bid.setItemId(itemId);
        bid.setItemName(itemName);
        bid.setBidderName(bidderName);
        bid.setEmail(email);
        bid.setAmount(Double.parseDouble(amountStr));
        bid.setAutoIncrement(autoInc != null);

        // Pass JavaBean to JSP
        request.setAttribute("bid", bid);
        RequestDispatcher rd = request.getRequestDispatcher("bidResult.jsp");
        rd.forward(request, response);
    }
}
