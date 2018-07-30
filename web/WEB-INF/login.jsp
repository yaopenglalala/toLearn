<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To Learn</title>
    <link rel="stylesheet" href="../css/sign.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>
</head>
<body>
<main class="login-img row">
    <div class="col-md-4 offset-md-6 card ">
        <div class="card-header">登陆</div>
        <form class="card-body" id="form-login" method="post" action="login.jsp" onsubmit="return incheck();">
            <div class="form-group">
                <label for="user-name">用户名：</label>
                <input class="form-control" type="text" name="username" id="user-name" placeholder="请输入用户名" onblur="checkname1()">
                <div class="tips"> </div>
            </div>
            <div class="form-group">
                <label for="user-psw">密码：</label>
                <input type="password" class="form-control" id="user-psw" name="password" placeholder="请输入密码" onblur="checkpsw()">
                <div class="tips"> </div>
            </div>
            <div class="card-footer">
                <button type="submit" class="btn btn-primary float-right" id="bt-login">登陆</button>
            </div>
        </form>
    </div>
</main>
<script src="../js/sign.js"></script>
</body>
</html>
