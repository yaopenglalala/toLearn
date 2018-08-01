var mail;
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
  // checkname();
    checkemail();
    checkpsw0();
  checkpsw1();

  // checkphone();
  // checkaddress();
  return checkname()&&checkpsw0()&&checkpsw1()&&checkemail();
      // &&checkphone()&&checkaddress()
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

function fillEmail() {
    document.getElementById("codeMail").value=mail;
}


//
// function checkphone(){
//   var phone = document.getElementById("register-phone").value;
//   var tip = document.getElementsByClassName('tips')[4];
//   if (phone === "") {
//     tip.innerHTML = "请输入电话号码";
//     return false;
//   }
//   else if (phone !== "") {
//     var patten = /^[0-9]{3}-[0-9]{8}$/;;
//     var validity = patten.test(phone);
//     if (!validity) {
//       tip.innerHTML = "请输入合法电话号码";
//       return false;
//     }
//   else {
//     tip.innerHTML = "";
//     return true;
//   }
// }
// }
// function checkaddress(){
//   var adddress = document.getElementById("register-address").value;
//   var tip = document.getElementsByClassName('tips')[5];
//   if (adddress === "") {
//     tip.innerHTML = "请输入地址";
//     return false;
//   }
//   else {
//     tip.innerHTML = "";
//     return true;
//   }
// }

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

// function goin(){
//   window.location.href="./signIn.php";
// }
