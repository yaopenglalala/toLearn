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

    //这个页面对应的章节
    Chapter chapter = (Chapter) request.getAttribute("chapter");

    //这个页面对应的知识点
    Point point = (Point) request.getAttribute("point");

    //用户
    User user = (User) request.getAttribute("user");

    //章节列表
    List<Chapter> chapters = (List<Chapter>) request.getAttribute("chapters");

    //章节对应的知识点，以<Integer, List<Point>>存储，即章节id对应知识点列表
    Map<Integer, List<Point>> points = (Map<Integer, List<Point>>) request.getAttribute("points");

    //知识点对应的视频文件名列表
    List<String> videos = (List<String>) request.getAttribute("videos");

    //判断是否是老师
    Boolean isTeacher = course.getUserId().equals(user.getUserId());
%>
<%-----------%>
<%@ include file="top.jsp"%>
<html>
<head>
    <title>To Learn</title>
</head>
<body>

</body>
</html>
