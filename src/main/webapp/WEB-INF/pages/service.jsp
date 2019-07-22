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

    <title>Tabiby</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

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
                <a class="navbar-brand" href="index.html">Tabiby</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>${clinicName}</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>${clinicName}</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>${clinicName}</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="#">Read All New Messages</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">View All</a>
                        </li>
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
           <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/appointment"><i class="fa fa-fw fa-calendar"></i> Appointments</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/reservation"><i class="fa fa-fw fa-tasks"></i> Reservations</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/service"><i class="fa fa-fw fa-check"></i> Services Manager</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/patient"><i class="fa fa-fw fa-desktop"></i> Patients History</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Extra Data<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">

                            <li >
                                <a href="${pageContext.request.contextPath}/doctor"> <i class="fa fa-fw fa-user-md"></i> Doctors</a>
                            </li>
                            <li >
                                <a href="${pageContext.request.contextPath}/medecine"><i class="fa fa-fw fa-meanpath"></i> Medicines List</a>
                            </li>
                            <li >
                                <a href="${pageContext.request.contextPath}/feedback"><i class="fa fa-fw fa-life-buoy"></i> Rating & Reviews</a>
                            </li>
                        </ul>
                    </li>
                   
                </ul>
            </div>
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Service Manager
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-check"></i> Service Manager
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="alert alert-success">
                    <strong>${wellServiceMessage}</strong> ${addServiceMessage}
                </div>
                <form action="${pageContext.request.contextPath}/service/add" method="post">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Add Service</h3>
                            </div>
                            <div class="panel-body">


                            <div class="form-group">
                                <label>Service Name</label>
                                <input class="form-control" name="name" id="_name"required>
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
                                        <option>Neurologists</option>
                                        <option>Neurosurgery</option>
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
                                <label>Service Descreption</label>
                                <textarea class="form-control" rows="3" name="service"id="_service"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Service Fees</label>
                                <input class="form-control" type="number" name="fees" id="_fees" required>

                                </div>
                                <div class ="form-group">
                                   <label for="_currency">Currency</label>
                                    <select id="_currency" class="form-control" name="currency" >
                                     <option>EUR</option>
                                    <option>USD</option>
                                    <option>LE</option>
                                    <option>DB</option>
                                    <option>LE</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                <label>Serving Hours</label>
                                <input class="form-control" type ="number" name="serviceHours" id="_serviceHours" required>
                                </div>

                                <div class="form-group">
                             <button type="submit" class="btn btn-default btn-primary" >Submit</button>
                                    </div>
                               <input type="hidden" name="${_csrf.parameterName}"
                                           value="${_csrf.token}" />

                </form>
                               
                            </div>
                        </div>

                    </div>
                    <div class="col-lg-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-money fa-fw"></i>Services</h3>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                             <th>Name</th>
                                                <th>Descreption</th>
                                                <th>Fees</th>
                                                <th>Currency</th>
                                                <th>Serving Hours</th>
                                                <th>specialization</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${service}" var="services">
                                            <tr>
                                                <td >
                                               <c:out value="${services.name}" /> </td>
                                                <td><c:out value="${services.service}" /></td>
                                                <td><c:out value="${services.fees}" /></td>
                                                <td><c:out value="${services.currency}" /></td>
                                                <td><c:out value="${services.serviceHours}" /></td>
                                                <td><c:out value="${services.specialization}" /></td>

                                                <td>
                                                    <form action="${pageContext.request.contextPath}/service/delete" method="post">

                                                        <button type="submit" class="btn btn-xs btn-danger">delete</button>
                                                        <input  type ="hidden" class="form-control"   value="<c:out value="${services.serviceId}" />"  name="serviceId" id="_serviceId"/>
                                                        <input type="hidden" name="${_csrf.parameterName}"
                                                               value="${_csrf.token}" />
                                                    </form>
                                                </td>

                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                                <div class="text-right">
                                    <a href="#">View All Services <i class="fa fa-arrow-circle-right"></i></a>
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
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>

</html>
