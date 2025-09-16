<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Total Marks</title>
</head>
<body>
    <h2>Marks Summary</h2>
    <p>Science: ${science}</p>
    <p>Maths: ${maths}</p>
    <p>English: ${english}</p>
    <h3>Total Marks: ${total}</h3>
    <a href="<c:url value='/' />">Go Back</a>
</body>
</html>
