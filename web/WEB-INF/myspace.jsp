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
        <a href="search" class="btn btn-primary">添加课程</a>
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
