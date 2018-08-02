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
<%@include file="top.jsp"%>
<%
    //课程
    Course course = (Course) request.getAttribute("course");

    //作业
    Task task = (Task) request.getAttribute("task");

    //答案
    Answer answer = (Answer) request.getAttribute("answer");

    //是否是老师
    Boolean isTeacher = course.getUserId().equals(user.getUserId());
%>
<%-----------%>
<html>
<head>
    <title>Answer</title>
</head>
<body>
<h1><a href="/detail?courseid=<%= course.getCourseId()%>"><%= course.getCourseName()%></a></h1>
<h1><%=task.getTaskName()%></h1>
<p><%= task.getTaskDetail()%></p>
<% if (isTeacher){ %>
<form action="/modifyTask" method="post" id="taskForm">
    <input type="text" name="taskid" value="<%= task.getTaskId()%>" hidden/>
    Task name : <input type="text" name="name" value="<%= task.getTaskName()%>"/>
    Task detail : <textarea name="detail" form="taskForm"><%= task.getTaskDetail()%></textarea>
    <input type="submit" value="Edit this task"/>
</form>
<% } else { %>
<br>
<p>Your answer:</p>
    <% if (answer == null){ %>
<form action="/addAnswer" method="post" id="addForm">
    <input type="text" name="taskid" value="<%= task.getTaskId()%>" hidden/>
    <textarea name="answer" form="addForm"></textarea>
    <input type="submit" value="submit">
</form>
<% } else {%>
<form action="/modifyAnswer" method="post" id="editForm">
    <input type="text" name="taskid" value="<%= task.getTaskId()%>" hidden />
    <textarea name="answer" form="editForm"><%= answer.getAnswerContent()%> </textarea>
    <input type="submit" value="Edit">
</form>
<% }
}%>

</body>
</html>