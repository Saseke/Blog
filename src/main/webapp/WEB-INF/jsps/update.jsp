<%@ page import="java.util.List" %>
<%@ page import="model.Author" %>
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
    <link href="${pageContext.request.contextPath}/statics/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME ICON STYLE -->
    <link href="${pageContext.request.contextPath}/statics/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE CSS -->
    <link href="${pageContext.request.contextPath}/statics/css/style.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
    <script>
        window.onload = function()
        {
            CKEDITOR.replace( 'content' );
        };
    </script>
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
                Say hello to me at <strong>hello</strong>@yourdomain.com
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

                <form action="${pageContext.request.contextPath}/opeate/updateFile1.html" method="post">
                    <input type="hidden" name="id" value="${file.id}"/>
                    文章标题 <input  type="text" id="textTitle" required="required"  name="title" style="width: 300px" height="200px" value="${file.title}"/><br/>
                    文章正文 <textarea rows="30" cols="50" name="content">${file.content}</textarea>
                    <script type="text/javascript">CKEDITOR.replace('content');</script>
                    <input type="submit"  value="提交"/>
                </form>


            </div>
            <div class="col-md-3" style="padding-top: 30px;">
                <div class="row">
                    <ul class="list-group">


                    </ul>
                </div>
            </div>
            <div class="blog-post">

            </div>

            <br />
            <nav>
                <ul class="pagination">



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

