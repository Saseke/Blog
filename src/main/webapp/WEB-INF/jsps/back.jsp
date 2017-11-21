<%@ page import="java.util.List" %>
<%@ page import="model.File" %>
<%@ page import="model.Author" %>
<%@ page import="service.BusinessService" %>
<%@ page import="service.BusinessServiceImpl" %>
<%@ page import="model.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title>Nice responsive template for blogger</title>
    <!-- BOOTSTRAP CORE STYLE -->
    <link href="/statics/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME ICON STYLE -->
    <link href="/statics/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE CSS -->
    <link href="/statics/css/style.css" rel="stylesheet" />
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

                                <%--<img src="/statics/image/${image.name}" class="img-circle"/>--%>
                                    <img src="${pageContext.request.contextPath}/image/Photo.html" class="img-circle"/>


                            </a>
                        </div>

                    </div>

                </div>
                <div class="col-md-8 header-text-top " id="about">



                    <h1>Nice responsive template for blogger.</h1>
                    This blogging template use bootstrap and html to create a very nice blogging page with great responsive. <br />
                    Here you can write a general notes about your blog.<br />
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
                Say hello to me at <strong>hello</strong>@Yoke.com
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
                <%-- ${file.title}
                 ${file.content}--%>

                <%
                    File file =(File) request.getAttribute("file");
                    BusinessService s = new BusinessServiceImpl();
                    List<Comment> comments = (List<Comment>) request.getAttribute("comments");

                    Author author1 = s.findAuthorWithFile(file.getAuthor_id());

                    out.write("<h2>"+file.getTitle()+"</h2><br/>");
                    out.write("访问量："+file.getTime()+"<br/>");
                    out.write("<h4>Posted by <a href=\"#\">"+author1.getUsername()+"</a> on"+file.getDate()+"</h4>");
                    out.write("<p>"+file.getContent()+"</p><br/>");
                    if (comments.size()>0) {
                        for (Comment comment : comments) {
                            Author author = s.findAuthorWithFile(comment.getAuthor_id());
                            out.write("<h5>" + author.getUsername() + ":" + comment.getMatter() + "<h5>");
                        }
                    }
                    out.write("<a href=\"/opeate/back.html\">返回</a>");
                    out.flush();
                %>



            </div>
            <div class="col-md-3" style="padding-top: 30px;">
                <div class="row">
                    <ul class="list-group">


                    </ul>
                </div>
            </div>
            <div class="blog-post">

            </div>
            <div class="blog-post">
                <h2>Curabitur nec nisl odio. Mauris vehicula at nunc id posuere.</h2>
                <h4>Posted by <a href="#">admin</a> on 24th January 2015 </h4>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                    Curabitur nec nisl odio. Mauris vehicula at nunc id posuere.
                    Curabitur nec nisl odio. Mauris vehicula at nunc id posuere.
                </p>
                <a href="#" class="btn btn-default btn-lg ">Read More <i class="fa fa-angle-right"></i></a>
            </div>

            <br />
            <nav>
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>

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
                    <a name="linux" class="list-group-item" href="${pageContext.request.contextPath}/opeate/direfile.html?name=linux">linux</a>
                    <a name="mybatis" class="list-group-item" href="${pageContext.request.contextPath}/opeate/direfile.html?name=mybatis">mybatis</a>
                    <a name="Spring" class="list-group-item" href="${pageContext.request.contextPath}/opeate/direfile.html?name=Spring">Spring</a>
                    <a name="java" class="list-group-item" href="${pageContext.request.contextPath}/opeate/direfile.html?name=java">java基础</a>
                    <a name="databases" class="list-group-item" href="${pageContext.request.contextPath}/opeate/direfile.html?name=databases">数据库</a>
                    <a name="diary" class="list-group-item" href="${pageContext.request.contextPath}/opeate/direfile.html?name=diary">diary</a>
                    <a name="others" class="list-group-item" href="${pageContext.request.contextPath}/opeate/direfile.html?name=others">others</a>
                    <%--<li class="list-group-item">Vestibulum at eros</li>--%>
                </ul>

            </div>
            <div class="row">
                <a href="${pageContext.request.contextPath}/opeate/seelogin.do"> 注销</a>


            </div>
        </div>

    </div>


</div>

<!--END HOME PAGE SECTION-->
<div class="footer-sec" style="margin-top: 0px;">
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
