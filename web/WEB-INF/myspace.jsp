<%@ page import="model.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/26
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<%-----------%>
<%
    List<Course> courses = (List<Course>) request.getAttribute("courses");

    Boolean isSelected = (Boolean) request.getAttribute("isSelected");
%>
<%-----------%>
<% String type = request.getParameter("type");%>
<html>
<head>
    <title>To Learn</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

<!-- 模态框 -->
<div class="modal" tabindex="-1" role="dialog" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">课程详情</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="addCourse" method="post" action="addCourse" enctype="multipart/form-data" class="card-body">
                    <div class="form-group">
                        <label for="nameAdd">课程名称</label><br>
                        <input type="text" id="nameAdd" name="course_name" class="form-control"><br>
                    </div>
                    <div class="form-group">
                        <label for="intrdAdd">课程描述</label><br>
                        <input type="text" id="intrdAdd" name="introduction" class="form-control"><br>
                    </div>
                    <div class="form-group">
                         <label for="picAdd">课程封面</label><br>
                        <img id="photo" src="" class="form-control" style="display: block; width: 100px;height: 100px;"><br>
                        <input type="file" name="picAdd" id="picAdd" onchange="preview(this.id,'photo');" class="form-control" accept="image/jpeg image/png image/jpg image/gif">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary" form="addCourse">添加</button>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <ul class="nav nav-tabs" style="margin-top: 10px;">
        <li class="nav-item">
            <a class="nav-link <% if (type.equals("select")) { out.print(" active"); }%>" href="myspace?type=select">我选的课</a>
        </li>
        <li class="nav-item">
            <a class="nav-link <% if (type.equals("open")) { out.print(" active"); }%>" href="myspace?type=open">我开的课</a>
        </li>
    </ul>
    <div style="margin-top: 10px;">
        <% if (type.equals("select")){%>
        <a href="search" class="btn btn-primary">选课</a>
    </div>
    <div class="row">
        <%}else{%>
        <div class="container">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"> 添加课程 </button>
        </div>
        <div class="row">
        <%}%>
        <% for (Course course:courses) {%>
        <div class="col-3" style="margin-top: 10px;">
            <div class="card">
                <div class="card-body">
                    <img style="width: 100%; height: 150px;" src="<%=course.getCourseImage()%>">
                    <h5 style="margin-top: 10px;" class="card-title"><%=course.getCourseName()%></h5>
                    <p class="card-text"><%=course.getIntroduction()%></p>
                    <a href="detail?courseid=<%=course.getCourseId()%>" class="btn btn-primary">查看</a>
                </div>
            </div>
        </div>
        <%}%>
    </div>

    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="../js/preview.js"></script>
</html>
