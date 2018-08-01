<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To Learn</title>
    <link rel="stylesheet" href="../css/sign.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>
</head>
<body>
<main class="register-img row">
    <div class="col-lg-3"></div>
    <div class="col-lg-6 card">
        <div class="card-header">注册</div>
        <form class="card-body" method="post" action="register" onsubmit="return signupCheck();">
            <%--<div class="form-group">--%>
                <%--<label>昵称：</label>--%>
                <%--<input class="form-control" type="text" id="register-name" name="username" placeholder="请输入用户名 例：master" onblur="checkname()">--%>
                <%--<div class="tips"> </div>--%>
            <%--</div>--%>
            <div class="form-group">
                <label>邮箱：</label>
                <input class="form-control" type="email" id="register-email" name="username" placeholder="邮箱 例：1561@gmail.com" onblur="checkemail()">
                <div class="tips"> </div>
            </div>
            <div class="form-group">
                <label>密码：</label>
                <input class="form-control" type="password" id="register-psw" name="password" placeholder="密码 例：user111" onblur="checkpsw0()">
                <div class="tips"> </div>
            </div>
            <div class="form-group">
                <label>确认密码：</label>
                <input class="form-control" type="password" id="register-sure" name="psw-sure" placeholder="确认密码" onblur="checkpsw1()">
                <div class="tips"> </div>
            </div>
                <%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick=""> 获取验证码 </button>--%>
                <%--<div style="display: none">--%>
                    <%--<!-- 模态框 -->--%>
                    <%--<div class="modal fade" id="myModal">--%>
                        <%--<div class="modal-dialog">--%>
                            <%--<div class="modal-content">--%>
                                <%--<!-- 模态框头部 -->--%>
                                <%--<div class="modal-header">--%>
                                    <%--<h4 class="modal-title">获取验证码</h4>--%>
                                    <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                                <%--</div>--%>

                                <%--<!-- 模态框主体 -->--%>
                                <%--<div class="modal-body">--%>
                                    <%--<p>验证码将被发送至:</p>--%>
                                    <%--<form method="post" action="mailConfirm" >--%>
                                        <%--<input type="email" readonly="readonly" value="" id="codeMail">--%>
                                    <%--</form>--%>
                                    <%--<p>请注意查收</p>--%>
                                <%--</div>--%>
                                <%--<!-- 模态框底部 -->--%>
                                <%--<div class="modal-footer">--%>
                                    <%--<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>--%>
                                    <%--<button form="codeMail" type="submit" class="btn btn-primary">确认</button>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label>验证码：</label>--%>
                <%--<input class="form-control" type="tel" id="register-phone" name="code" placeholder="验证码已发送至您的邮箱,请注意查收" onblur="checkphone()">--%>
                <%--<div class="tips"> </div>--%>
            <%--</div>--%>
            <%--<div class="card-footer">--%>
                <button type="button" class="btn btn-primary float-le" name="goIn" onclick="goin()">去登陆</button>
                <button type="submit" class="btn btn-primary float-right" id="bt-register">注册</button>
            </div>
        </form>
    </div>
    <div class="col-lg-3"></div>
</main>
<script src="../js/sign.js"></script>
</body>
</html>
