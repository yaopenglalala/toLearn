<%@ page import="model.Course" %><%--
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
    //选课列表
    Course[] hotCourses = (Course[]) request.getAttribute("hotCourses");

    //开课列表
    Course[] newCourses = (Course[]) request.getAttribute("newCourses");
%>
<%-----------%>
<%@ include file="top.jsp"%>
<% String state = request.getParameter("state");%>
<html>
<head>
    <title>To Learn</title>
    <script src="../js/preview.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <ul class="nav nav-tabs" style="margin-top: 10px;">
        <li class="nav-item">
            <a class="nav-link <% if (state.equals("1")) { out.print(" active"); }%>" href="myspace?state=1" onclick="$STAGE=2">我选的课</a>
        </li>
        <li class="nav-item">
            <a class="nav-link <% if (state.equals("2")) { out.print(" active"); }%>" href="myspace?state=2">我开的课</a>
        </li>
    </ul>
    <div style="margin-top: 10px;">
        <% if (state=="1"){%>
        <a href="search" class="btn btn-primary">选课</a>
    </div>
    <div class="row">
        <% for (Course course:hotCourses) {%>
        <div class="col-3" style="margin-top: 10px;">
            <div class="card">
                <div class="card-body">
                    <img style="width: 100%; height: 150px;" src="<%=course.getCourseImage()%>">
                    <h5 style="margin-top: 10px;" class="card-title"><%=course.getCourseName()%></h5>
                    <p class="card-text"><%=course.getIntroduction()%></p>
                    <a href="detail?courseId=<%=course.getCourseId()%>" class="btn btn-primary">查看</a>
                </div>
            </div>
        </div>
        <%}%>
        <%}else{%>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"> 添加课程 </button>
        <!-- 模态框 -->
        <div class="modal fade" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- 模态框头部 -->
                    <div class="modal-header">
                        <h4 class="modal-title">课程详情</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- 模态框主体 -->
                    <div class="modal-body">
                        <%--模态框内容..--%>
                        <form id="addCourse" method="post" action="addCourse" enctype="multipart/form-data">
                            <label for="nameAdd">课程名称</label>
                            <input type="text" id="nameAdd" name="course_name">
                            <label for="intrdAdd">课程描述</label>
                            <input type="text" id="intrdAdd" name="introduction">
                            <label for="picAdd">课程封面</label>
                            <img id="photo" src="" class="form-control" style="display: block; width: 50px;height: 50px;">
                            <input type="file" name="picAdd" id="picAdd" onchange="preview(this.id,'photo');" class="form-control" accept="image/jpeg image/png image/jpg image/gif">
                       </form>
                    </div>
                    <!-- 模态框底部 -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                        <button form="addCourse" type="submit" class="btn btn-primary">创建</button>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <% for (Course course:newCourses) {%>
        <div class="col-3" style="margin-top: 10px;">
            <div class="card">
                <div class="card-body">
                    <img style="width: 100%; height: 150px;" src="<%=course.getCourseImage()%>">
                    <h5 style="margin-top: 10px;" class="card-title"><%=course.getCourseName()%></h5>
                    <p class="card-text"><%=course.getIntroduction()%></p>
                    <a href="detail?courseId=<%=course.getCourseId()%>" class="btn btn-primary">查看</a>
                </div>
            </div>
        </div>
        <%}%>
        <%}%>
    </div>
</div>
</body>
</html>
