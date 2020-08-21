<%--
  Created by IntelliJ IDEA.
  User: Dino Hiếu
  Date: 8/20/2020
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<form method="post" action="/dictionary">
    <label>English: </label>
    <input type="text" name="Eng" placeholder="English" ><br>
    <p>Vietnamese : ${result}</p>
    <input type="submit" id="submit" value="Search">
</form>
</body>
</html>
