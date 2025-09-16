<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
<h2>Register</h2>
<form:form method="post" modelAttribute="user">
    Username: <form:input path="username"/> <form:errors path="username"/><br/>
    Password: <form:password path="password"/> <form:errors path="password"/><br/>
    Employee ID: <form:input path="employeeNumber"/> <form:errors path="employeeNumber"/><br/>
    Email: <form:input path="email"/> <form:errors path="email"/><br/>
    <input type="submit" value="Register"/>
</form:form>
<c:if test="${not empty error}">
   <p style="color:red">${error}</p>
</c:if>
</body>
</html>
