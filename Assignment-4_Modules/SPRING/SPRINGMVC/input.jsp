<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Enter Marks</title>
</head>
<body>
    <h2>Enter Your Marks</h2>
    <form action="calculate" method="post">
        Science: <input type="text" name="science" /><br><br>
        Maths: <input type="text" name="maths" /><br><br>
        English: <input type="text" name="english" /><br><br>
        <input type="submit" value="Calculate Total" />
    </form>
</body>
</html>
