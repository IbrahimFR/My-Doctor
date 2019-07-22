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
	<%--<link href="http://code.google.com/apis/maps/documentation/javascript/examples/default.css" rel="stylesheet" type="text/css" />--%>
	<%--<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDOXiMqu8y-nwhOWYB4885CyNowU5bezcU"--%>
			<%--type="text/javascript"></script>--%>
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

		<style type="text/css">
			    #map_canvas {
				margin: 0;
				width: 100%;
				height: 100%;
			}
		</style>
    <![endif]-->


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
							Users<small> View Users</small>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> Dashboard
							</li>
						</ol>
					</div>
				</div>




	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-file fa-fw"></i>Users
					</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>User Name</th>
									<th>Create At</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>SSID</th>
									<th>Related Reservations</th>
									<th>Related Appointments</th>
									<th>Related Clinics</th>
									<th>Activated</th>
									<th>Action</th>
																	

								</tr>
							</thead>
							<tbody>
									<c:forEach items="${users}" var="user">
										<tr>
											<td><c:out value="${user.username}" /></td>
											<td><c:out value="${user.createdAt}" /></td>
											<td><c:out value="${user.email}" /></td>
											<td><c:out value="${user.mobile}" /></td>


											<td>
												<form action="${pageContext.request.contextPath}/admin/user/update" method="post">
													<input type="hidden"  class="form-control"   value="<c:out value="${user.id}" />"  name="id" id="_id"/>
													<input type="textarea" style="margin-bottom: 3px" class="form-control" value="<c:out value="${user.ssid}" />" name="ssid" placeholder="write SSID" />
													<button  type="submit" style="margin-top: 3px "class="btn btn-xs btn-warning">update</button>
													<input type="hidden" name="${_csrf.parameterName}"
														   value="${_csrf.token}" />
												</form>


											</td>

										<td>
											<form action="${pageContext.request.contextPath}/admin/user/reservation" method="post">
												<input  type ="hidden" class="form-control"   value="<c:out value="${user.id}" />"  name="id" id="_id"/>
												<button style="margin-top:2px" type="submit" class="btn btn-xs btn-default">Show</button>
												<input type="hidden" name="${_csrf.parameterName}"
													   value="${_csrf.token}" />
											</form>

										</td>
										<td>
											<form action="${pageContext.request.contextPath}/admin/user/appointment" method="post">
												<input  type ="hidden" class="form-control"   value="<c:out value="${user.id}" />"  name="id" id="_id"/>
												<button style="margin-top:2px" type="submit" class="btn btn-xs btn-default">Show</button>
												<input type="hidden" name="${_csrf.parameterName}"
													   value="${_csrf.token}" />
											</form>
										</td>
											<td>
												<form action="${pageContext.request.contextPath}/admin/user/clinic" method="post">
													<input  type ="hidden" class="form-control"   value="<c:out value="${user.id}" />"  name="id" id="_id"/>
													<button style="margin-top:2px" type="submit" class="btn btn-xs btn-default">Show</button>
													<input type="hidden" name="${_csrf.parameterName}"
														   value="${_csrf.token}" />
												</form>
											</td>								
											<td><c:out value="${user.active}" /></td>

											<td>

												<form action="${pageContext.request.contextPath}/admin/user/active" method="post">
													<input  type ="hidden" class="form-control"   value="<c:out value="${user.id}" />"  name="id" id="_id"/>
													<button type="submit" class="btn btn-xs btn-success">Activate</button>
													<input type="hidden" name="${_csrf.parameterName}"
														   value="${_csrf.token}" />
												</form>
												<form action="${pageContext.request.contextPath}/admin/user/deactive" method="post">
													<input  type ="hidden" class="form-control"   value="<c:out value="${user.id}" />"  name="id" id="_id"/>
													<button style="margin-top:2px" type="submit" class="btn btn-xs btn-danger">Deactivate</button>
													<input type="hidden" name="${_csrf.parameterName}"
														   value="${_csrf.token}" />
												</form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
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
