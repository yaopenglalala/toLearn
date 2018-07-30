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
<html>
<head>
    <title>To Learn</title>
</head>
<body>

</body>
</html>
