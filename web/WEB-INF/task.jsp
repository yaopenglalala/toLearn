<%@ page import="java.util.List" %>
<%@ page import="model.Task" %>
<%@ page import="model.Course" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/26
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-----------%>
<%
    //课程
    Course course = (Course) request.getAttribute("course");

    //该课程的所有作业
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
%>
<%-----------%>
<%@ include file="top.jsp" %>
<html>
<head>
    <title>To Learn</title>
</head>
<body>

<div class="container">
    <h3><span class="badge badge-secondary"><%=course.getCourseName()%></span></h3>


    <div class="row">

    </div>
</div>



<h1><a href="/detail?courseid=<%= course.getCourseId()%>"><%= course.getCourseName()%></a></h1>
<ul><%
    if (tasks != null) {
        for (Task task : tasks) {
%>
    <li><a href="/answer?taskid=<%= task.getTaskId()%>"><%= task.getTaskName()%></a></li>
    <%
            }
        }
    %></ul>
<br>
<% if (course.getUserId().equals(user.getUserId())) {
%>
<form action="/addTask" method="post">
    <input type="text" name="courseid" value="<%= course.getCourseId()%>" hidden>
    Task name:<input type="text" name="name"/><br>
    Task detail:<input type="text" name="detail"/><br>
    <input type="submit" value="add task"/>
</form>
<% } %>

</body>
</html>
