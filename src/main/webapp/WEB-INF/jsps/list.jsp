<%--列出所有的文章--%>
<%@ page import="java.util.List" %>
<%@ page import="model.File" %>
<%@ page import="model.Image" %>
<%@ page import="model.Author" %>
<%@ page import="service.BusinessService" %>
<%@ page import="service.BusinessServiceImpl" %>
<%@ page import="model.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title>Nice responsive template for blogger</title>
    <!-- BOOTSTRAP CORE STYLE -->
    <link href="${pageContext.request.contextPath}/statics/css/bootstrap.css" rel="stylesheet"/>
    <!-- FONT AWESOME ICON STYLE -->
    <link href="${pageContext.request.contextPath}/statics/css/font-awesome.css" rel="stylesheet"/>
    <!-- CUSTOM STYLE CSS -->
    <link href="${pageContext.request.contextPath}/statics/css/style.css" rel="stylesheet"/>

</head>
<body>


<div id="header">
    <div class="overlay">
        <div class="container">
            <div class="row">
                <div class="col-md-4 logo-div">
                    <div class="logo-inner text-center">
                        <div class="logo-name">
                            <a href="${pageContext.request.contextPath}/01.jsp">
                                <%--头像--%>
                                <img src="${pageContext.request.contextPath}/image/Photo.html" class="img-circle"/>

                            </a><br/>
                            <a href="${pageContext.request.contextPath}/opeate/listFile.html">返回大厅</a>
                        </div>

                    </div>

                </div>
                <div class="col-md-8 header-text-top " id="about">


                    <h1>Nice responsive template for blogger.</h1>
                    This blogging template use bootstrap and html to create a very nice blogging page with great
                    responsive. <br/>
                    Here you can write a general notes about your blog.<br/>
                    <h2><strong>Who I am ? </strong></h2>
                    <i>I am ${currentAuthor.username} </i>

                </div>
            </div>
        </div>
    </div>
</div>
<!--END HEADER SECTION-->
<div class="info-sec">
    <div class="container">
        <div class="row">
            <div class="col-md-10">
                Say hello to me at <strong>hello</strong>@Yokeqq.com
            </div>
            <div class="col-md-2">
                <div class="social-link">
                    <a href="#" class="btn btn-default btn-xs"><i class="fa fa-facebook fa-2x"></i></a>
                    <a href="#" class="btn btn-default btn-xs"><i class="fa fa-linkedin fa-2x"></i></a>
                    <a href="#" class="btn btn-default btn-xs"><i class="fa fa-google-plus fa-2x"></i></a>
                </div>

            </div>

        </div>
    </div>
</div>
<!--END INFO SECTION-->
<div class="container">

    <div class="row">

        <div class="col-md-8 ">
            <div class="blog-post">
                <%
                    BusinessService s = new BusinessServiceImpl();
                    Author author1 = (Author) request.getSession().getAttribute("currentAuthor");
                    List<File> files = (List<File>) request.getAttribute("fileArrayList");
                    for (File file : files) {
                        out.write("<h2>" + file.getTitle() + "</h2><br/>");
                        out.write("访问量：" + file.getTime() + "<br/>");
                        out.write("<h4>Posted by <a href=\"#\">" + author1.getUsername() + "</a> on" + file.getDate() + "</h4>");
                        String con = file.getContent();
                        String content = con.substring(0, con.length() / 4);
                        out.write("<h5>" + content + "</h5>");
                        out.write(" <a href=\"/opeate/updateFile.html?id=" + file.getId() + "\">编辑</a><br/>");
                        List<Comment> comments = s.selectComment(file.getId());
                        if (comments.size() > 0) {
                            int length = comments.size() / 2;
                            for (int i = 0; i < length; i++) {
//                                    得到写评论的人的iid
                                int id = comments.get(i).getAuthor_id();
                                Author author = s.findAuthorWithFile(id);
                                out.write("<h5>" + author.getUsername() + "&nbsp;:&nbsp;&nbsp;" + comments.get(i).getMatter() + "</h5>");
                            }
                        }
                        out.write("<a href=\"/opeate/backhome.html?id=" + file.getId() + "\" class=\"btn btn-default btn-lg \">Read More <i class=\"fa fa-angle-right\"></i></a>");
                        out.flush();
                    }

                %>
                <%--<a href="/opeate/seeAll.do?id="+file.getId() class="btn btn-default btn-lg ">Read More <i class="fa fa-angle-right"></i></a>--%>
            </div>
            <%--参赛超--%>
            <br/>
            <nav>
                <ul class="pagination">
                    <%
                        int count = (int) request.getAttribute("count");
                        for (int i = 1; i <= count; i++) {
                            out.write("<li><a href=\"/opeate/list.html?page=" + i + "\">" + i + "</a></li>");
                            out.flush();
                        }
                    %>
                    <span style="font-size:14px;"><a href="#">回到最顶端</a></span>


                </ul>
            </nav>
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-3" style="padding-top: 30px;">
            <div class="row">
                <ul class="list-group">
                    <li class="list-group-item"><strong>文章分类</strong></li>
                    <a name="linux" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.html?name=linux">linux</a>
                    <a name="mybatis" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.html?name=mybatis">mybatis</a>
                    <a name="Spring" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.html?name=Spring">Spring</a>
                    <a name="java" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.html?name=java">java基础</a>
                    <a name="databases" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.html?name=databases">数据库</a>
                    <a name="diary" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.html?name=diary">diary</a>
                    <a name="others" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.html?name=others">others</a><%--<li class="list-group-item">Vestibulum at eros</li>--%>
                </ul>
            </div>
            <div class="row">
                <form action="${pageContext.request.contextPath}/opeate/findFile.html" method="get">
                    <label> <input type="text" name="content"/>
                    </label><input type="submit" value="查询"/>
                </form>
                <a href="${pageContext.request.contextPath}/opeate/rd.html">添加文章</a>&nbsp;&nbsp;

                <a href="${pageContext.request.contextPath}/control/seelogin.html"> 注销</a>


            </div>
        </div>

    </div>


</div>

<!--END HOME PAGE SECTION-->
<div class="footer-sec" style="margin-top: 0;">
    <div class="container">
        <div class="row">
            <div class="col-md-12 foo-inner">
            </div>
        </div>
    </div>
</div>
<!-- END FOOTER SECTION -->
<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME -->
<!-- CORE JQUERY -->
<script src="${pageContext.request.contextPath}/statics/js/jquery-1.11.1.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="${pageContext.request.contextPath}/statics/js/bootstrap.js"></script>

</body>
</html>
