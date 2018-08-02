// var mail;
function login_name() {
    var name = document.getElementById("user-name").value;
    var tip = document.getElementsByClassName('tips')[0];
    if (name === "") {
        tip.innerHTML = "请输入昵称";
        return false;
    }
    else {
        tip.innerHTML = "";
        return true;
    }
}

function login_psw() {
    var psw = document.getElementById("user-psw").value;
    var tip = document.getElementsByClassName('tips')[1];
    if (psw === "") {
        tip.innerHTML = "请输入密码";
        return false;
    }
    else {
        tip.innerHTML = "";
        return true;
    }
}

function signinCheck(){
    login_name();
    login_psw();
    return login_name()&&login_psw();
}

function signupCheck(){
  return checkemail()&&checkpsw0()&&checkpsw1()&&checkcode();
}

function checkname(){
  var username = document.getElementById("register-name").value;
  var tip = document.getElementsByClassName('tips')[0];
  if (username === "") {
    tip.innerHTML = "请输入合法昵称";
    return false;
  }
  else {
    tip.innerHTML = "";
    return true;
  }
}

function checkpsw0(){
  var psw = document.getElementById("register-psw").value;
  var tip = document.getElementsByClassName('tips')[1];
  if (psw === "") {
    tip.innerHTML = "请输入密码";
    return false;
  }
  else if (psw !== "") {
    var patten = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
    var validity = patten.test(psw);
    if (!validity) {
      tip.innerHTML = "请输入6~12位数字字母混合密码";
      return false;
    }
    else {
      tip.innerHTML = "";
      return true;
    }
  }
}


function checkpsw1(){
  var psw = document.getElementById("register-sure").value;
  var tip = document.getElementsByClassName('tips')[2];
  if (psw === "") {
    tip.innerHTML = "请再次输入密码";
    return false;
  }
  else {
    if (psw !== document.getElementById("register-psw").value) {
      tip.innerHTML = "两次密码输入不一致,请重新输入";
      return false;
    }
    else {
      tip.innerHTML = "";
      return true;
    }
  }
}

function checkemail(){
  var email = document.getElementById("register-email").value;
  var tip = document.getElementsByClassName('tips')[0];

  if (email === "") {
    tip.innerHTML = "请输入邮箱";
    return false;
  }
  else if (email !== "") {
    var patten = new RegExp(/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/);
    var validity = patten.test(email);
    if (!validity) {
      tip.innerHTML = "请输入合法邮箱";
      return false;
    }
    else {
      tip.innerHTML = "";
      mail = email;
      return true;
    }
  }
}


function incheck(){
  var username = document.getElementById("user-name").value;
  var psw = document.getElementById("user-psw").value;
  var tip0 = document.getElementsByClassName('tips')[0];
  var tip1 = document.getElementsByClassName('tips')[1];
  if (username === "") {
    tip0.innerHTML = "请输入用户名";
    return false;
  }
  if (psw === "") {
    tip1.innerHTML = "请输入密码";
    return false;
  }
  else {
    return true;
  }
}

function checkcode() {
    var code = document.getElementById("register-code").value;
    var tip = document.getElementsByClassName('tips')[3];
    if (code === "") {
        tip.innerHTML = "请输入验证码";
        return false;
    }
    else {
        tip.innerHTML = "";
        return true;
    }
}

function sendEmail() {
    var email = document.getElementById("register-email").value;
    $.ajax({
            url:"mailConfirm",
        type:"post",
        data:{'username':email}
    });
    return false;
}
