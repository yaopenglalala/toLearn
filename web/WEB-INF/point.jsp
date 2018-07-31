<%@ page import="model.Course" %>
<%@ page import="model.Chapter" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Point" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/26
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-----------%>
<%
    //这个页面对应的课程
    Course course = (Course) request.getAttribute("course");

    //章节列表
    List<Chapter> chapters = (List<Chapter>) request.getAttribute("chapters");

    //章节对应的知识点，以<Integer, List<Point>>存储，即章节id对应知识点列表
    Map<Integer, List<Point>> points = (Map<Integer, List<Point>>) request.getAttribute("points");

    //知识点对应的视频文件名列表
    List<String> videos = (List<String>) request.getAttribute("videos");
%>
<%-----------%>
<%@ include file="top.jsp"%>
<% String pointId = request.getParameter("pointId");%>
<html>
<head>
    <title>To Learn</title>
</head>
<body>
<div class="container" style="padding: 10px;">

    <div class="row" style="margin-top: 10px;">
        <div class="col-4">
            <%for(Chapter chapter:chapters){%>
            <div class="list-group" style="margin-top: 10px;">
                <a href="#" class="list-group-item list-group-item-action active"><%=chapter.getChapterName()%></a>
                <% for(Point point:points.get(chapter.getChapterId())){%>
                <a href="point?pointId=<%=point.getPointId()%>" class="list-group-item list-group-item-action"><%=point.getPointName()%></a>
                <%}%>
            </div>
            <%}%>
        </div>
        <div class="col-8">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <%Point point = points.%>
                    <li class="breadcrumb-item"><a href="#">计算机网络</a></li>
                    <li class="breadcrumb-item"><a href="#">路由器</a></li>
                </ol>
            </nav>
            <video style="width: 100%; margin-top: 20px;" src="res/video/1531677955147.mp4" controls="controls">
                您的浏览器不支持 video 标签。
            </video>
        </div>

    </div>

</div>

</body>
</html>
