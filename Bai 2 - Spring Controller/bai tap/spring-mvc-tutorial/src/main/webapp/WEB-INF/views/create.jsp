<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<c:form method="POST" action="addEmployee" modelAttribute="employee">
    <table>
        <tr>
            <td><c:label path="id">Employee ID: </c:label></td>
            <td><c:input path="id"/></td>
        </tr>
        <tr>
            <td><c:label path="name">Employee's name: </c:label></td>
            <td><c:input path="name"/></td>
        </tr>
        <tr>
            <td><c:label path="contactNumber">Contact's number: </c:label></td>
            <td><c:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</c:form>
</body>
</html>