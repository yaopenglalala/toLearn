<%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/24
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/top.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register" method="post">
    <input type="text" name="username"/>
    <input type="text" name="password"/>
    <input type="submit" value="register"/>
</form><br>
<form action="login" method="post">
    <input type="text" name="username"/>
    <input type="text" name="password"/>
    <input type="submit" value="login"/>
</form>
</body>
</html>
