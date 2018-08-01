<%@ page import="model.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/8/1
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-----------%>
<%
    //这个页面对应的课程列表
    List<Course> courses = (List<Course>) request.getAttribute("courses");

    Integer pageNumber = (Integer) request.getAttribute("numberOfPage");
%>
<%-----------%>
<%@ include file="top.jsp"%>
<html>
<head>
    <title>Search</title>
</head>
<body>
<%
    if (courses != null){
        for (Course course : courses){
            %>
<a href="/detail?courseid=<%= course.getCourseId()%>"><%= course.getCourseName()%></a><br>
<%
        }
    } %>
<ul>
<%
    if (pageNumber != 0){
        for (int i = 1 ; i < pageNumber + 1; i++){
            String originUrl = "/search?" + request.getQueryString();
            String newUrl = originUrl.substring(0, originUrl.lastIndexOf("=") + 1) + i;
            %>
    <li><a href="<%= newUrl%>"><%= i%></a></li>
<%
        }
    }
%>
</ul>
</body>
</html>
