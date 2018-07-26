<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/26
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-----------%>
<%
    //这个javabean代表用户的登录信息，若为null，则未登录。
    User user = (User) session.getAttribute("user");
%>
<%-----------%>

<html>
<head>
    <title>Title</title>
</head>
<body>
</body>
</html>
