<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/26
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-----------%>
<%
    //这个javabean代表用户的登录信息，若为null，则未登录。
    User user = (User) session.getAttribute("user");
%>
<%-----------%>

<html>
<head>
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
<div class="header_bottom navbar navbar-expand-lg">
    <div class="container">
        <div class="row">
        </div>
        <div class="logo col-lg-5">
            <a href="home.jsp"><img src="../res/icon/logo.png" alt=""/></a>
        </div>
        <div class="col-lg-6 justify-content-end">
            <form action="search" class="form-inline my-2 my-lg-0" style="margin-right: 20px;">
                <input name="coursename" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
        <div class="col-lg-1">
            <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                <%
                    if (user == null){
                        out.print("<button type=\"button\" class=\"btn btn-primary\" style=\"margin-right: 5px;\" data-toggle=\"modal\" data-target=\"#registerModal\" onclick=\"window.location.href=\'register\'\">注册</button>\n");
                        out.print("<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#loginModal\" onclick=\"window.location.href=\'login\'\">登录</button>\n");
                    }else {
                        out.print("<p>Hello,<a href='myspace?state=1'>"+user.getUserName()+"</a>,Welcome to <em>To Learn<em>!<a href=logout>   登出  </a></p>");
                    }
                %>
            </div>
        </div>
    </div>
</div>
</body>
</html>
