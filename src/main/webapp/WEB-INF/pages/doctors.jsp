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

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris.css" rel="stylesheet">

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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>${clinicName}<b class="caret"></b></a>
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
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Doctors<small>  (Add & View)</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-user-o"></i> Doctors
                            </li>
                        </ol>
                    </div>
                </div>
               
                <!-- /.row -->
                <!-- /.row -->

              <!--   <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i> Area Chart</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-area-chart"></div>
                            </div>
                        </div>
                    </div>
                </div> -->
                <!-- /.row -->
                <div class="alert alert-success">
                    <strong>${wellDoctorMessage}</strong> ${addDoctorMessage}
                </div>

                <div class="row">
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i> Add Doctor</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
                                <form action="${pageContext.request.contextPath}/doctor/add" method="post">
                                <div
                                        class="pos marg_buton10 form-group form-group-resize-new-blo">
                                    <label>Doctor Name</label>
                                    <input onblur="NameVaildation()"
                                           onfocus="RuserNameVaildation()" id="_doctorName"
                                           type="text" class="ii form-control " name="name"
                                           required>

                                    <div id="right_mark_doctorName" class="inn hidden">
                                        <i class="fa fa-check-circle" aria-hidden="true"></i>
                                    </div>
                                </div>
                                <div
                                        class="pos marg_buton10 form-group form-group-resize-new-blo">
                                    <label>Doctor Specialization</label>
                                    <input onblur="specializationVaildation()"
                                           onfocus="RuserspecializationVaildation()" id="_specialization"
                                           type="text" class="ii form-control " name="specialization"
                                           required>

                                    <div id="right_mark_specialization" class="inn hidden">
                                        <i class="fa fa-check-circle" aria-hidden="true"></i>
                                    </div>
                                </div>
                                <div
                                        class="pos marg_buton10 form-group form-group-resize-new-blo">
                                    <label>Doctor Email</label>
                                    <input onblur="EmailVaildation"
                                           onfocus="RuserEmailVaildation" id="_email"
                                           type="email" class="ii form-control " name="email"
                                           required>

                                    <div id="right_mark_email" class="inn hidden">
                                        <i class="fa fa-check-circle" aria-hidden="true"></i>
                                    </div>
                                </div>

                               <div class="form-group">
                                <label>Doctor Mobile</label>
                                <input class="form-control"
                                id="_mobile" type="text" class="ii form-control " name="mobile" required>
                                </div>
                               <div class="form-group">
                                <label>Descreption</label>
                                <textarea class="form-control" rows="3"
                                id="_descreprion" type="text" class="ii form-control " name="descreprion" ></textarea>
                                </div>
                            
                           
                            <div class="form-group">
                                <button id="hh" type="submit" class="btn btn-default">Save</button>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"
                                           value="${_csrf.token}" />
                        </form>

                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-file fa-fw"></i>Doctos in clinic</h3>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>Doctor Name </th>
                                                <th>Clinic Name </th>
                                                <th>Doctor Specialization</th>
                                                <th>Doctor Email</th>
                                                <th>Doctor Mobile</th>
                                                <th>Descreption</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${doctors}" var="doctor">
                                            <tr>
                                                <td><c:out value="${doctor.name}" /></td>
                                                <td><c:out value="${doctor.specialization}" /></td>
                                                <td><c:out value="${doctor.email}" /></td>
                                                <td><c:out value="${doctor.mobile}" /></td>
                                                <td><c:out value="${doctor.descreprion}" /></td>
                                                <td>

                                                    <form action="${pageContext.request.contextPath}/doctor/delete" method="post">
                                                        <input  type ="hidden" class="form-control"   value="<c:out value="${doctor.id}" />"  name="id" id="_id"/>
                                                        <button type="submit" class="btn btn-xs btn-danger">delete</button>
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
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/resources/js/createJS.js"></script>


</body>

</html>
