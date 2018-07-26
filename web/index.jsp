<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/22
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/top.jsp"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="test" method="post">
      <input type="submit" value="test">
  </form>
  <img src=${url} />
  <%
    response.sendRedirect("/home");
  %>
  $END$
  </body>
</html>
