<%@ page import="model.Course" %>
<%@ page import="java.util.List" %>
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
    //为true表示课程页面为我选的课
    //为false表示课程页面为我开的课
    Boolean selected = (boolean) request.getAttribute("isSelected");

    //课程列表
    List<Course> courses = (List<Course>) request.getAttribute("courses");
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
