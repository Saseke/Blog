<%--
  Created by IntelliJ IDEA.
  User: Yoke
  Date: 2017/8/17
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/01/bootstrap1.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/01/login1.css"/>
    <script src="${pageContext.request.contextPath}/statics/js/01/jquery-3.0.0.min.js" type="text/javascript"
            charset="utf-8"></script>
    <script>
        function he() {
            var file = document.getElementById("haa").files[0];
            console.log(file);
//        alert(file['name']);
            var name = file['name'];
//        alert(name);
            var strs = new Array();
            strs = name.split(".");
            var type = strs[1];//得到后缀
            var arr = "jpg";
            if (type==arr){
                return true;
            }else {
                alert("上传文件必须是jpg格式");
                return false;
            }
//            alert(strs[0]);
//            alert(strs[1]);

        }
    </script>
</head>
<body class="login_body">
<div class="login_div">
    <div class="col-xs-12 center_title">头像上传</div>
    <form action="${pageContext.request.contextPath}/servlet/UpLoadServle" method="post" enctype="multipart/form-data">
        <div class="nav">
            <div class="nav login_to_input">
                <div class="col-xs-4 input_title">

                    请选择图片
                </div>
                <div class="col-xs-6">
                    <input type="file" class="input" accept="image/jpeg" name="file" id="haa" onchange="he()"/>
                </div>
            </div>
        </div>
        <div class="col-xs-12 button">
            <input type="submit" class="login sub_btn" value="提交" id="submit"/>${result}
        </div>


    </form>
    <div class="col-xs-12 tip">
        <a class="tip_button" href="${pageContext.request.contextPath}/opeate/listFile.html">返回主页</a>
    </div>

</div>
</body>
</html>
<%-- <div class="col-xs-4 input_title">
请选择图片<input type="file" name="file" value="file"/>
<input type="submit" value="提交"/>${result}
 </div>--%>
