<%@ page import="java.util.List" %>
<%@ page import="model.Task" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/26
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-----------%>
<%
    //该课程的所有作业
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
%>
<%-----------%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (tasks == null || tasks.isEmpty()){
        out.print("null");
    } else {
        for (Task task :tasks){
            out.print(task.getTaskName());
        }
    }

%>
</body>
</html>