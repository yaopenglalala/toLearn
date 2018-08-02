<%@ page import="java.util.List" %>
<%@ page import="model.Course" %><%--

  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/31
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Course course = (Course) request.getAttribute("course");

    //资料路径列表
    List<String> sources = (List<String>) request.getAttribute("sources");
%>
<%-----------%>
<%@include file="top.jsp" %>
<html>
<head>
    <title>Source</title>
</head>
<body>
<h1><a href="/detail?courseid=<%= course.getCourseId()%>"><%= course.getCourseName()%></a></h1>
<br>
<%
    if (sources != null) {
        for (String source : sources) {
            String name = source.substring(source.lastIndexOf("/") + 1);
%>
<a href="<%= source%>" download="<%= name%>"><%= name%></a>
<%
    if (course.getUserId().equals(user.getUserId())) {
%>
<form action="/remove" method="post">
    <input type="text" name="src" value="<%= source%>" hidden>
    <input type="submit" value="remove"/>
</form>
<br>
<br>
<%
            }
        }
    } %>

<%  if (course.getUserId().equals(user.getUserId())) { %>
<form action="/addSource" enctype="multipart/form-data" method="post">
    <input type="text" name="courseid" value="<%= course.getCourseId()%>" hidden/>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
</form>
    <% } %>
</body>
</html>
