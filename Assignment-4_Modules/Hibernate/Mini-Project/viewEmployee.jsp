<%@ page import="com.wipro.model.Employee" %>
<%
  Employee e = (Employee) request.getAttribute("employee");
%>
ID: <%= e.getId() %><br>
Name: <%= e.getName() %><br>
City: <%= e.getCity() %><br>
Email: <%= e.getEmail() %><br>
