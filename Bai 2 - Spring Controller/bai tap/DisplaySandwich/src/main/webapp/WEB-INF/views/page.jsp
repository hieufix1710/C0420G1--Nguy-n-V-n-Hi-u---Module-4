<%--
  Created by IntelliJ IDEA.
  User: Dino Hiếu
  Date: 8/21/2020
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save" >
    <input type="checkbox" id="lettuce" name="condiment" value="lettuce" >
    <label for="lettuce"> Lettuce</label><br>
    <input type="checkbox" id="tomato" name="condiment" value="tomato" >
    <label for="tomato">Tomato</label><br>
    <input type="checkbox" id="mustard" name="condiment" value="mustard" >
    <label for="mustard">Mustard</label><br><br>
    <input type="submit" value="Submit">
</form>
<p>${condiment}</p>
</body>
</html>
