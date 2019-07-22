<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tabiby</title>

<script
	src="${pageContext.request.contextPath}/resources/js/html5shiv.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap_1.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
	<!-- Custom Fonts -->
	<%--<link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>


	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mainStyle.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/footerStyle.css">


<link
	href="${pageContext.request.contextPath}/resources/css/ct-navbar.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/AnimateMin.css"
	rel="stylesheet" />


<!-- Ur css file you  -->
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=Droid+Serif'>
</head>
<body>


	<div id="navbar-full ">
		<div id="navbar" class="myheader navbar-inverse">


			<nav class="navbar navbar-default " role="navigation">

			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header ">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Tabiby</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand navbar-brand-logo" href="/">
						<div class="logo">
							<img id="mainlogo"
								src="${pageContext.request.contextPath}/resources/images/tabibyLogo.png">
						</div>
						<div class="brand">Tabiby</div>
					</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li class="is-open open "><a href="/" class="dropdown-toggle"
							data-toggle="dropdown"> <i  class="fa fa-home fa-lg"></i>
								<p>Home</p>
						</a></li>

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i  style="color: #55ACEE" class="fa fa-user fa-lg"></i>

								<p>Account</p>
						</a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/login">Login
										<i class="fa fa-random fa-lg"></i>
								</a></li>

							</ul></li>
					</ul>


				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid --> </nav>

		</div>
		<!--  end navbar -->

	</div>
	<!-- end menu-dropdown -->


	<div id="carousel-example-generic" class="carousel-1 carousel slide">

		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			<li data-target="#carousel-example-generic" data-slide-to="3"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">

			<!-- First slide -->
			<div class="item active deepskyblue">

				<div class="carousel-caption">
					<h3 data-animation="animated bounceInLeft">Tabiby</h3>

					<h3 data-animation="animated bounceInRight">Find and book a doctor</h3>
					<button class="btn btn-primary btn-lg"
						data-animation="animated zoomInUp">Join Us Now</button>
				</div>
			</div>
			<!-- /.item -->

			<!-- Second slide -->
			<div class="item skyblue">
				<div class="carousel-caption">
					<h3 class="icon-container" data-animation="animated bounceInDown">
						<span class="glyphicon glyphicon-heart"></span>
					</h3>

					<h3 data-animation="animated bounceInUp">Take Your Medical Care</h3>
					<button class="btn btn-primary btn-lg"
						data-animation="animated zoomInRight">Read More</button>
				</div>
			</div>
			<!-- /.item -->

			<!-- Third slide -->
			<div class="item darkerskyblue">
				<div class="carousel-caption">
					<h3 class="icon-container" data-animation="animated zoomInLeft">
						<span class="glyphicon glyphicon-check"></span>
					</h3>

					<h3 data-animation="animated flipInX">Find The Best Clinic</h3>
					<button class="btn btn-primary btn-lg"
						data-animation="animated lightSpeedIn">Read More</button>
				</div>
			</div>
			<!-- /.item -->


			<!-- /.item -->

		</div>
		<!-- /.carousel-inner -->

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>

		<!-- /.carousel -->

	</div>

	<!-- /.container -->


	<!--start the openions -->


	<section id="clientopinions"
		class="clientopinone carousel slide text-center">
	<div class="container">
		<div class="row">
			<div class="col-xs-12 text-center ">
				<h1>TESTIMONIALS</h1>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-12" data-wow-delay="0.2s">
				<div class="carousel slide" data-ride="carousel" id="quote-carousel">
					<!-- Bottom Carousel Indicators -->
					<ol class="carousel-indicators hidden-xs">
						<li data-target="#quote-carousel" data-slide-to="0" class="active"><img
							class="img-responsive "
							src="${pageContext.request.contextPath}/resources/images/user-def.png"
							alt="Adam"></li>
						<li data-target="#quote-carousel" data-slide-to="1"><img
							class="img-responsive"
							src="${pageContext.request.contextPath}/resources/images/user-def.png"
							alt="Alex"></li>
						<li data-target="#quote-carousel" data-slide-to="2"><img
							class="img-responsive"
							src="${pageContext.request.contextPath}/resources/images/user-def.png"
							alt="Salma"></li>
					</ol>

					<!-- Carousel Slides / Quotes -->
					<div class="carousel-inner text-center">

						<!-- Quote 1 -->
						<div class="item active">
							<blockquote>
								<div class="row">
									<div class="col-xs-12 ">

										<p><b>Tabiby</b> is functionally well designed, in particular it supports multiple
											locations and multiple users, and therefore is very useful for customer appointments!</p>
										<small>Adam Dived</small>
									</div>
								</div>
							</blockquote>
						</div>
						<!-- Quote 2 -->
						<div class="item">
							<blockquote>
								<div class="row">
									<div class="col-xs-12 ">

										<p>So simple, our clients love it.
											We tried a number of services that tried to do everything. Either my staff or my clients found every one of them too difficult to use.
											<b>Tabiby</b> is simple. It does one or two things VERY well and our clients actually prefer to book in this way. Can't beat the price either.
										</p>
										<small>Alex Smith</small>
									</div>
								</div>
							</blockquote>
						</div>
						<!-- Quote 3 -->
						<div class="item">
							<blockquote>
								<div class="row">
									<div class="col-xs-12 ">

										<p><b>Tabiby</b> is an online scheduling software that makes it easy for Clinics to manage complex
											schedules and book appointments. Team members work collaboratively from any computer or mobile
											device. Patients can book appointments online in real-time.
											</p>
										<small>Ammar Mohamed</small>
									</div>
								</div>
							</blockquote>
						</div>
					</div>

					<!-- Carousel Buttons Next/Prev -->
					<a class="left carousel-control" href="#quote-carousel"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left " aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#quote-carousel"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>


				</div>
			</div>
		</div>
	</div>
	</section>
	<!---->
	<!--<div class="container-fluid">-->


	<!--start statistics section-->
	<div class="statistic">
		<div class="inner-statistic text-center">
			<div class="container">
				<h1>Our Statistics</h1>

				<div class="in-st col-lg-3 col-md-4 col-sm-6 col-xs-12">
					<i class="fa fa-building fa-lg"></i>

					<h3>5318</h3>

					<p class="lead">More than 5000 Clinics</p>
				</div>

				<div class="in-st col-lg-3 col-md-4 col-sm-6 col-xs-12">

					<i class="fa fa-arrow-circle-o-down fa-lg"></i>

					<h3>10000</h3>

					<p class="lead">Daily Average Requests</p>
				</div>

				<div class="in-st col-lg-3 col-md-4 col-sm-6 col-xs-12">

					<i class="fa fa-calendar fa-lg"></i>

					<h3>1000</h3>

					<p class="lead">Daily Average Appointments</p>
				</div>

				<div class="in-st col-lg-3 col-md-4 col-sm-6 col-xs-12">

					<i class="fa fa-group fa-lg"></i>

					<h3>20,050</h3>

					<p class="lead">Active Tabiby Users</p>
				</div>

			</div>
		</div>
	</div>
	<!--end statistics section-->
	<!--start qutate section-->
	<div class="qutatee">
		<div class="container">
			<div class="text-center ">
				<i class=" qqq fa fa-quote-left fa-lg"></i>

				<p class="lead"><b>Tabiby</b> is an online scheduling software that makes it easy for Clinics to manage complex
					schedules and book appointments. Team members work collaboratively from any computer or mobile
					device. Patients can book appointments online in real-time."</p>


			</div>
		</div>
	</div>
	<!--end qutat section-->
	<!--start the fell section -->
	<div class="fell">

		<div class="inner-fell text-center">
			<div class="contact_filds container">
				<i class="fa fa-envelope-o fa-lg"></i>

				<h1>Tell us what you Need</h1>

				<p class="lead">For free to contact with us any time</p>


				<div class="row">
					<form action="error.html" role="form"
						onsubmit="return Main_user_form_Valid()">
						<div class="col-lg-6 col-xs-12">

							<div
								class="pos marg_buton10 form-group form-group-resize-new-blo">
								<input onblur="Main_userFirstNameVaildation()"
									onfocus="Main_RuserFirstNameVaildation()" id="Main__firstName"
									type="text" class="ii form-control " name="firstName"
									placeholder="Your First Name .. Without Space ">

								<div id="Main_right_mark_FirstName" class="inn hidden ">
									<i class="fa fa-check-circle" aria-hidden="true"></i>
								</div>
							</div>

							<div
								class="pos marg_buton10 form-group form-group-resize-new-blo">
								<input onblur="Main_userLastNameVaildation()"
									onfocus="Main_RuserLastNameVaildation()" id="Main__lastName"
									type="text" class="ii form-control " name="firstName"
									placeholder="Your Last Name .. Without Space ">

								<div id="Main_right_mark_LastName" class="inn hidden">
									<i class="fa fa-check-circle" aria-hidden="true"></i>
								</div>
							</div>

							<div
								class="pos marg_buton10 form-group form-group-resize-new-blo">
								<input onblur="Main_userEmailVaildation()"
									onfocus="Main_RuserEmailVaildation()" id="Main__email"
									type="text" class="ii form-control " name="firstName"
									placeholder="Your Email Address">

								<div id="Main_right_mark_Email" class="inn hidden">
									<i class="fa fa-check-circle" aria-hidden="true"></i>
								</div>
							</div>
						</div>

						<div class="col-lg-5 col-lg-offset-1 col-xs-12">
							<div
								class="pos marg_buton10 form-group form-group-resize-new-blo">

								<textarea onblur="Main_userMessageVaildation()"
									onfocus="Main_RuserMessageVaildation()" id="Main__message"
									type="text" class="form-control iii"
									placeholder="Your Message Content "></textarea>

								<div id="Main_right_mark_message" class="inn hidden">
									<i class="fa fa-check-circle" aria-hidden="true"></i>
								</div>
							</div>
							<div class="form-group">
								<button type="submit"
									class="btn btn-block btn-lg btn-primary ii ">
									<strong>Contact With Us</strong>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--end the fell section-->

	<!--  social media -->

	<div class="socialmedia">
		<div class="container">
			<div class="center-block text-center">
				<h3>Follow us in our social media network</h3>
			</div>
			<div class="row ">
				<div class=" col-xs-12  center-block text-center ">

					<ul class="socilui center-block text-center ">
						<li class="soi"><a href="#"><i style="color: #3B5998"
								class="fa fa-facebook-official fa-2x"></i></a> </li>
						<li class="soi"><a href="#"><i style="color: #1482BA"
								class="fa fa-linkedin fa-2x"></i> </a></li>
						<li class="soi"><a href="#"><i style="color: #55ACEE"
								class="fa fa-twitter-square fa-2x"></i></a></li>
						<li class="soi"><a href="#"><i style="color: #CD201F"
								class="fa fa-youtube-square fa-2x"></i></a></li>
						<li class="soi"><a href="#"><i style="color: #DF2A2A"
								class="fa fa-google-plus-square fa-2x"></i></a> </li>

					</ul>
				</div>

			</div>
		</div>
	</div>

	<!--end social media -->
	<!--footer-->
	<div class="copy-right">
		<div class="container">
			<div class="inner-copy-right center-block text-center ">
				<p class="lead">
					Copyright &copy; 2016 <span><strong> -
							Carthage -</strong></span> All rights reserved
				</p>
			</div>
		</div>
	</div>
	<!--end footer -->


	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-2.1.3.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap_1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/ct-navbar.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/mainJS.js"></script>


</body>
</html>
