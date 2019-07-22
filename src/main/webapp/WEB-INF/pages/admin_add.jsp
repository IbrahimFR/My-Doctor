<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Tabiby | Admin</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/sb-admin.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/plugins/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css"/>

	<%--<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDOXiMqu8y-nwhOWYB4885CyNowU5bezcU&callback=initMap"--%>
			<%--type="text/javascript"></script>--%>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>




</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/admin">Tabiby | Admin</a>
	</div>

	<!-- Top Menu Items -->
	<ul class="nav navbar-right top-nav">
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-building"></i>  clinics<b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li>
					<a href="${pageContext.request.contextPath}/admin/clinic/add"><i class="fa fa-fw fa-life-buoy"></i> add clinic</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/admin/clinic"><i class="fa fa-fw fa-building"></i> clinics</a>
			</ul>



		</li>
		<li class="dropdown">
			<a href="${pageContext.request.contextPath}/admin/user" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-users"></i>  users<b class="caret"></b></a>
			<ul class="dropdown-menu">

				<li>
					<a href="${pageContext.request.contextPath}/admin/user"><i class="fa fa-fw fa-users"></i> users</a>
				</li>
			</ul>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-adn"></i>  admins<b class="caret"></b></a>

			<ul class="dropdown-menu">
				<li>
					<a href="${pageContext.request.contextPath}/admin/add"><i class="fa fa-fw fa-user"></i> add admin</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/admin/all"><i class="fa fa-fw fa-users"></i> admins</a>
			</ul>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${clinicName} <b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li>
					<a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
				</li>
				<li>
					<a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
				</li>
				<li>
					<a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
				</li>
				<li class="divider"></li>
				<li>
					<a href="${pageContext.request.contextPath}/logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
				</li>
			</ul>
		</li>
	</ul>
	<!-- /.navbar-collapse -->
</nav>
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Admin <small> Add New Admin</small>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> Dashboard
							</li>
						</ol>
					</div>
				</div>

				<div class="alert alert-success">
					<strong>${wellMessage}</strong> ${addAdminMessage}
				</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										<i class="fa fa-long-arrow-right fa-fw"></i> Add Admin
									</h3>
								</div>
								<div class="panel-body">
									<form method="post"
										  action="${pageContext.request.contextPath}/admin/new">
									<div class="form-group">
										<label>Admin Name</label> <input class="form-control"
											id="_name" type="text" class="ii form-control " name="name" required>
									</div>
									<div class="form-group">
										<label>Admin Email</label> <input class="form-control"
											id="_email" type="email" class="ii form-control " name="email" required>
									</div>
										<div class="form-group">
											<label>Admin Mobile</label> <input class="form-control"
																			  id="_mobile" type="text" class="ii form-control " name="mobile" required>
										</div>
									<div class="form-group">
										<label>Admin Address</label> <input class="form-control"
											id="address" type="text" class="ii form-control "
											name="address" required>


									</div>
									<%--<div class="form-group">--%>
										<%--<label>Clinic Specialization</label> <input--%>
											<%--class="form-control" id="_specialization" type="text"--%>
											<%--class="ii form-control " name="specialization">--%>
									<%--</div>--%>
										<div class ="form-group">
										<label for="_type">Type</label>
										<select id="_type" class="form-control" name="type" >
											<option>Admin</option>
											<option>Sales</option>
											</select>
											</div>


									<div class="form-group">
										<label>Password</label> <input class="form-control"
											type="password" id="_password" class="ii form-control "
											name="password" required>





									<div class="form-group">
										<button id="hh" style="margin-top:5px"  type="submit" class="btn btn-success">Submit</button>

									</div>
									<input type="hidden" name="${_csrf.parameterName}"
															   value="${_csrf.token}" />

				     </form>
			     </div>
		</div>

	</div>
						<div class="col-lg-4">

						<div class="col-md-6" id="map_canvas" ></div></div>
						</div>










	<!-- /.row -->

	</div>
	<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script async defer src="https://maps.googleapis.com/maps/apH;li/js?key=AIzaSyDOXiMqu8y-nwhOWYB4885CyNowU5bezcU"
		type="text/javascript"></script>

</body>




</html>
