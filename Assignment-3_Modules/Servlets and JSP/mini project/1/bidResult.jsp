<%@ page import="Bid" %>
<%
    Bid bid = (Bid) request.getAttribute("bid");
%>
<html>
<head>
    <title>Bid Submitted</title>
</head>
<body style="background-color:yellow; text-align:center;">
    <h1>Bid Submitted</h1>
    <p>Your bid is now active. If your bid is successful, you will be notified within 24 hours of the close of bidding.</p>

    <table border="1" align="center" cellpadding="10" style="background-color:yellow;">
        <tr style="background:black; color:white;">
            <th colspan="2"><%= bid.getItemName() %></th>
        </tr>
        <tr><td>Item ID:</td><td><%= bid.getItemId() %></td></tr>
        <tr><td>Name:</td><td><%= bid.getBidderName() %></td></tr>
        <tr><td>Email address:</td><td><%= bid.getEmail() %></td></tr>
        <tr><td>Bid price:</td><td>Rs.<%= bid.getAmount() %></td></tr>
        <tr><td>Auto-increment price:</td><td><%= bid.isAutoIncrement() %></td></tr>
    </table>
</body>
</html>
