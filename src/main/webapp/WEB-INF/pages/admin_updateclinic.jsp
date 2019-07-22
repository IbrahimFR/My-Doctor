<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
	<%--<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>--%>
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
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>-->



    <![endif]-->
	<%--<script type="text/javascript">--%>
		<%--var geocoder;--%>
		<%--var map;--%>
		<%--function initialize() {--%>
			<%--geocoder = new google.maps.Geocoder();--%>
			<%--var latlng = new google.maps.LatLng(26.2285,50.5860);--%>
			<%--var myOptions = {--%>
				<%--zoom: 10,--%>
				<%--center: latlng,--%>
				<%--mapTypeId: google.maps.MapTypeId.ROADMAP--%>
			<%--}--%>

			<%--map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);--%>
		<%--}--%>

		<%--function codeAddress() {--%>
			<%--var address = document.getElementById("address").value;--%>
			<%--geocoder.geocode( { 'address': address}, function(results, status) {--%>
				<%--if (status == google.maps.GeocoderStatus.OK) {--%>
					<%--map.setCenter(results[0].geometry.location);--%>

					<%--var marker = new google.maps.Marker({--%>
						<%--map: map,--%>
						<%--draggable: true,--%>
						<%--position: results[0].geometry.location--%>

					<%--});--%>
					<%--// Javascript//--%>
					<%--google.maps.event.addListener(marker, 'dragend', function(evt){--%>
						<%--document.getElementById('current').innerHTML = '<p>Marker dropped: Current Lat: ' + evt.latLng.lat().toFixed(3) + ' Current Lng: ' + evt.latLng.lng().toFixed(3) + '</p>';--%>
					<%--});--%>

					<%--google.maps.event.addListener(marker, 'dragstart', function(evt){--%>
						<%--document.getElementById('current').innerHTML = '<p>Currently dragging marker...</p>';--%>
					<%--});--%>

					<%--google.maps.event.addListener(marker, 'dragend', function(evt){--%>
						<%--document.getElementById('info').innerHTML = '<p>Address:  ' + results[0].formatted_address + '</p>';--%>
					<%--});--%>

					<%--google.maps.event.addListener(marker, 'dragstart', function(evt){--%>
						<%--document.getElementById('info').innerHTML = '<p>Currently dragging marker...</p>';--%>
					<%--});--%>



					<%--map.setCenter(marker.position);--%>
					<%--marker.setMap(map);--%>

				<%--} else {--%>
					<%--alert("Geocode was not successful for the following reason: " + status);--%>
				<%--}--%>
			<%--});--%>
		<%--}--%>
	<%--</script>--%>
	<style type="text/css">
		#map {
			height: 600px;
			width: 500px;
		}



	</style>

</head>

<body onLoad="initMap()">
<script>
	function initMap() {
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom: 10,
			center: {lat: 26.0667, lng: 50.5860}
		});
		var geocoder = new google.maps.Geocoder();

		document.getElementById('submit').addEventListener('click', function() {
			geocodeAddress(geocoder, map);
		});
	}

	function geocodeAddress(geocoder, resultsMap) {
		var lat = document.getElementById('_Lat').value;
		var lang = document.getElementById('_Lang').value;
		geocoder.geocode({'address': address}, function(results, status) {
			if (status === 'OK') {
				resultsMap.setCenter(results[0].geometry.location);
				lat=results[0].geometry.location.lat();
				lang
				var marker = new google.maps.Marker({
					map: resultsMap,
					position: results[0].geometry.location
				});
			} else {
				alert('Geocode was not successful for the following reason: ' + status);
			}
		});
	}
