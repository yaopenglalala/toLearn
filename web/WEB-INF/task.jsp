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

<div class="modal" tabindex="-1" role="dialog" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">添加作业</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="addTask" method="post" id="addTaskForm" class="card-body">
                    <div class="form-group">
                        <label>课程ID</label>
                        <input type="text" name="courseid" value="<%= course.getCourseId()%>" readonly="readonly" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>作业名称</label>
                        <input type="text" name="name" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>作业详情</label>
                        <input type="text" name="detail" class="form-group"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary" form="addTaskForm">确定</button>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <a href="detail?courseid=<%= course.getCourseId()%>"><h3><span class="badge badge-secondary"><%=course.getCourseName()%></span></h3></a>
    <%
        if (course.getUserId().equals(user.getUserId())) {
    %>
    <button href="search" class="btn btn-primary">添加作业</button>
    <%
        }
    %>
    <div class="row">
        <%
            if (tasks != null){
                for (Task task : tasks) {
         %>
        <div >

        </div>

        <%
                }
            }
        %>


    </div>
</div>

<h1><a href="detail?courseid=<%= course.getCourseId()%>"><%= course.getCourseName()%></a></h1>
<ul>
    <%
    if (tasks != null) {
        for (Task task : tasks) {
%>
    <li><a href="answer?taskid=<%= task.getTaskId()%>"><%= task.getTaskName()%></a></li>
    <%
            }
        }
    %></ul>
<br>
<% if (course.getUserId().equals(user.getUserId())) {
%>
<form action="addTask" method="post">
    <input type="text" name="courseid" value="<%= course.getCourseId()%>" hidden>
    Task name:<input type="text" name="name"/><br>
    Task detail:<input type="text" name="detail"/><br>
    <input type="submit" value="add task"/>
</form>
<% } %>

</body>
</html>
