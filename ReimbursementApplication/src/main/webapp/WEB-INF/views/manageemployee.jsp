<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Employee</title>
<style>
div#mySidenav , div#myEditSidenav {
	height: 100%;
	width: 100%;
	position: fixed;
	z-index: 1;
	top: 0;
	right: 0;
	overflow-x: hidden;
	margin-top: 60px;
	transition: transform 0.2s linear;
	transform: translateY(-120%);
}

.tab {
	margin-top: 100px;
}
.err{
	color:red;
}
</style>
</head>
<body ng-app="adminApp" data-ng-controller="adminCtrl">


	<div class="container-fluid">
		<jsp:include page="includes/header.jsp"></jsp:include>
		<div class="row">
			<div class="col-sm-3 col-md-2 col-lg-2">
				<jsp:include page="includes/navigationMenu.jsp"></jsp:include>
			</div>
			<div class="col-lg-10">
			
				<form class="form-horizontal">
					<fieldset>
						<legend class="text-left">Employee Management</legend>

						<div class="form-group">
							<div class="col-lg-5">
								<input type="text" class="form-control" ng-model="searchEmployee" placeholder="Search Employee ">

							</div>
							<div class="col-lg-4 col-lg-offset-3">
								<span class="btn btn-primary" onclick="openNav()">Add
									New Employee</span>
							</div>
						</div>
						<span class="err"><form:errors
									path="employee.*"></form:errors></span>
						<div class="form-group tab">
							<div class="col-lg-10">
								<table class="table table-striped table-hover table-bordered ">
									<thead>
										<tr>
											<th ng-click="orderByField='employeeId'; reverseSort = !reverseSort">Employee Id
											<span ng-show="orderByField == 'emloyeeId' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'employeeId' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th ng-click="orderByField='firstName'; reverseSort = !reverseSort">Name
											<span ng-show="orderByField == 'firstName' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'firstName' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th ng-click="orderByField='email'; reverseSort = !reverseSort">Email
											<span ng-show="orderByField == 'email' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'email' && reverseSort" class="fa fa-caret-up"></span>
            								</th>
											<th ng-click="orderByField='designation'; reverseSort = !reverseSort">Designation
											<span ng-show="orderByField == 'designation' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'designation' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th ng-click="orderByField='project'; reverseSort = !reverseSort">Project
											<span ng-show="orderByField == 'project' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'project' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th ng-click="orderByField='manager'; reverseSort = !reverseSort">Manager
											<span ng-show="orderByField == 'manager' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'manager' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th ng-click="orderByField='status'; reverseSort = !reverseSort">Status
											<span ng-show="orderByField == 'status' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'status' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th>Edit</th>
									
										</tr>
									</thead>
									<tbody>
										<tr class="active" ng-repeat="(i,employee) in employeeList  | filter: searchEmployee | orderBy:orderByField:reverseSort ">
											<td>{{employee.employeeId}}</td>
											<td>{{employee.firstName}} {{employee.lastName}}</td>
											<td>{{employee.email}}</td>
											<td>{{employee.designation.name}}</td>
											<td data-projectId="{{employee.assignedToProject.id}}">{{employee.assignedToProject.name}}</td>
											<td>{{employee.managerFirstName}} {{employee.managerLastName}}</td>
											<td>{{employee.activationStatus}}</td>
												<td><input type="button" class="btn btn-default btn-xs"
												value="Edit" data-ng-click="EditEmployee(employee)" onclick="openEditNav()" /></td>

										</tr>
									</tbody>
								</table>
							</div>
						</div>


					</fieldset>
				</form>
			
			</div>
	
			
		</div>
	</div>
	<!-- ADD EMPLOYEE  -->
	<div class="sidenav" id="mySidenav">
		<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-9">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">Add Employee <a class="pull-right" onclick="closeNav()" style="cursor: pointer;"><i class="fa fa-window-close" aria-hidden="true"></i></a></h3>
								</div>
								<div class="panel-body">
									<form role="form" action="register" method="post">
										<legend>Register Employee</legend>
										
										<div class="form-group">

											<label for="employeeId"> Enter Employee Id </label>
											<input type="text" maxlength="15" class="form-control" id="employeeId"
												name="employeeId" required="required"
												 />
										</div>

										<div class="form-group">

											<label for="firstName"> Enter Employee's First Name </label>
											<input type="text" maxlength="25" class="form-control" id="firstName" pattern="[a-z A-Z]{2,25}"
												name="firstName" required="required" title="First Name should not have digits or special characters. Max Length : 25 characters. Min Length: 2 characters" />
										</div>

										<div class="form-group">

											<label for="lastName"> Enter Employee's Last Name </label> <input
												type="text" maxlength="25" class="form-control" id="lastName" pattern="[a-z A-Z]{2,25}"
												name="lastName" required="required" title="Last Name should not have digits or special characters. Max Length : 25 characters. Min Length: 2 characters" />
										</div>

										<div class="form-group">

											<label for="emailInput"> Enter Employee's Email </label> <input
												type="email" maxlength="30" class="form-control" id="emailInput"
												name="email" required="required" />
										</div>

										<div class="form-group">
											<label for="project">Enter Project</label>
												<select name="assignedToProjectId" class="form-control" id="project">
													<option ng-repeat="project in projectList" value="{{project.id}}">
														{{project.name}}
													</option>
													
												</select>
										</div>
										
										<div class="form-group">
											<label for="designation">Enter Designation</label>
												<select name="designationId" class="form-control" id="desgination">
													<option ng-repeat = "designation in designationList" value="{{designation.id}}">
														{{designation.name}}
													</option>
													
												</select>
										</div>
										<div class="form-group">
											<label for="project">Define Role</label>
												<select name="role" class="form-control" id="role">
													<option value="Employee">Employee</option>
													<option value="Manager">Manager</option>
													<option value="Finance">Finance</option>
													<option value="ROLE_ADMIN">Admin</option>
												</select>
										</div>

												<div class="checkbox">
													<label> <input id="addCheck" type="checkbox" checked="checked" name="enabled"> Employee
														Active
													</label>
												</div>

												<button id="addBtn" type="submit" class="btn btn-default">Add Employee</button>
									</form>


								</div>
							</div>
						</div>
						<div class="col-md-1"></div>
					</div>
	</div>
	
	<!-- EDIT EMPLOYEE -->
	
	<div class="sidenav" id="myEditSidenav">
		<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-9">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">Edit Employee <a class="pull-right" onclick="closeEditNav()" style="cursor: pointer;"><i class="fa fa-window-close" aria-hidden="true"></i></a></h3>
								</div>
								<div class="panel-body">
									<form role="form" action="updateemployee" method="post" onsubmit="return validate()">
										<legend>Edit Employee</legend>
										<input  type="hidden" name="id" value="{{EmployeeModel.id}}" />
										<input  type="hidden" name="createdBy" value="{{EmployeeModel.createdBy}}" />
										<input  type="hidden" name="createdDate" value="{{EmployeeModel.createdDate}}" />
										<input  type="hidden" name="firstLogIn" value="{{EmployeeModel.firstLogIn}}" />
										<input  type="hidden" name="password" value="{{EmployeeModel.password}}" />
										<input  type="hidden" name="role" value="{{EmployeeModel.role}}" />
								
										<div class="form-group">
							
											<label for="employeeId"> Employee Id </label>  
											<input type="text" class="form-control" id="employeeId" data-ng-model="EmployeeModel.employeeId"
												name="employeeId" required="required" readonly="readonly"  />
										</div>
										
										<div class="form-group">
							
											<label for="firstName"> Employee's First Name </label>  
											<input type="text" maxlength="25" class="form-control" id="firstName" data-ng-model="EmployeeModel.firstName"
												name="firstName" required="required" pattern="[a-z A-Z]{2,25}" title="First Name should not have digits or special characters. Max Length : 25 characters. Min Length: 2 characters"/>
										</div>

										<div class="form-group">

											<label for="lastName"> Employee's Last Name </label> <input
												type="text" maxlength="25" class="form-control" id="lastName" data-ng-model="EmployeeModel.lastName"
												name="lastName" required="required" pattern="[a-z A-Z]{2,25}" title="Last Name should not have digits or special characters. Max Length : 25 characters. Min Length: 2 characters" />
										</div>

										<div class="form-group">

											<label for="emailInput">Employee's Email </label> <input
												type="email" class="form-control" id="emailInput" data-ng-model="EmployeeModel.email"
												name="email" required="required" readonly="readonly" />
										</div>

					
										<div class="form-group">
											<label for="project">Project</label>
												<select  name="assignedToProjectId" class="form-control" id="updateProject"
												data-ng-model="EmployeeModel.projectId"
												>
													<option style="display:none" value="">Select A Project</option>
													<option ng-repeat="project in projectList" value="{{project.id}}"
													 ng-selected="EmployeeModel.projectId == project.id">
														{{project.name}}
													</option>
													
												</select>
												<span class="err" id="projectError"></span>
										</div>
										
										<div class="form-group">
											<label for="designation">Designation</label>
												<select name="designationId" class="form-control" id="updateDesignation"
												data-ng-model="EmployeeModel.designationId">
												<option style="display:none" value="">Select A Designation</option>
													<option ng-repeat = "designation in designationList" value="{{designation.id}}"
													ng-selected="EmployeeModel.designationId == designation.id">
														{{designation.name}}
													</option>
													
												</select>
												<span class="err" id="designationError"></span>
										</div>
										<div class="form-group">
											<label for="project">Define Role</label>
												<select name="role" class="form-control" id="role"
												data-ng-model="EmployeeModel.role">
													<option value="Employee">Employee</option>
													<option value="Manager">Manager</option>
													<option value="Finance">Finance</option>
													<option value="ROLE_ADMIN">Admin</option>
												</select>
										</div>

												<div class="checkbox">
													<label> <input type="checkbox" checked="checked" 
													name="enabled" data-ng-model="EmployeeModel.enabled"> Employee
														Active
													</label>
												</div>

												<button type="submit" class="btn btn-default">Save Changes</button>
									</form>


								</div>
							</div>
						</div>
						<div class="col-md-1"></div>
					</div>
	</div>




	<script>

		function openNav() {
			    document.getElementById("mySidenav").style.transform = "translateY(5%)";
		}
		function openEditNav() {
			    document.getElementById("myEditSidenav").style.transform = "translateY(5%)";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.transform = "translateY(-120%)";		} 
		function closeEditNav() {
			document.getElementById("myEditSidenav").style.transform = "translateY(-120%)";		
			} 

		var app = angular.module("adminApp", []);
		app.controller('adminCtrl', function($scope) {
			
			$scope.employeeList = ${employees};
			$scope.projectList = ${projects};
			$scope.designationList = ${designations};
			$scope.managerList = ${managers};
			var _ctr = 0,
				_totalEmployees =  $scope.employeeList.length,
				_employee = null;
			
			for ( _ctr; _ctr < _totalEmployees; _ctr = _ctr + 1 ) {
				_employee = $scope.employeeList[ _ctr ];
				$scope.employeeList[ _ctr ].activationStatus = _employee.enabled ? 'Active' : 'Deactive';
				$scope.employeeList[ _ctr ].managerFirstName = $scope.managerList[_ctr].firstName;
				$scope.employeeList[ _ctr ].managerLastName =$scope.managerList[_ctr].lastName;
			}
			
		

		$scope.EmployeeModel = {
				firstName : '',
				lastName : '',
				email : '',
				id : '',
				createdBy : '',
				createdDate: '',
				employeeId : '',
				firstLogIn : '',
				password : '',
				role : '',
				projectId : '',
				designationId : '',
				enabled : '',
			};

			$scope.EditEmployee = function(employee) {
				$scope.EmployeeModel.firstName = employee.firstName;
				$scope.EmployeeModel.lastName = employee.lastName;
				$scope.EmployeeModel.email = employee.email;
				$scope.EmployeeModel.id = employee.id; 
				$scope.EmployeeModel.createdBy  = employee.createdBy;
				$scope.EmployeeModel.createdDate  = employee.createdDate;
				$scope.EmployeeModel.employeeId  = employee.employeeId;
				$scope.EmployeeModel.firstLogIn  = employee.firstLogIn;
				$scope.EmployeeModel.password  = employee.password;
				$scope.EmployeeModel.role  = employee.role;
				$scope.EmployeeModel.projectId=employee.assignedToProject.id; 
				$scope.EmployeeModel.designationId=employee.designation.id; 
				$scope.EmployeeModel.enabled=employee.enabled; 
				
			
			}
			 $('#addCheck').click(function() {
			        if ($(this).is(':checked')) {
			        	 $('#addBtn').removeAttr('disabled');
			        } else {
			        	$('#addBtn').attr('disabled', 'disabled');
			        }
			    });

		});
		function validate(){
			  if($('#updateProject').val() == ""){
				  $('#projectError').text("Please select a Project");
				  return false;
			  }
			  else if($('#updateDesignation').val() == ""){
				  $('#designationError').text("Please select a Designation");
				  return false;
			  }
			  else{
				  $('#projectError').text("");
				  $('#designationError').text("");
				  return true;
			  }
		  }
	</script>
	
</body>
</html>


