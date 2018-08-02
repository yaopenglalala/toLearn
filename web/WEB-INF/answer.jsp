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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">

        </div>
        <div class="col-lg-2"></div>
    </div>
</div>


<%
    if (isTeacher){
%>
<form action="modifyTask" method="post" id="taskForm" class="card-body">
    <input type="text" name="taskid" value="<%= task.getTaskId()%>" hidden/>
    <div class="form-group">
        <label>作业标题</label>
        <input type="text" class="form-control" name="name">
    </div>
    <div class="form-group">
        <label>作业详情</label>
        <textarea class="form-control" name="detail"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">确定</button>
</form>
<%
    } else {
%>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#"><%=course.getCourseName()%></a></li>
        <li class="breadcrumb-item"><a href="#"><%=task.getTaskName()%></a></li>
    </ol>
</nav>
<div class="card text-center">
    <div class="card-body">
        <h5 class="card-title"><%=task.getTaskName()%></h5>
        <p class="card-text"><%=task.getTaskDetail()%></p>
        <%
            if (answer == null){
        %>
        <form action="addAnswer" method="post" id="addForm" class="card-body">
            <input type="text" name="taskid" value="<%= task.getTaskId()%>" hidden/>
            <textarea name="answer" form="addForm" class="form-control"></textarea>
            <button type="submit" class="btn btn-primary">提交</button>
        </form>
        <%
            }else {
        %>
        <form action="modifyAnswer" method="post" id="modifyForm" class="card-body">
            <input type="text" name="taskid" value="<%= task.getTaskId()%>" hidden/>
            <textarea name="answer" form="addForm" class="form-control"><%=answer.getAnswerContent()%></textarea>
            <button type="submit" class="btn btn-primary">提交</button>
        </form>
        <%
            }
        %>
    </div>
</div>
<%
    }
%>



<h1><a href="detail?courseid=<%= course.getCourseId()%>"><%= course.getCourseName()%></a></h1>
<h1><%=task.getTaskName()%></h1>
<p><%= task.getTaskDetail()%></p>


<% if (isTeacher){ %>
<form action="modifyTask" method="post" id="taskForm">
    <input type="text" name="taskid" value="<%= task.getTaskId()%>" hidden/>
    Task name : <input type="text" name="name" value="<%= task.getTaskName()%>"/>
    Task detail : <textarea name="detail" form="taskForm"><%= task.getTaskDetail()%></textarea>
    <input type="submit" value="Edit this task"/>
</form>

<% } else { %>
<br>
<p>Your answer:</p>
    <% if (answer == null){ %>
<form action="addAnswer" method="post" id="addForm">
    <input type="text" name="taskid" value="<%= task.getTaskId()%>" hidden/>
    <textarea name="answer" form="addForm"></textarea>
    <input type="submit" value="submit">
</form>
<% } else {%>
<form action="modifyAnswer" method="post" id="editForm">
    <input type="text" name="taskid" value="<%= task.getTaskId()%>" hidden />
    <textarea name="answer" form="editForm"><%= answer.getAnswerContent()%> </textarea>
    <input type="submit" value="Edit">
</form>
<% }
}%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script></body>
</html>