<%@ page import="java.util.List" %>
<%@ page import="model.Course" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/26
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-----------%>
<%
    //最热课程列表
    List<Course> hotCourses = (List<Course>) request.getAttribute("hotCourses");

    //最新课程列表
    List<Course> newCourses = (List<Course>)  request.getAttribute("newCourses");
%>
<%-----------%>
<%@ include file="top.jsp"%>
<html>
<head>
    <title>To Learn</title>
    <link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="../css/style.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:100,300,400,600,700,800' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators" style="margin-left: 20%">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
    <%
        int size = hotCourses.size();
        for (int i = 0; i < size ; i++){

            if (i == 0){
                out.print("<div class=\"carousel-item active\"</div>");
            }else {
                out.print("<div class=\"carousel-item\"</div>");
            }%>
            <img class="d-block w-100" src="<%=hotCourses.get(i).getCourseImage()%>">
            <div class="carousel-caption d-none d-md-block">
                <h5 style="color: black"><%=hotCourses.get(i).getCourseName()%></h5>
                <p style="color: black"><%=hotCourses.get(i).getIntroduction()%></p>
            </div>
        </div>
    <%}%>
     </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="work">
    <div class="container bgred">
        <div class="work_top text-center">
            <h3>Our Courses</h3>
            <p>We display our latest courses below</p>
            <span> </span>
        </div>

        <% for (int i = 0; i < newCourses.size(); i++) { %>
        <div class="col_1_of_4 span_1_of_4">
            <div class="port-grid">
                <div class="port-grid-text">
                    <img src="../res/icon/arrow_icon.png" alt=""/>
                    <h3><%=newCourses.get(i).getCourseName()%></h3>
                    <p><%=newCourses.get(i).getIntroduction()%></p>
                </div>
                <div class="port-grid-pic block last">
                    <a href="#">
                        <img style="width: 295px;height: 274px" src="<%=newCourses.get(i).getCourseImage()%>" class="img-responsive">
                        <div class="b-wrapper"></div>
                    </a>
                </div>
            </div>
        </div>
        <% } %>




    </div>
</div>
</body>
</html>
