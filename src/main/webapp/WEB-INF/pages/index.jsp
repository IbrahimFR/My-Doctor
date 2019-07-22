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
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
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
                                <a href="${pageContext.request.contextPath}/doctor"> <i class="fa fa-fw fa-user-md"></i>  Doctors</a>
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
                            Dashboard <small>Statistics Overview</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Dashboard
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="alert alert-info alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <i class="fa fa-info-circle"></i>  <strong>Welcome </strong> <a> ${clinicName} at Tabiby Dashboard</a>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-comments fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${reviewCount}</div>
                                        <div> Reviews</div>
                                    </div>
                                </div>
                            </div>
                            <a href="${pageContext.request.contextPath}/feedback">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-calendar fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${appointmentCount}</div>
                                        <div> Appointment!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="${pageContext.request.contextPath}/appointment">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${reservationCount}</div>
                                        <div>Reservation!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="${pageContext.request.contextPath}/reservation">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-support fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${rateCount}</div>
                                        <div>Rate</div>
                                    </div>
                                </div>
                            </div>
                            <a href="${pageContext.request.contextPath}/feedback">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
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

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i> Clinic Data</h3>
                            </div>
                            <div class="panel-body">
                           <form action="${pageContext.request.contextPath}/update"    method="post">

                                <div class="form-group">
                                <label> Clinic Description</label>
                                    <input name="descreption" value="${descreption}" class="form-control" rows="1"/>
                               </div>
                               <div class="row" >
                                <div class="form-group">
                                 <div class="col-sm-4">
                                <label>Price</label>
                                <input name="price" value="${price}" type="number" min="0" class="form-control" />
                                </div>
                             </div>
                             </div>
                               <div class="row" >
                                   <div class="form-group">
                                       <div class="col-sm-4">
                                           <label>Mobile</label>
                                           <input name="mobile" value="${mobile}" type="number" min="0" class="form-control" />
                                       </div>
                                   </div>
                               </div>

                                <div class="form-group">
                                    <label> Clinic Appointments</label>
                                    <div class="row" >

                                        <div class="col-sm-2">
                                            <label >(Sat)</label>
                                            <label >AM</label>
                                            <input id="SatFrom" value="${satfrom}" class="form-control input-group-sm reg_name" type="text"  name="satfrom"  placeholder=" 00:00">
                                        </div>
                                        <div class="col-sm-2">
                                           <label>PM</label>
                                            <input id="SatTo" value="${satto}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="Satto" title="Enter Time" placeholder=" 00:00">
                                        </div>


                                        <div class="col-sm-2">
                                            <label >(Sun)</label>
                                            <label >AM</label>
                                            <input id="SunFrom"value="${sunfrom}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="sunfrom"  placeholder=" 00:00">
                                        </div>
                                        <div class="col-sm-2">
                                            <label>PM</label>
                                            <input id="SunTo" value="${sunto}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="sunto" title="Enter Time" placeholder=" 00:00">
                                        </div>

                                    </div>
                                    <div class="row" >

                                        <div class="col-sm-2">
                                            <label >(Mon)</label>
                                            <label >AM</label>
                                            <input id="MonFrom" value="${monfrom}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="monfrom"  placeholder=" 00:00">
                                        </div>
                                        <div class="col-sm-2">
                                            <label>PM</label>
                                            <input id="MonTo" value="${monto}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="monto" title="Enter Time" placeholder=" 00:00">
                                        </div>


                                        <div class="col-sm-2">
                                            <label >(Tu)</label>
                                            <label >AM</label>
                                            <input id="TuFrom" value="${tufrom}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="tufrom"  placeholder=" 00:00">
                                        </div>
                                        <div class="col-sm-2">
                                            <label>PM</label>
                                            <input id="TuTo" value="${tuto}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="tuto" title="Enter Time" placeholder=" 00:00">
                                        </div>

                                    </div>
                                    <div class="row" >

                                        <div class="col-sm-2">
                                            <label >(Wed)</label>
                                            <label >AM</label>
                                            <input id="WeFrom"  value="${wefrom}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="wefrom"  placeholder=" 00:00">
                                        </div>
                                        <div class="col-sm-2">
                                            <label>PM</label>
                                            <input id="WeTo"  value="${weto}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="weto" title="Enter Time" placeholder=" 00:00">
                                        </div>


                                        <div class="col-sm-2">
                                            <label >(Th)</label>
                                            <label >AM</label>
                                            <input id="ThFrom" value="${thfrom}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="thfrom"  placeholder=" 00:00">
                                        </div>
                                        <div class="col-sm-2">
                                            <label>PM</label>
                                            <input id="ThTo" value="${thto}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="thto" title="Enter Time" placeholder=" 00:00">
                                        </div>
                                       </div>
                                    <div class="row" >
                                    <div class="col-sm-2">
                                            <label >(Fr)</label>
                                            <label >AM</label>
                                            <input id="FrFrom" value="${frfrom}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="frfrom"  placeholder=" 00:00">
                                        </div>
                                        <div class="col-sm-2">
                                            <label>PM</label>
                                            <input id="FrTo" value="${frto}" class="form-control input-group-sm reg_name" type="text" min="0"  max= "23" name="frto" title="Enter Time" placeholder=" 00:00">
                                        </div>

                                    </div>

                                </div>

                              <%--<div class="form-group">--%>
                                <%--<label>Upload Logo</label>--%>
                                <%--<input type="file">--%>
                            <%--</div>--%>
                               <button type="submit" class="btn btn-xs btn-warning">Update Data</button>
                               <input type="hidden" name="${_csrf.parameterName}"
                                      value="${_csrf.token}" />

                            </form>




                            </div>
                        </div>
                    </div>

                    </div>
                <div class="row">
                        <form action="${pageContext.request.contextPath}/addlogo?${_csrf.parameterName}=${_csrf.token}"  method="post" enctype="multipart/form-data">

                        <div class="col-sm-4">
                            <label>Logo</label>
                            <input type="file" name="file" id="file"/>
                        </div>
                        <button type="submit" class="btn btn-xs btn-warning">Update Logo</button>
                    </form>

                </div>


                    </div>
                   

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
