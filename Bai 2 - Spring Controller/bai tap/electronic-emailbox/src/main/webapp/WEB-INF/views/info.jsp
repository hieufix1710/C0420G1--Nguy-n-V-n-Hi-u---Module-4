<%--
  Created by IntelliJ IDEA.
  User: Dino Hiếu
  Date: 8/21/2020
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Information</title>
</head>
<body>
<form>
    <label>ID</label>
    <label>${mailbox.id}</label>
    <br>
    <label>Languages</label>
    <c:forEach var="language" items="${languages}">
        <c:if test="${mailbox.idLanguage==language.id}">
            <c:out value="${language.name}"></c:out>
        </c:if>
    </c:forEach>
    <br>
    <label>Page size</label>
    <label>${mailbox.pageSize}</label>
    <br>
    <label>Spam Filter</label>
    <label>${mailbox.spamFilter}</label>
    <br>
    <label>Signature</label>
    <label>${mailbox.signature}</label>
    
</form>
</body>
</html>
