<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="monitorApp">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Monitoring</title>

<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">

<script src="<%=request.getContextPath()%>/js/angular.js"></script>
<script src="<%=request.getContextPath()%>/js/angular-resource.js"></script>
<script src="<%=request.getContextPath()%>/js/angularInit.js"></script>
<script src="<%=request.getContextPath()%>/js/services/monitorService.js"></script>
<script src="<%=request.getContextPath()%>/js/controllers/mainCtrl.js"></script>


</head>
<body ng-controller="mainCtrl">
<div class="col-lg-6" style="padding-top: 20px;">
<div class="panel panel-default">
  <div class="panel-heading">Monitoring info</div>
  <div class="panel-body">

<div class="col-lg-6">
<table class="table table-striped table-hover ">
  <thead>
    <tr>
      <th>Windows service name</th>
    </tr>
  </thead>
  <tbody>
    <tr ng-repeat="service in services" ng-class="{success: service.windowsServiceRunning, danger: !service.windowsServiceRunning,}"> 
      <td>{{service.windowsServiceName}}</td>
    </tr>
  </tbody>
</table> 
</div>

<div class="col-lg-6">
<table class="table table-striped table-hover ">
  <thead>
    <tr>
      <th>Tomcat service name</th>
    </tr>
  </thead>
  <tbody>
    <tr ng-repeat="service in services" ng-class="{success: service.tomcatServiceRunning, danger: !service.tomcatServiceRunning}"> 
      <td>{{service.tomcatServiceName}}</td>
    </tr>
  </tbody>
</table> 
</div>

  </div>
</div>

</div>

  
<!--
	<c:forEach var="service" items="${services}">
		<div class="col-lg-4">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Service: ${service.tomcatServiceName}</h3>
				</div>
				<div class="panel-body">
					<div
						class="panel panel-${service.windowsServiceRunning ? 'success' : 'danger'}">
						<div class="panel-heading">
							<h3 class="panel-title">Windows service
								${service.windowsServiceName}</h3>
						</div>
					</div>
					<div
						class="panel panel-${service.tomcatServiceRunning ? 'success' : 'danger'}">
						<div class="panel-heading">
							<h3 class="panel-title">Tomcat service
								${service.tomcatServiceName}</h3>
						</div>
						<div class="panel-body">
								Server name : ${service.tomcatServerName}<br/>Server port :
								${service.tomcatServerJMXPort}
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
-->
</body>
</html>