</script>


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
							Clinics<small> Add New Clinic</small>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> Dashboard
							</li>
						</ol>
					</div>
				</div>

				<div class="alert alert-success">
					<strong>${wellMessage}</strong> ${updateClinicMessage}
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
										  action="${pageContext.request.contextPath}/admin/updateclinic">

									<div class="form-group">
										<label>User Name</label> <input class="form-control"  value="${clinicinfos.name}"
											id="_name" type="text" class="ii form-control " name="name" disabled>
										<input class="form-control"  value="${clinicinfos.id}"
											   id="_id" type="hidden" class="ii form-control " name="id" >
									</div>
										<div class="form-group">
											<label>Title</label> <input class="form-control" value="${clinicinfos.title}"
											id="_title" type="text" class="ii form-control " name="title" required>
										</div>
									<div class="form-group">
										<label>Email</label> <input class="form-control" value="${clinicinfos.email}"
											id="_email" type="text" class="ii form-control " name="email"required>
									</div>
										<div class="form-group">
											<label>Mobile</label> <input class="form-control" value="${clinicinfos.mobile}"
																			   id="_mobile" type="text" class="ii form-control " name="mobile"required>
										</div>
										<div class="form-group">
										<label>City</label><> <input class="form-control" value="${clinicinfos.address}"
											id="address" type="text" class="ii form-control "
											name="address"required>
										<!-- <input id="submit" type="button" value="Get Address">-->
										<%--<input id="submit" onclick="getLocation()" type="button" value="Get Address">--%>
											<input id="submit" type="button" onclick="getLocation()" value="Get Current Location" ></input>
											<div class="help-block">Click on Button to Get Your Current Location on Map</div>

										</div>
									</row>
											<input type="hidden" id="_Lat" name="Lat" value="${clinicinfos.lat}" />
											<input type="hidden" id="_Lang" name="Lang" value="${clinicinfos.lang}" />

									<%--<div class="form-group">--%>
										<%--<label>Clinic Specialization</label> <input--%>
											<%--class="form-control" id="_specialization" type="text"--%>
											<%--class="ii form-control " name="specialization">--%>
									<%--</div>--%>
										<div class ="form-group">
										<label for="_type">Type</label>
										<select id="_type" class="form-control" name="type" value="${clinicinfos.type}" >
											<option>Clinic</option>
											<option>Hospital</option>
											<option>Medical Lab</option>
											<option>Pharmacy</option>
											</select>
											</div>

										<div class ="form-group">
											<label for="_specialization">Specialization</label>
											<select id="_specialization" class="form-control" name="specialization" value="${clinicinfos.specialization}">

												<option>Otolaryngology(ENT)-جراحة انف و أذن وحنجرة</option>
												<option>Orthopedics-جراحة عظام</option>
												<option>Vascular-جراحة أوعية دموية</option>
												<option>Cardiothoracic-جراحة القلب والصدر</option>
												<option>Reconstructive-جراحات بنائية</option>
												<option>Oncology-جراحة الأورام</option>
												<option>Neurosurgery-جراحة الأعصاب</option>
												<option>Urology surgery-جراحة المسالك البولية</option>
												<option>Urology surgery-جراحة التجميل والحروق</option>
												<option>General surgery-جراحة عامة</option>
												<option>Pediatric surgery-جراحة الأطفال</option>
												<option>Anesthesiology and Recovery-التخدير والإنعاش</option>
												<option>Thoracic surgery-جراحة الصدر</option>
												<option>Gastroenterology-باطنه جهاز هضمي ومناظير</option>
												<option>Endocrinology-باطنه غدد صماء وسكر</option>
												<option>Oncology-طب الأورام</option>
												<option>Hematology-أمراض الدم</option>
												<option>Cardiology-القلب والأوعية الدموية</option>
												<option>Rehabilitation Rheumatology-إعادة التأهيل (العلاج الطبيعي)</option>
												<option>Rehabilitation Rheumatology-التهاب المفاصل</option>
												<option>Pulmonology-الصدرية</option>
												<option>Allergy and immunology-الحساسية والمناعة</option>
												<option>Sports medicine-الطب الرياضي</option>
												<option>Family medicine-طب العائلة</option>
												<option>Industrial medicine-الأمراض المهنية وطب الصناعات</option>
												<option>Emergency medicine-طب الطوارئ</option>
												<option>Dermatology-جلدية</option>
												<option>Obstetrics and Gynecology-أمراض النساء والتوليد</option>
												<option>Radiology-الأشعة</option>
												<option>Preventative medicine-الطب الوقائي</option>
												<option>Ophthalmology-طب العيون</option>
												<option>Nephrology-أمراض باطنه وكلى</option>
												<option>Psychiatry-علم النفس (الأمراض النفسية)</option>
												<option>Speech-Language-علم النفس (الأمراض النفسية)</option>
												<option>Dentistry-طب الأسنان</option>
												<option>Pediatrics- طب الأطفال</option>
												<option>Uroandrology-طب الأجهزة التناسلية</option>
											</select>
										</div>
									<div class="form-group">
										<label>Password</label> <input class="form-control"
											type="password" id="_password" class="ii form-control "
											name="password" required>
									</div>
										<div class="form-group">
											<label> Clinic Description</label>
											<input name="descreption" value="${clinicinfos.descreption}" class="form-control" rows="1"/>
										</div>

									<%--<div class="form-group">--%>
										<%--<label>Confirm Password</label> <input class="form-control"--%>
											<%--type="password">--%>
									<%--</div>--%>

									<%--<div class="form-group input-group">--%>
										<%--<span class="input-group-addon">Facebook.com/</span> <input--%>
											<%--class="form-control" id="_fbPage" type="text"--%>
											<%--class="ii form-control " name="fbPage">--%>
									<%--</div>--%>
									<%--<div class="form-group input-group">--%>
										<%--<span class="input-group-addon">Twitter.com/</span> <input--%>
											<%--class="form-control" id="_twPage" type="text"--%>
											<%--class="ii form-control " name="twPage">--%>
									<%--</div>--%>



									<div class="form-group">
										<button id="hh" type="submit" class="btn btn-success">Update Clinic</button>

									</div>
									<input type="hidden" name="${_csrf.parameterName}"
															   value="${_csrf.token}" />

				     </form>
									<form action="${pageContext.request.contextPath}/admin/addlogo?${_csrf.parameterName}=${_csrf.token}"  method="post" enctype="multipart/form-data">

										<div class="col-sm-4">
											<label>Logo</label>
											<input type="file" name="file" id="file"/>
										</div>
										<input class="form-control"  value="${clinicinfos.id}"
											   id="_id" type="hidden" class="ii form-control " name="id" >
										<div class="form-group">
										<button type="submit" class="btn btn-xs btn-success">Update Logo</button>
										</div>
									</form>
			     </div>
		</div>

	</div>



							<div class="col-lg-6" id="map"> </div>



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
	<%--<script async defer src="https://maps.googleapis.com/maps/apH;li/js?key=AIzaSyDOXiMqu8y-nwhOWYB4885CyNowU5bezcU"--%>
		<%--type="text/javascript"></script>--%>
