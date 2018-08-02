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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<%--Modal--%>
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
                <form action="addTask" method="post" class="card-body" id="addTaskForm">
                    <input type="text" name="courseid" value="<%= course.getCourseId()%>" class="form-control" hidden>
                    <div class="form-group">
                        <label>作业标题</label>
                        <input type="text" name="name" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>作业详情</label>
                        <input type="text" name="detail" class="form-control"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" form="addTaskForm">确认</button>
            </div>
        </div>
    </div>
</div>
<%--modaEend--%>

<%--页面内容--%>
<div class="container">
    <a href="detail?courseid=<%= course.getCourseId()%>"><h3><span class="badge badge-secondary"><%=course.getCourseName()%></span></h3></a>
    <%
        if (user.getUserId().equals(course.getUserId())){
    %>
    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">布置作业</button>
    <hr style="filter: alpha(opacity=100,finishOpacity=0,style=1)" width="80%" color="#987cb9" size="3">
    <div class="row">
        <%
            }
            if (tasks != null) {
                for (Task task : tasks) {
        %>
        <div class="card border-success col-lg-3" style="max-width: 18rem;">
            <div class="card-header bg-transparent border-success"><%=task.getTaskName()%></div>
            <div class="card-body text-success">
                <p class="card-text"><%=task.getTaskDetail()%></p>
            </div>
            <div class="card-footer bg-transparent border-success">
                <%
                    if (user.getUserId().equals(course.getUserId())){
                %>
                <a class="btn btn-primary" href="answer?taskid=<%=task.getTaskId()%>">批改</a>
                <%
                }else{
                %>
                <a  class="btn btn-primary" href="answer?taskid=<%=task.getTaskId()%>">作答</a>
            </div>
        </div>
        <%
                    }
                }
            }
        %>
    </div>
</div>



<%--<h1><a href="detail?courseid=<%= course.getCourseId()%>"><%= course.getCourseName()%></a></h1>--%>
<%--<ul><%--%>
    <%--if (tasks != null) {--%>
        <%--for (Task task : tasks) {--%>
<%--%>--%>
    <%--<li><a href="answer?taskid=<%= task.getTaskId()%>"><%= task.getTaskName()%></a></li>--%>
    <%--<%--%>
            <%--}--%>
        <%--}--%>
    <%--%></ul>--%>
<%--<br>--%>
<%--<% if (course.getUserId().equals(user.getUserId())) {--%>
<%--%>--%>
<%--<form action="/addTask" method="post">--%>
    <%--<input type="text" name="courseid" value="<%= course.getCourseId()%>" hidden>--%>
    <%--Task name:<input type="text" name="name"/><br>--%>
    <%--Task detail:<input type="text" name="detail"/><br>--%>
    <%--<input type="submit" value="add task"/>--%>
<%--</form>--%>
<%--<% } %>--%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script></body>
</body>
</html>
