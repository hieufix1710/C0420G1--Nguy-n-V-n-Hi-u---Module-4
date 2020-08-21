<%--
  Created by IntelliJ IDEA.
  User: Dino Hiếu
  Date: 8/19/2020
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Money</title>
</head>
<body>
<form method="post" action="/Converter">
    <label>Rate: </label>
    <input type="text" name="rate" placeholder="Rate" value="22000"><br>
    <label>USD: </label>
    <input type="text" name="usd" placeholder="USD" value="0"><br>
    <p>Result : ${result}</p>
    <input type="submit" id="submit" value="Converter">
</form>
</body>
</html>
