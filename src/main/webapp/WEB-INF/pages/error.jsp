<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Error</title>

    <script
            src="${pageContext.request.contextPath}/resources/js/html5shiv.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/errorStyle.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/footerStyle.css">


    <link
            href="${pageContext.request.contextPath}/resources/css/ct-navbar.css"
            rel="stylesheet"/>


    <!-- Ur css file you  -->
    <link rel='stylesheet'
          href='http://fonts.googleapis.com/css?family=Droid+Serif'>
</head>
<body>


<div id="navbar-full">
    <div id="navbar" class="myheader">


        <nav class="navbar navbar-default " role="navigation">

            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Tabiby</span> <span
                            class="icon-bar"></span> <span class="icon-bar"></span> <span
                            class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand navbar-brand-logo" href="#">
                        <div class="logo">
                            <img id="mainlogo" src="images/logo.png">
                        </div>
                        <div class="brand">Tabiby</div>
                    </a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse"
                     id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">

                        <li><a href="#" class="dropdown-toggle"
                               data-toggle="dropdown"> <i class="fa fa-codepen fa-lg"></i>

                            <p>Dashborde</p>
                        </a></li>
                        <li><a href="#" class="dropdown-toggle"
                               data-toggle="dropdown"> <i class="fa fa-calendar fa-lg"></i>

                            <p>Market</p>
                        </a></li>
                        <li><a href="#" class="dropdown-toggle"
                               data-toggle="dropdown"> <i class="fa fa-code fa-lg"></i>

                            <p>SDK</p>
                        </a></li>

                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown"> <i class="fa fa-user fa-lg"></i>

                            <p>Account</p>
                        </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">View Profile <i
                                        class="fa fa-file-text fa-lg"></i>
                                </a></li>
                                <li><a href="#">Edit <i class="fa fa-edit fa-lg"></i>
                                </a></li>
                                <li><a href="#">Something <i class="fa fa-random fa-lg"></i>
                                </a></li>

                                <li class="divider"></li>
                                <li><a href="#">Logout <i class="fa fa-sign-out fa-lg"></i>
                                </a></li>
                            </ul>
                        </li>
                    </ul>


                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid --> </nav>

    </div>
    <!--  end navbar -->

</div>
<!-- end menu-dropdown -->

<div class="ee">
    <div class="container">
        <div class="erorr row">
            <div class="for-pic col-xs-12">
                <h1 class="text-center lead">Opss ! There Is Something Goes
                    Wrong ...</h1>
                <img class="image-er img-circle img-responsive center-block  "
                     src="${pageContext.request.contextPath}/resources/images/error.png">
            </div>

        </div>
        <!-- end error -->
    </div>
</div>

<!--footer-->
<!--footer-->
<div class="copy-right">
    <div class="container">
        <div class="inner-copy-right center-block text-center ">
            <p class="lead">
                Copyright &copy; 2015 <span><strong> -
							AlgoritmiCloud -</strong></span> All rights reserved
            </p>
        </div>
    </div>
</div>
<!--end footer -->


<script
        src="${pageContext.request.contextPath}/resources/js/jquery-2.1.3.js"></script>
<script
        src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/resources/js/ct-navbar.js"></script>
<script
        src="${pageContext.request.contextPath}/resources/js/loginJS.js"></script>


</body>
</html>
