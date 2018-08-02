<%@ page import="model.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/8/1
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-----------%>
<%
    //这个页面对应的课程列表
    List<Course> courses = (List<Course>) request.getAttribute("courses");

    Integer pageNumber = (Integer) request.getAttribute("numberOfPage");
%>
<%-----------%>
<%@ include file="top.jsp"%>
<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row" style="margin-top:10px">
        <%
            if (courses != null){
                for (Course course : courses){
        %>
        <div class="col-lg-4" style="margin-top: 10px;">
            <div class="card">
                <div class="card-body">
                    <img style="width: 100%; height: 250px;" src="<%=course.getCourseImage()%>">
                    <h5 style="margin-top: 10px; text-align: center;" class="card-title"><%=course.getCourseName()%></h5>
                    <p class="card-text" style="text-align: center;"><%=course.getIntroduction()%></p>
                    <a href="detail?courseid=<%=course.getCourseId()%>" class="btn btn-primary" style="margin-left: 35%;">查看详情</a>
                </div>
            </div>
        </div>
        <%     }
            }  %>
    </div>
</div>

<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Previous</a>
        </li>
        <%
            if (pageNumber != 0){
                for (int i = 1 ; i < pageNumber + 1; i++){
                    String originUrl = "/search?" + request.getQueryString();
                    String newUrl = originUrl.substring(0, originUrl.lastIndexOf("=") + 1) + i;
        %>
        <li class="page-item"><a class="page-link" href="<%= newUrl%>"><%= i%></a></li>
        <%      }
        }%>
        <li class="page-item">
            <a class="page-link" href="#">Next</a>
        </li>
    </ul>
</nav>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script></body>
</body>
</html>
