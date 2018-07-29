<%@ page import="java.util.List" %>
<%@ page import="model.Course" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/26
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<%-----------%>
<%
    //最热课程列表
    List<Course> hotCourses = (List<Course>) request.getAttribute("hotCourses");

    //最新课程列表
    List<Course> newCourses = (List<Course>)  request.getAttribute("newCourses");
%>
<%-----------%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    for (Course course : newCourses){
        out.print("so hot " + course.getCourseName());
        out.print("<img src=\""+course.getCourseImage() +"\" />");
    }
%>
</body>
</html>
