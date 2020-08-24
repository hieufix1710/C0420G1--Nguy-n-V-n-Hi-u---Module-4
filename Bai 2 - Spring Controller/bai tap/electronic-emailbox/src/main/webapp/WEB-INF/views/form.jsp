<%--
  Created by IntelliJ IDEA.
  User: Dino Hiếu
  Date: 8/21/2020
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<form method="post" action="/create">
    <table>
        <tr>
            <th>ID</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${mailboxs}" var="mailbox">
            <tr>
                <td>${mailbox.id}</td>
                <td><a href="/showInfo&id=${mailbox.id}">Show</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/create">Create new mail box</a>
</form>
</body>
</html>
