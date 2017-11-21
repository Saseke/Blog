<%--列出所有的文章--%>
<%@ page import="java.util.List" %>
<%@ page import="model.File" %>
<%@ page import="model.Image" %>
<%@ page import="model.Author" %>
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
                            <a href="/01.jsp">
                                <%
                                    Author author =(Author) request.getAttribute("author");
                                    String str = null;
                                    if (author.getImage()==0){
                                        str = "head.jpg";
                                    }else{
                                        str = author.getId()+".jpg";
                                    }
                                %>
                                <%--<img src="/statics/image/${image.name}" class="img-circle"/>--%>
                                <img src="/statics/image/<%=str%>" class="img-circle"/>


                            </a>
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
                <%--进行分页的操作--%>
                <%
                    List<File> list = (List<File>) request.getAttribute("files");
                    Author author1 = (Author) request.getSession().getAttribute("currentAuthor");

                    if (list != null) {
                        for (File file : list) {
                            if (file != null) {
                                out.write("<h2>" + file.getTitle() + "</h2><br/>");
                                out.write("访问量：" + file.getTime() + "<br/>");
                                out.write("<h4>Posted by <a href=\"#\">"+author1.getUsername()+"</a> on" + file.getDate() + "</h4>");
                                String con = file.getContent();
                                String content = con.substring(0, con.length() / 4);
                                out.write("<h5>" + content + "</h5>");
                                out.write("<a href=\"/opeate/seeAll.do?id=" + file.getId() + "\" class=\"btn btn-default btn-lg \">Read More <i class=\"fa fa-angle-right\"></i></a>");
                                out.flush();
                            }
                        }
                    } else {
                        System.out.println("没传过来值");
                    }
                %>
                <%--<a href="/opeate/seeAll.do?id="+file.getId() class="btn btn-default btn-lg ">Read More <i class="fa fa-angle-right"></i></a>--%>

            </div>
            <%--<div class="col-md-3" style="padding-top: 30px;">
                <div class="row">
                    <ul class="list-group">



                    </ul>
                </div>
            </div>--%>
            <%-- <div class="col-md-3" style="padding-top: 30px;">
                 <div class="row">
                     <ul class="list-group">
                     </ul>
                 </div>
             </div>--%>

            <br/>
            <nav>
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <%
                        int count = (int) request.getAttribute("count");
                        for (int i = 1; i <= count; i++) {
                            out.write("<li><a href=\"/opeate/listFile.do?page=" + i + "\">" + i + "</a></li>");
                            out.flush();
                        }
                    %>

                    <span style="font-size:14px;"><a href="#">回到最顶端</a></span>
                    <%--<a href=""--%>
                    <%--<li><a href="/servlet/webControlServlet?page="+i>i</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>--%>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-3" style="padding-top: 30px;">
            <div class="row">
                <ul class="list-group">
                    <li class="list-group-item"><strong>文章分类</strong></li>
                    <a name="linux" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.do?name=linux">linux</a>
                    <a name="mybatis" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.do?name=mybatis">mybatis</a>
                    <a name="Spring" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.do?name=Spring">Spring</a>
                    <a name="java" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.do?name=java">java基础</a>
                    <a name="databases" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.do?name=databases">数据库</a>
                    <a name="diary" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.do?name=diary">diary</a>
                    <a name="others" class="list-group-item"
                       href="${pageContext.request.contextPath}/opeate/direfile.do?name=others">others</a>
                    <%--<li class="list-group-item">Vestibulum at eros</li>--%>
                </ul>
            </div>
            <div class="row">
                <form action="${pageContext.request.contextPath}/opeate/findFile.do" method="get">
                    <label> <input type="text" name="content"/>
                    </label><input type="submit" value="查询"/>
                </form>
                <a href="${pageContext.request.contextPath}/opeate/rd.do">添加文章</a>&nbsp;&nbsp;

                <a href="${pageContext.request.contextPath}/control/seelogin.do"> 注销</a>


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
