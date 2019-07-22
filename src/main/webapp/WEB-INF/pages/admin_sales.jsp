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

<title>Tabiby | Sales</title>
	<link href="http://code.google.com/apis/maps/documentation/javascript/examples/default.css" rel="stylesheet" type="text/css" />
	<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDOXiMqu8y-nwhOWYB4885CyNowU5bezcU"
			type="text/javascript"></script>
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
	<script type="text/javascript">
		var geocoder;
		var map;
		function initialize() {
			geocoder = new google.maps.Geocoder();
			var latlng = new google.maps.LatLng(26.2285,50.5860);
			var myOptions = {
				zoom: 10,
				center: latlng,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			}

			map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
		}

		function codeAddress() {
			var address = document.getElementById("address").value;
			geocoder.geocode( { 'address': address}, function(results, status) {
				if (status == google.maps.GeocoderStatus.OK) {
					map.setCenter(results[0].geometry.location);

					var marker = new google.maps.Marker({
						map: map,
						draggable: true,
						position: results[0].geometry.location

					});
					// Javascript//
					google.maps.event.addListener(marker, 'dragend', function(evt){
						document.getElementById('current').innerHTML = '<p>Marker dropped: Current Lat: ' + evt.latLng.lat().toFixed(3) + ' Current Lng: ' + evt.latLng.lng().toFixed(3) + '</p>';
					});

					google.maps.event.addListener(marker, 'dragstart', function(evt){
						document.getElementById('current').innerHTML = '<p>Currently dragging marker...</p>';
					});

					google.maps.event.addListener(marker, 'dragend', function(evt){
						document.getElementById('info').innerHTML = '<p>Address:  ' + results[0].formatted_address + '</p>';
					});

					google.maps.event.addListener(marker, 'dragstart', function(evt){
						document.getElementById('info').innerHTML = '<p>Currently dragging marker...</p>';
					});



					map.setCenter(marker.position);
					marker.setMap(map);

				} else {
					alert("Geocode was not successful for the following reason: " + status);
				}
			});
		}
	</script>

</head>

<body onLoad="initialize()">

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
							Clinics<small> Add New Clinic</small>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> Dashboard
							</li>
						</ol>
					</div>
				</div>

				<div class="alert alert-success">
					<strong>${wellMessage}</strong> ${addClinicMessage}
				</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										<i class="fa fa-long-arrow-right fa-fw"></i> Add Clinic
									</h3>
								</div>
								<div class="panel-body">
									<form method="post"
										  action="${pageContext.request.contextPath}/register">
									<div class="form-group">
										<label>Clinic Name</label> <input class="form-control"
											id="_name" type="text" class="ii form-control " name="name">
									</div>
									<div class="form-group">
										<label>Clinic Email</label> <input class="form-control"
											id="_email" type="text" class="ii form-control " name="email">
									</div>
										<div class="form-group">
											<label>Admin Mobile</label> <input class="form-control"
																			   id="_mobile" type="text" class="ii form-control " name="mobile">
										</div>
										<div class="form-group">
										<label>Clinic Address</label><row> <input class="form-control"
											id="address" type="text" class="ii form-control "
											name="address">
										<input type="button" value="Get Address" onClick="codeAddress()">
									</row>
									</div>
									<%--<div class="form-group">--%>
										<%--<label>Clinic Specialization</label> <input--%>
											<%--class="form-control" id="_specialization" type="text"--%>
											<%--class="ii form-control " name="specialization">--%>
									<%--</div>--%>
										<div class ="form-group">
										<label for="_type">Type</label>
										<select id="_type" class="form-control" name="type" >
											<option>Clinic</option>
											<option>Hospital</option>
											<option>Medical Lab</option>
											<option>Pharmacy</option>
											</select>
											</div>

										<div class ="form-group">
											<label for="_specialization">Specialization</label>
											<select id="_specialization" class="form-control" name="specialization" >

												<option>Otolaryngology (ENT)</option>
												<option>Orthopedics</option>
												<option>Vascular</option>
												<option>Cardiothoracic</option>
												<option>Reconstructive</option>
												<option>Oncology</option>
												<option>Neurosurgery</option>
												<option>Urology surgery</option>
												<option>Neurologists</option>
												<option>General surgery</option>
												<option>Pediatric surgery</option>
												<option>Anesthesiology and Recovery</option>
												<option>Gastroenterology</option>
												<option>Endocrinology</option>
												<option>Oncology</option>
												<option>Hematology</option>
												<option>Cardiology</option>
												<option>Rehabilitation Rheumatology</option>
												<option>Allergy and immunologyy</option>
												<option>Sports medicine</option>
												<option>Family medicine</option>
												<option>Industrial medicine</option>
												<option>Emergency medicine</option>
												<option>Dermatology</option>
												<option>Obstetrics and Gynecology</option>
												<option>Radiology</option>
												<option>Preventative medicine</option>
												<option>Ophthalmology</option>
												<option>Nephrology</option>
												<option>Psychiatry</option>
												<option>Speech-Language</option>
												<option>Ophthalmology</option>
												<option>Ophthalmology</option>
											</select>
										</div>
									<div class="form-group">
										<label>Password</label> <input class="form-control"
											type="password" id="_password" class="ii form-control "
											name="password">
									</div>
									<div class="form-group">
										<label>Confirm Password</label> <input class="form-control"
											type="password">
									</div>

									<div class="form-group input-group">
										<span class="input-group-addon">Facebook.com/</span> <input
											class="form-control" id="_fbPage" type="text"
											class="ii form-control " name="fbPage">
									</div>
									<div class="form-group input-group">
										<span class="input-group-addon">Twitter.com/</span> <input
											class="form-control" id="_twPage" type="text"
											class="ii form-control " name="twPage">
									</div>



									<div class="form-group">
										<button id="hh" type="submit" class="btn btn-default">Submit</button>

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
