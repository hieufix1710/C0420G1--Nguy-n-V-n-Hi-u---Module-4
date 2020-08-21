<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<%--
  Created by IntelliJ IDEA.
  User: Dino Hiếu
  Date: 8/20/2020
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td><a href="/customers/delete&${customer.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
