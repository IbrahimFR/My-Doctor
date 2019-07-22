<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Verify Your Email </title>

    <script src="${pageContext.request.contextPath}/resources/js/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/resources/css/ct-navbar.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/materialize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style1.css">

    <!-- Ur css file you  -->
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Droid+Serif'>
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Lato">
</head>
<body>



<div id="navbar-full">
    <div id="navbar" class="myheader navbar-inverse">


        <nav class="navbar navbar-default " role="navigation">

            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header ">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">AlgoritmiCloud</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand navbar-brand-logo" href="#">
                        <!-- <div class="logo">
                            <img id="mainlogo" src="images/tabibyLogo.png">
                        </div> -->
                        <div class="brand"> AlgoritmiCloud</div>
                    </a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
               
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>

    </div>
    <!--  end navbar -->
    <div class="sec-navbar">
        <div class="sw container">
            <form>
                <input type="search" class="search" placeholder="Search..." />
                <button class="go"><span class="entypo-search"></span></button>
            </form>
        </div>
    </div>
</div>

<div class="container" style="margin-top:0">
    <div class="row center-align" style="padding:40px 0;">
        <div class="row">
            <h4 class="">Your Account is  temporarily Closed!!</h4>
            <p class="">Kindly contact with tabiby@karthag.com</p>
        </div>
        <div class="col s12">
            <p>We can resend a new verification mail.</p>
            <a href="${pageContext.request.contextPath}/login" class="waves-effect waves-teal btn btn-default">back to login</a>

            <!-- <p>Or you can update your information.</p>
            <form action="">
                <div class="row">
                    <div class="input-field col s12">
                      <input id="email" type="email" class="validate">
                      <label for="email">Email</label>
                    </div>
                     <button class="btn waves-effect waves-light btn-default right" type="submit" name="action">
                        Send mail
                      </button>
                </div>
            </form> -->

        </div>



    </div>


</div>

<!-- end menu-dropdown -->

<footer class="page-footer">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">AlogritmiCloud</h5>
                <p class="grey-text text-lighten-4">This is a short description</p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="#!">Blog</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">SDK</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">About us</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">Contact</a></li>
                </ul>
            </div>,
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © 2020 Copyright Text
            <a class="grey-text text-lighten-4 right" href="#!"></a>
        </div>
    </div>
</footer>

<script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.3.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugines.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ct-navbar.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/materialize.min.js"></script>
</body>
</html>