<%--<script>--%>


	<%--function getLocation() {--%>
		<%--if (navigator.geolocation) {--%>
			<%--alert("test");--%>
			<%--navigator.geolocation.getCurrentPosition(showPosition);--%>
		<%--} else {--%>
			<%--x.innerHTML = "Geolocation is not supported by this browser.";--%>
			<%--alert("Geolocation is not supported by this browser.");--%>
		<%--}--%>
	<%--}--%>

	<%--function showPosition(position) {--%>
		<%--alert(position.coords.latitude);--%>
		<%--alert(position.coords.longitude);--%>
		<%--document.getElementById('_Lat').value = position.coords.latitude;--%>
		<%--document.getElementById('_Lang').value =  position.coords.longitude;--%>
	<%--}--%>
<%--</script>--%>
<script>




//	var x=document.getElementById("demo");
	function getLocation()
	{
		if (navigator.geolocation)
		{
			navigator.geolocation.getCurrentPosition(showPosition,showError);
		}
//		else{x.innerHTML="Geolocation is not supported by this browser.";}
	}

	function showPosition(position)
	{

		document.getElementById('_Lat').value = position.coords.latitude;
		document.getElementById('_Lang').value =  position.coords.longitude;
		lat=position.coords.latitude;
		lon=position.coords.longitude;
		latlon=new google.maps.LatLng(lat, lon)
		mapholder=document.getElementById('map')
//		mapholder.style.height='250px';
//		mapholder.style.width='100%';

		var myOptions={
			center:latlon,zoom:14,
			mapTypeId:google.maps.MapTypeId.ROADMAP,
			mapTypeControl:false,
			navigationControlOptions:{style:google.maps.NavigationControlStyle.SMALL}
		};
		var map=new google.maps.Map(document.getElementById("map"),myOptions);
		var marker=new google.maps.Marker({position:latlon,map:map,title:"You are here!"});
	}

	function showError(error)
	{
		switch(error.code)
		{
			case error.PERMISSION_DENIED:
				alert("User denied the request for Geolocation.");
				break;
			case error.POSITION_UNAVAILABLE:
				alert("Location information is unavailable.");
				break;
			case error.TIMEOUT:
				alert("The request to get user location timed out.");
				break;
			case error.UNKNOWN_ERROR:
				alert("An unknown error occurred.");
				break;
		}
	}

</script>
<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDOXiMqu8y-nwhOWYB4885CyNowU5bezcU&callback=initMap">
</script>

</body>




</html>
