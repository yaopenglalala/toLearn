<%@ page import="model.Course" %>
<%@ page import="model.Task" %>
<%@ page import="model.Answer" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/31
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-----------%>
<%
    //课程
    Course course = (Course) request.getAttribute("course");

    //作业
    Task task = (Task) request.getAttribute("task");

    //答案
    Answer answer = (Answer) request.getAttribute("answer");

    //是否是老师
    User user = (User) session.getAttribute("user");
    Boolean isTeacher = course.getUserId().equals(user.getUserId());
%>
<%-----------%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
