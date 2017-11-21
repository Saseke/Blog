<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/01/bootstrap1.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/01/login1.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/01/jquery1-ui.css">
    <script src="${pageContext.request.contextPath}/statics/js/01/jquery-3.0.0.min.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/statics/js/01/jquery-ui.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/statics/js/01/jquery-ui.min.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/statics/js/01/util.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            document.getElementById("name_r").onblur = function () {
                var name = document.getElementById("name_r").value;
                if (name != null && name.length > 0) {
//                发出异步请求
                    var xhr = getXmlHttpRequest();
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState === 4) {
                            if (xhr.status === 200) {
                                //获取响应正文
                                document.getElementById("msg").innerHTML = xhr.responseText;
                            }
                        }
                    }
                    var url = "/servlet/CheckServlet?" + "time=" + new Date().getTime();
                    xhr.open("POST", url, true);
                    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    xhr.send("name_r=" + this.value);
                }
            }
        }
    </script>
    <script>
        function checkpwd() {
            var pwd = document.getElementById("r_pwd").value;
            var reg_password = /^[a-zA-Z0-9_]{6,12}$/;
            if (!reg_password.test(pwd)) {
                alert("请输入字母数字下划线6-12位");
            }

        }
    </script>
    <script type="text/javascript">
        function check() {
            var pwd = document.getElementById("r_pwd").value;//首次输入
            var repwd = document.getElementById("affirm_psd").value;//重复密码
            var reg_password = /^[a-zA-Z0-9_]{6,12}$/;
            if (repwd != null && repwd.length > 0) {
                if (reg_password.test(pwd)) {
                    if (pwd !== repwd) {
                        alert("两次输入的密码不同");
                    }
                }
            }
        }
    </script>
</head>

<body class="login_body">
<div class="login_div">
    <div class="col-xs-12 center_title">注册</div>
    <form class="register" action="${pageContext.request.contextPath}/control/regist.html?" method="post">
        <div class="nav">
            <div class="nav register_to_input">
                <div class="col-xs-4 input_title">
                    用户名:
                </div>
                <div class="col-xs-6">
                    <input class="input" type="text" required="required" name="name_r" id="name_r" value=""
                           placeholder="&nbsp;&nbsp;请输入用户名"
                    /><span id="msg"></span>
                </div>
            </div>
            <div class="nav input_margin">
                <div class="col-xs-4 input_title">
                    描&nbsp;&nbsp;&nbsp;述
                </div>
                <div class="col-xs-6">
                    <input class="input" type="text" required="required" name="des" id="description"
                           placeholder="&nbsp;&nbsp;请输入描述"/>
                </div>

            </div>
            <%--     <div class="nav input_margin">
                     <div class="col-xs-4 input_title">
                         头像上传
                     </div>
                     <div class="col-xs-6">
                         <input class="input" type="file" required="required" name="image" id=""image
                                placeholder="&nbsp;&nbsp;请上传头像"/>
                     </div>

                 </div>--%>

            <div class="nav input_margin">
                <div class="col-xs-4 input_title">
                    密&nbsp;&nbsp;&nbsp;码:
                </div>
                <div class="col-xs-6">
                    <input class="input" type="password" required="required" name="pwd" id="r_pwd"
                           placeholder="&nbsp;&nbsp;请输入密码"
                           onchange="check()"/>
                    <div id="pwd_prompt">密码由英文字母和数字组成的4-10位字符</div>
                </div>
            </div>
            <div class="nav input_margin">
                <div class="col-xs-4 input_title">
                    确认密码:
                </div>
                <div class="col-xs-6">
                    <input class="input" type="password" required="required" name="confirmPwd" id="affirm_psd"
                           onchange="check()"
                           placeholder="&nbsp;&nbsp;请输入确认密码"/>
                </div>
            </div>
            <div class="col-xs-12 button">
                <input type="submit" class="sub_btn" value="注册" id="register"/>
            </div>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/control/seelogin.html">
        <div class="col-xs-12 tip">

            <button class="tip_button">已有账号?返回登录</button>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">

</script>
</html>
