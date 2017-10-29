<%@page import="java.awt.Color"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
<style type="text/css">
.div1 {
	margin-left: 500px;
	/* margin-top: 50px; */
	border: 2px red solid;
	border-color: #d9230f;
	display: inline-block;
	width: 200px;
	height: 200px;
}

/* .p01:hover {
	font-size: 110%;
	text-align: center;
} */

.d01 {
	text-align: center;
	margin-top: 50px;
	font-size: 20px;
}

.panel1 {
	margin-left: 50px;
}
</style>
</head>
<body>

	<div class="container-fluid">

		<jsp:include page="includes/header.jsp"></jsp:include>

		<div class="row">
			<div class="col-sm-3 col-md-2 col-lg-2">
				<jsp:include page="includes/navigationMenu.jsp"></jsp:include>
			</div>

			<div class="col-lg-10" ng-app="dashApp" data-ng-controller="dashCtrl">

				

				<div class="panel panel1 panel-primary  div1">
					<div class="panel-heading">
						<h3 class="panel-title">Total Requests</h3>
					</div>
					<div class="panel-body d01">
						<p class="p01">${totalRequest}</p>
					</div>
				</div>
				<div class="panel panel1 panel-primary div1">
					<div class="panel-heading">
						<h3 class="panel-title">Completed Requests</h3>
					</div>
					<div class="panel-body d01">
						<p class="p01">${completedRequests}</p>
					</div>
				</div>
				<div class="panel panel1 panel-primary div1">
					<div class="panel-heading">
						<h3 class="panel-title">Saved Requests</h3>
					</div>
					<div class="panel-body d01">
						<p class="p01">${savedRequests}</p>
					</div>
				</div>
				<div class="panel panel1 panel-primary div1">
					<div class="panel-heading">
						<h3 class="panel-title">In Process</h3>
					</div>
					<div class="panel-body d01">
						<p class="p01">${inProcessRequest}</p>
					</div>
				</div>
				<div class="col-md-11">
					<div class="panel  panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">Category Limits Used v/s Total</h3>
						</div>
						<div class="panel-body">
							<div
								ng-repeat="(categoryId, categoryLimit) in categoriesLimits track by categoryId">
								<label class="text-left "><strong  >{{mapCategories[categoryId]}}
								</strong>
								</label>
								<label class="pull-right ">
								<!-- <div ng-if="{{usedLimits[categoryId]}}>{{categoryLimit}}">
									{{categoryLimit}}/{{categoryLimit}}
								</div> -->
								{{usedLimits[categoryId] | number:2 | currency:'INR' }} / {{categoryLimit | currency:'INR' }}
								
								</label>
								

								<div class="progress">
									<div class="progress-bar progress-bar-striped active"
										role="progressbar"
										style="width: {{ (usedLimits[categoryId] / categoryLimit) *100}}%"><!-- {{categoryLimit-usedLimits[categoryId]}}
										Available --></div>
								</div>

							</div>
						</div>
					</div>
				</div>
				<div class="col-md-11">
					<div class="panel  panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">Pending Requests</h3>
						</div>
						<div class="panel-body">
							
					<table class="table table-striped table-hover table-bordered ">
						<thead>
							<tr>
								<th>#</th>
								<th
									ng-click="orderByField='reimbursementId'; reverseSort = !reverseSort">Request
									Id <span
									ng-show="orderByField == 'reimbursementId' && !reverseSort"
									class="fa fa-caret-down"></span> <span
									ng-show="orderByField == 'reimbursementId' && reverseSort"
									class="fa fa-caret-up"></span>
								</th>
								<th
									ng-click="orderByField='submissionDate'; reverseSort = !reverseSort">Submission
									Date <span
									ng-show="orderByField == 'submissionDate' && !reverseSort"
									class="fa fa-caret-down"></span> <span
									ng-show="orderByField == 'submissionDate' && reverseSort"
									class="fa fa-caret-up"></span>
								</th>
								<th
									ng-click="orderByField='category.name'; reverseSort = !reverseSort">Category
									<span ng-show="orderByField == 'category.name' && !reverseSort"
									class="fa fa-caret-down"></span> <span
									ng-show="orderByField == 'category.name' && reverseSort"
									class="fa fa-caret-up"></span>
								</th>
								<th
									ng-click="orderByField='amountRequested'; reverseSort = !reverseSort">Amount
									Requested <span
									ng-show="orderByField == 'amountRequested' && !reverseSort"
									class="fa fa-caret-down"></span> <span
									ng-show="orderByField == 'amountRequested' && reverseSort"
									class="fa fa-caret-up"></span>
								</th>
								<th ng-click="orderByField='state'; reverseSort = !reverseSort">Status
									<span ng-show="orderByField == 'state' && !reverseSort"
									class="fa fa-caret-down"></span> <span
									ng-show="orderByField == 'state' && reverseSort"
									class="fa fa-caret-up"></span>
								</th>
								<th>Action</th>
							</tr>
						</thead>
								<tbody>
									<tr class="active"
										ng-repeat="(i, ReimbursementRequest) in pendingRequests | orderBy:orderByField:reverseSort">
										<td>{{i+1}}</td>
										<td>{{ReimbursementRequest.reimbursementId}}</td>
										<td><span
											ng-if="ReimbursementRequest.submissionDate">{{ReimbursementRequest.submissionDate
												| date : "dd-MM-yyyy"}}</span></td>
										<td>{{ReimbursementRequest.category.name}}</td>
										<td>{{ReimbursementRequest.amountRequested |
											currency:'INR'}}</td>
										<td>{{ReimbursementRequest.state}}</td>
										<td><div ng-if="ReimbursementRequest.state == 'DRAFT'">
												<a ng-href="editsaved?requestId={{ReimbursementRequest.id}}"><span
													class="btn-xs btn-default">Edit <i
														class="fa fa-pencil"></i>
												</span> </a>
											</div></td>
									</tr>
								</tbody>
							</table>
				
						</div>
					</div>
				</div>



				

			</div>





		</div>

	</div>


	<script type="text/javascript">
		var app = angular.module("dashApp", []);

		app.controller('dashCtrl', function($scope) {

			$scope.pendingRequests = ${pendingRequests};
			$scope.categoriesLimits=${categoriesLimits};
			$scope.usedLimits=${usedLimits};
			$scope.mapCategories=${mapCategories};
			$scope.map={};
			$scope.converMap = function(){
				var i = 0;
				for(i =0 ; i < $scope.categoriesLimits.length ; i = i + 1 ){
					$scope.map[$scope.categoriesLimits[i].value] ==  $scope.usedLimits[i].value;
				}	
			}			
			$scope.converMap();
			
			
			$scope.formatDate=function(){
				$scope.pendingRequests.forEach(request=>{
					request.submissionDate=Date.parse(request.submissionDate);
					
				});
			};
			$scope.formatDate();

		});
	</script>

</body>
</html>