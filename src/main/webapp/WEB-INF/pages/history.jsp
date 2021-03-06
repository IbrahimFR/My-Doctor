<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org">

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

    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.42/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
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
                                    <h5 class="media-heading"><strong>Ibrahim Fouad</strong>
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
                        <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
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
                            Patient History | ${userss.username}
                        </h1>

                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-check"></i> Patient History
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->



                    </div>
					<div class="row">
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Add History</h3>
                            </div>
                            <div class="panel-body">
                               <form  action="${pageContext.request.contextPath}/patient/add" method="post" role="form" id="main">

                            <div class="form-group">
						   <label>Visit Num</label>
                                <input class="form-control" type="number" name="visitNum" required/>
						   </div>
                                   <input class="form-control"  value="${userss.username}"
                                   id="_id" type="hidden" class="ii form-control " name="userName" >
						    <div class="form-group">
					       <label>Visit Date</label>
                                <input class="form-control" name="visitDate" type="datetime-local" required/>
						   </div>
						   
						<div class="form-group">
						<textarea class="form-control"  rows="1" placeholder="Describe briefly patient symptoms" name="symtops" required ></textarea>
						</div>
						<%--<div class="form-group">--%>
						<%--<label>Does patient now or have he ever had:</label>--%>
						<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Diabetes</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">High blood pressure</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">High cholesterol</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Hypothyroidism</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Goiter</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Pneumonia</label>--%>
<%--</div><div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Heart murmur</label>--%>
<%--</div><div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Pulmonary embolism</label>--%>
<%--</div><div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Asthma</label>--%>
<%--</div><div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Emphysema</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Stroke</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Anemia</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Colitis</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Stomach</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Cataracts</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Kidney disease</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Kidney stone</label>--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
  <%--<label><input type="checkbox" value="">Heart problems</label>--%>
<%--</div>--%>
						<%--</div>--%>
						<%--<div class="form-group">--%>
						   <%--<label>Does patient take Drugs or  AlCohol ?</label>--%>
                               <%--<label><input type="checkbox" value="">Yes</label>--%>
						   <%--</div>--%>
						   <div class="form-group">
						    <label for="skill" class="col-sm-3 control-label">Assign medicines to Patient</label>
                            <div class="col-sm-9">
                                <select id="skill" class="form-control multiselect " multiple="multiple"  name="activitiesdrop">
                                <c:forEach items="${MedecineList}" var="medicines">
                                    <option><c:out value="${medicines.medecineName}" /> </option>

                                    </c:forEach>
                                </select>
                            </div>
                        </div>
						<div class="form-group">
						<label>Comment</label>
						<textarea class="form-control"  rows="2" placeholder="Write Comment" name="comment"></textarea>
						</div>
                                   <div class="form-group">
                                   <button type="submit" class="btn btn-group-lg btn-success">add visit</button>
                                   <input type="hidden" name="${_csrf.parameterName}"
                                          value="${_csrf.token}" />
						             </div>
						
       </form>



                                    <form action="${pageContext.request.contextPath}/patient/doUpload?${_csrf.parameterName}=${_csrf.token}"  method="post" enctype="multipart/form-data">


                                            <div class="form-group">
                                            <label>Patient file</label>
                                            <input type="file" name="fileUpload" size="50" />
                                                </div>
                                        <input class="form-control"  value="${userss.id}"
                                               id="_id" type="hidden" class="ii form-control " name="id" >
                                        <div class="form-group">
                                        <button type="submit" class="btn btn-group-xs btn-success">upload file</button>
                                            </div>
                                    </form>
                    </div>
                                </div>
            
                   </div>

                        <div class="col-lg-8">
                            <div class="panel panel-default">
                                <div class="panel panel-success">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Patient Files</h3>
                                    </div>
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-hover table-striped">
                                                <thead>
                                                <tr>
                                                    <th>File Name</th>
                                                    <th>download</th>
                                                    <th>delete</th>

                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tbody>
                                                <c:forEach items="${files}" var="filess">
                                                    <tr>

                                                        <td><c:out value="${filess.fileName}" /> </td>
                                                            <td>
                                                            <form action="${pageContext.request.contextPath}/patient/download" method="POST">
                                                            <input type="hidden"  class="form-control"   value="<c:out value="${filess.id}" />"  name="id" id="_id"/>
                                                            <input type="hidden"  class="form-control"   value="<c:out value="${filess.userId}" />"  name="userId" id="_id"/>
                                                            <button type="submit" class="btn btn-xs btn-success">download</button>
                                                            <input type="hidden" name="${_csrf.parameterName}"
                                                            value="${_csrf.token}" />
                                                            </form>
                                                            </td>
                                                        <td>
                                                            <form action="${pageContext.request.contextPath}/patient/delete" method="post">
                                                                <input type="hidden"  class="form-control"   value="<c:out value="${filess.id}" />"  name="id" id="_id"/>
                                                                <input  type="hidden"   class="form-control"   value="<c:out value="${filess.userId}" />"  name="userId" id="_id"/>
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
                             


						<div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>visit num</th>
                                                <th>visit Date</th>
                                                <th>symptoms</th>
                                                <th>medicine list</th>
                                                <th>doctor comment</th>
                                                <th>delete</th>
                                                <th>print</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <tbody>
                                        <c:forEach items="${history}" var="historys">
                                            <tr>

                                                <td><c:out value="${historys.visitNum}" /> </td>
                                                <td><c:out value="${historys.visitDate}" />
                                                <td><c:out value="${historys.symtops}" /></td>
                                                <%--<td><c:out value="${historys.diseases}" /></td>--%>
                                                <td><c:out value="${historys.assignedMedecine}" /></td>
                                                <td><c:out value="${historys.comment}" /></td>
                                                <td>
                                                    <form action="${pageContext.request.contextPath}/patient/visit/delete" method="post">
                                                        <input type="hidden"  class="form-control"   value="<c:out value="${historys.id}" />"  name="id" id="_id"/>
                                                        <input type="hidden"  class="form-control"   value="<c:out value="${historys.userName}" />"  name="userName" id="_id"/>
                                                        <button type="submit" class="btn btn-xs btn-danger">delete</button>
                                                        <input type="hidden" name="${_csrf.parameterName}"
                                                               value="${_csrf.token}" />
                                                    </form>
                                                </td>

                                                <td>
                                                    <form action="${pageContext.request.contextPath}/patient/print" method="post">
                                                        <input type="hidden"  class="form-control"   value="<c:out value="${historys.id}" />"  name="id" id="_id"/>
                                                        <input type="hidden"  class="form-control"   value="<c:out value="${historys.userName}" />"  name="userName" id="_id"/>

                                                        <button type="submit" class="btn btn-xs btn-success">print</button>
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

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.42/js/bootstrap-datetimepicker.min.js"></script>
</body>


</html>
