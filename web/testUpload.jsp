<%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/28
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="addCourse" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="text" name="course_name"/>
    <input type="text" name="introduction"/>
    <input type="submit"/>
    <input name="name" value="2" type="hidden"/>
</form>
</body>
</html>
