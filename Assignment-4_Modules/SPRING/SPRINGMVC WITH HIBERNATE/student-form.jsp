<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head><title>Student Form</title></head>
<body>
<h2>Enter Student Details</h2>
<form:form action="saveStudent" modelAttribute="student">
    Name: <form:input path="name"/><br/>
    Email: <form:input path="email"/><br/>
    Course: <form:input path="course"/><br/>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
