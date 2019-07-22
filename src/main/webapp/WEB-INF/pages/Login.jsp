<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

<script
	src="${pageContext.request.contextPath}/resources/js/html5shiv.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/loginStyle.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/footerStyle.css">


<link
	href="${pageContext.request.contextPath}/resources/css/ct-navbar.css"
	rel="stylesheet" />


<!-- Ur css file you -->
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
					<a class="navbar-brand navbar-brand-logo" href="${pageContext.request.contextPath}">
						<div class="logo">
							<img id="mainlogo"
								 src="${pageContext.request.contextPath}/resources/images/tabibyLogo.png">
						</div>
						<div class="brand">Tabiby</div>
					</a>
				</div>
				<!-- 	Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					 id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">

						<li><a href="${pageContext.request.contextPath}" class="dropdown-toggle"
							   data-toggle="dropdown"> <i class="fa fa-home fa-lg"></i>

							<p>Home</p>
						</a></li>

					</ul>


				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid  --></nav>

	</div>

	</div>
	<!-- 
	end menu-dropdown user login -->

	<div class="form-login">
		<div class="container">
			<div class="log-1 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<div class="radius0 panel panel-info">
					<div class="radius0 panel-heading">
						<div class="panel-title">
							<strong>Tabiby</strong>
						</div>
						<div class="log-2">
							<a href="#">Forgot password?</a>
						</div>
					</div>

					<div class="log-3 panel-body">

						<form name='f' onsubmit=" return login_form_Valid() "
							action="${pageContext.request.contextPath}/login" method="post"
							class="form-horizontal">

							<div class="input-group log-5">
								<span class="radius0 input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input
									 id="_email2" type="text"
									class="radius0 form-control" name="username" value=""
									placeholder="UserName">
							</div>

							<div class="input-group log-5">
								<span class="radius0 input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span> <input
									onblur="login_password_Valid()" id="_password" type="password"
									class="radius0 form-control" name="password"
									placeholder="password">
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

							<div class="input-group">
								<div class="checkbox">
									<label> <input id="login-remember" type="checkbox"
										name="remember" value="1"> Remember me
									</label>
								</div>
							</div>

							<div class="form-group log-6">

								<div class="col-sm-12 controls">
									<button type="submit" onclick="login_form_Valid()"
										class="radius0 padingupdown btn btn-info">Login</button>
									<div id="__form" class="alert-danger alert hidden"
										style="float: right; padding: 5px">OPS !! Make Sure From
										Your UserName And Password</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12 control">
									<div class="log-7">
										Don't have an account! <a href="#"> Sign Up Here </a>
									</div>
								</div>
							</div>
							<div>
								<c:if test="${param.error ne null}">
									<p class="err-mes">Invalid UserName Or Password , Try Again</p>
								</c:if>
								<c:if test="${param.logout ne null}">
									<p class="err-mes-out">You Have Been Logged Out , Thank You</p>
								</c:if>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>

	</div>


	<!-- 	end user login footer -->
	<div class="copy-right">
		<div class="container">
			<div class="inner-copy-right center-block text-center ">
				<p class="lead">
					Copyright &copy; 2016 <span><strong> -
							Tabiby -</strong></span> All rights reserved
				</p>
			</div>
		</div>
	</div>
	<!-- 	end footer -->


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
