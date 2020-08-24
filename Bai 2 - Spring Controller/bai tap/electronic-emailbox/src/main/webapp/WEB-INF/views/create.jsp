<%--
  Created by IntelliJ IDEA.
  User: Dino Hiếu
  Date: 8/21/2020
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "v" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new mail box</title>
</head>
<style>
    *{
        float: left;
        margin-bottom: 5px;
        text-align: left;
    }

</style>
<body>


<c:form method="post" action="/create" modelAttribute="mailbox">
    <label>ID</label>
    <c:input path="id"></c:input>
    <br>
    <label>Languages</label>
    <c:select path="idLanguage">
        <v:forEach items="${languages}" var="language">
            <c:option value="${language.id}">${language.name}</c:option>
        </v:forEach>
    </c:select>
    <br>
    <br>
    <c:label path="pageSize">Page Size :</c:label>
    <c:input path="pageSize"></c:input>
    <br><br>
    <c:label path="spamFilter">Spam Filter</c:label>
    <c:input path="spamFilter"></c:input>
    <br><br>
    <c:label path="signature">Signature</c:label>
    <c:input path="signature"></c:input>
    <br><br>
    <input type="submit" value="Add">
</c:form>
</body>
</html>
