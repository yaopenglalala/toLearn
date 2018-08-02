<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To Learn</title>
    <link rel="stylesheet" href="../css/sign.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"></head>
<body>
<div class="modal" tabindex="-1" role="dialog" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">获取验证码</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>验证码将被发送至:</p>
                <form method="post" action="mailConfirm" class="coding">
                    <input type="text" readonly="readonly" name="username" value="" id="codeMail">
                </form>
                <p>请注意查收</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary" id="coding" onclick="return sendEmail()">确认</button>
            </div>
        </div>
    </div>
</div>

<main class="register-img row">
    <div class="col-lg-3"></div>
    <div class="col-lg-6 card">
        <div class="card-header">注册</div>
        <form class="card-body" method="post" action="register" id="registerForm">
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
            <div class="form-group">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="codeEmail()">获取验证码</button>
                <input class="form-control" type="text" id="register-code" name="code" onblur="checkcode()">
                <div class="tips"> </div>
            </div>
            <div class="card-footer">
                <button type="button" class="btn btn-primary float-le" name="goIn" href="login">去登陆</button>
                <button type="submit" class="btn btn-primary float-right" id="bt-register" onclick="return signupCheck();">注册</button>
            </div>
        </form>
    </div>
    <div class="col-lg-3"></div>
</main>
<script src="../js/add.js"></script>
<script src="../js/sign.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
