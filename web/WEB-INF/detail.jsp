<%@ page import="model.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Chapter" %>
<%@ page import="java.util.Map" %>
<%@ page import="model.Point" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/26
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-----------%>
<%
    //这个页面对应的课程
    Course course = (Course) request.getAttribute("course");

    //章节列表
    List<Chapter> chapters = (List<Chapter>) request.getAttribute("chapters");

    //章节对应的知识点，以<Integer, List<Point>>存储，即章节id对应知识点列表
    Map<Integer, List<Point>> points = (Map<Integer, List<Point>>) request.getAttribute("points");
%>
<%-----------%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
