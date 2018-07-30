<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To Learn</title>
    <link rel="stylesheet" href="../css/sign.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>
</head>
<body>
<main class="register-img row">
    <div class="col-md-4 offset-md-6 card ">
        <div class="card-header">注册</div>
        <form class="card-body" method="post" action="login.jsp" onsubmit="return signupCheck();">
            <div class="form-group">
                <label>昵称：</label>
                <input class="form-control" type="text" id="register-name" name="name" placeholder="请输入用户名 例：master" onblur="checkname()">
                <div class="tips"> </div>
            </div>
            <div class="form-group">
                <label>密码：</label>
                <input class="form-control" type="password" id="register-psw" name="psw" placeholder="密码 例：user111" onblur="checkpsw0()">
                <div class="tips"> </div>
            </div>
            <div class="form-group">
                <label>确认密码：</label>
                <input class="form-control" type="password" id="register-sure" name="psw-sure" placeholder="确认密码" onblur="checkpsw1()">
                <div class="tips"> </div>
            </div>
            <div class="form-group">
                <label>邮箱：</label>
                <input class="form-control" type="email" id="register-email" name="email" placeholder="邮箱 例：1561@gmail.com" onblur="checkemail()">
                <div class="tips"> </div>
            </div>
            <%--<div class="form-group">--%>
                <%--<label>电话：</label>--%>
                <%--<input class="form-control" type="tel" id="register-phone" name="phone" placeholder="电话 例：021-12345678" onblur="checkphone()">--%>
                <%--<div class="tips"> </div>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label>地址：</label>--%>
                <%--<input class="form-control" type="text" id="register-address" name="address" placeholder="地址" onblur="checkaddress()">--%>
                <%--<div class="tips"> </div>--%>
            <%--</div>--%>
            <div class="card-footer">
                <button type="button" class="btn btn-primary float-le" name="goIn" onclick="goin()">去登陆</button>
                <button type="submit" class="btn btn-primary float-right" id="bt-register">注册</button>
            </div>
        </form>
    </div>
</main>
<script src="../js/sign.js"></script>
</body>

</html>
