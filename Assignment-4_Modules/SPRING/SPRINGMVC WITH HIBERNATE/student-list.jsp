<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><title>Student List</title></head>
<body>
<h2>All Students</h2>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th></tr>
    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
            <td>${s.course}</td>
        </tr>
    </c:forEach>
</table>
<a href="studentForm">Add New Student</a>
</body>
</html>
