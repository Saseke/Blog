<%--
  Created by IntelliJ IDEA.
  User: Yoke
  Date: 2017/8/10
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="<%=path %>/opeate/listFile.html">User List</a>
</body>
</html>
