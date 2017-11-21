<%@ page import="Util.SecurityUtil" %>
<%@ page import="model.Author" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/01/bootstrap1.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/01/login1.css"/>
    <script src="${pageContext.request.contextPath}/statics/js/01/jquery-3.0.0.min.js" type="text/javascript" charset="utf-8"></script>

    <%
        String username = "";
        String password = "";
//        获取当前站点所有的cookie
        Author author = (Author) request.getSession().getAttribute("currentAuthor");
        if (author==null){
            Cookie cookies[] = request.getCookies();
            for (int i=0;cookies!=null&&i<cookies.length;i++){
                if ("login".equals(cookies[i].getName())){
                    String usernamePassword = cookies[i].getValue();
                    username = usernamePassword.split("_")[0];
                    password = usernamePassword.split("_")[1];

                }
            }
        }
        /*
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
//        对cookie进行遍历
        for(int i=0;i<cookies.length;i++){
           if("status".equals(cookies[i].getName())){

           }
            *//* if("username".equals(cookies[i].getName())){

                username = cookies[i].getValue();
            }else if("password".equals(cookies[i].getName())){
                password = cookies[i].getValue();
            }*//*
        }
        }*/
    %>
    <script src="${pageContext.request.contextPath}/statics/js/01/util.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            document.getElementById("username").onblur = function () {
                var name = document.getElementById("username").value;

//                发出异步请求
                var xhr = getXmlHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4) {
                        if (xhr.status == 200) {
                            //获取响应正文
                            document.getElementById("msg").innerHTML = xhr.responseText;
                        }
                    }
                }
                var url = "/servlet/LoginServlet?" + "time=" + new Date().getTime();
                xhr.open("POST",url,true);
                xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                xhr.send("username="+this.value);
            }
        }
    </script>
</head>
<body class="login_body">
<div class="login_div">
    <div class="col-xs-12 center_title">登录</div>
    <form action="${pageContext.request.contextPath}/control/login.html?" class="login" method="post">
        <div class="nav">
            <div class="nav login_to_input">
                <div class="col-xs-4 input_title">

                    用户:
                </div>
                <div class="col-xs-6">
                    <input class="input" type="text" name="username" id="username" value="<%=SecurityUtil.base64decode(username)%>"
                           placeholder="&nbsp;&nbsp;Please input username" required="required"/><span id="msg"></span>
                </div>
            </div>

            <div class="nav input_margin">
                <div class="col-xs-4 input_title">
                    密&nbsp;&nbsp;&nbsp;码:
                </div>
                <div class="col-xs-6">
                    <input class="input" type="password" name="password" required="required" value="<%=password%>"
                           placeholder="&nbsp;&nbsp;Please input password" autocomplete="off"/>
                    <label>
                        <input type="checkbox" name="auto" value="1"/>
                    </label>记住我<br/>
                </div>
            </div>


        </div>

        <div class="col-xs-12 button">
            <input type="submit" class="login sub_btn" value="登录" id="login"/>
        </div>
    </form>
    <div class="col-xs-12 tip">
        <a  class="tip_button" onclick="toRegister();" href="${pageContext.request.contextPath}/control/seeRegist.html">没有账号?前往注册</a>
    </div>
</div>
</body>
</html>