<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Project</title>
<style>
div#mySidenav, div#myEditSidenav {
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
						<legend class="text-left">Project Management</legend>

						<div class="form-group">
							<div class="col-lg-5">
								<input type="text" class="form-control" ng-model="searchProject" placeholder="Search Project ">

							</div>
							<div class="col-lg-4 col-lg-offset-3">
								<span class="btn btn-primary" onclick="openNav()">Add
									New Project</span>
							</div>
						</div>
						<span class="err"><form:errors
									path="employee.*"></form:errors></span>
						<div class="form-group tab">
							<div class="col-lg-10">
								<table class="table table-striped table-hover table-bordered ">
									<thead>
										<tr>
											<th ng-click="orderByField='projectId'; reverseSort = !reverseSort">Project Id
											<span ng-show="orderByField == 'projectId' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'projectId' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th ng-click="orderByField='name'; reverseSort = ! reverseSort">Project Name
											<span ng-show="orderByField == 'name' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'name' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th ng-click="orderByField='manager'; reverseSort = ! reverseSort">Project Manager
											<span ng-show="orderByField == 'manager' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'manager' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th >Project Description</th>
											<th ng-click="orderByField='status'; reverseSort = ! reverseSort">Status
											<span ng-show="orderByField == 'status' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'status' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th>Edit</th>
											
										</tr>
									</thead>
									<tbody>
										<tr class="active" ng-repeat="(i,project) in projectList | filter: searchProject | orderBy:orderByField:reverseSort">
											<td>{{project.projectId}}</td>
											<td>{{project.name}}</td>
											<td>{{project.managerFirstName}} {{project.managerLastName}}</td>
											<td>{{project.description}}</td>
											<td>{{project.activationStatus}}</td>
											<td><input type="button" class="btn btn-default btn-xs"
												value="Edit" data-ng-click="EditProject(project)" onclick="openEditNav()" /></td>

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
	<!-- ADD PROJECT  -->
	<div class="sidenav" id="mySidenav">
		<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-9">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">Add Project <a class="pull-right" onclick="closeNav()" style="cursor: pointer;"><i class="fa fa-window-close" aria-hidden="true"></i></a></h3>
								</div>
								<div class="panel-body">
									<form role="form" action="registerproject" method="post" onsubmit="return addValidate()">
										<legend>Register Project</legend>
										

										<div class="form-group">

											<label for="name"> Enter Project Name </label>
											<input type="text" class="form-control" id="addName" pattern="[a-z A-Z 0-9]{2,35}" maxlength="35"
												name="name" required="required" title="Special characters not allowed. Max Length : 35 characters. Min Length: 2 characters" />
										</div>

										

										<div class="form-group">
											<label for="project">Project Manager</label>
												<select name="headedByEmployeeId" class="form-control" id="headedByEmployeeId">
													<option ng-repeat="manager in newManagerList" value="{{manager.id}}">
														{{manager.firstName}} {{manager.lastName}}
													</option>
													
												</select>
										</div>
										<div class="form-group">

											<label for="description"> Enter Project's Description </label> <textarea
												type="text" class="form-control" id="description" pattern="[a-z A-Z 0-9]{2,200}" maxlength="200"
												name="description" required="required" title="Max Length : 200 characters. Min Length: 2 characters"></textarea>
										</div>
										<div class="checkbox">
											<label> <input id="addCheck" type="checkbox" checked="checked" name="enabled"> Project
														Active
											</label>
										</div>

												<button id="addBtn" type="submit" class="btn btn-default">Add Project</button>
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
									<h3 class="panel-title">Edit Project <a class="pull-right" onclick="closeEditNav()" style="cursor: pointer;"><i class="fa fa-window-close" aria-hidden="true"></i></a></h3>
								</div>
								<div class="panel-body">
									<form role="form" action="updateproject" method="post" onsubmit="return validate()">
										<legend>Edit Project</legend>
										<input  type="hidden" name="id" value="{{ProjectModel.id}}" />
										<input  type="hidden" name="createdBy" value="{{ProjectModel.createdBy}}" />
										<input  type="hidden" name="createdDate" value="{{ProjectModel.createdDate}}" />
										
										<div class="form-group">
							
											<label for="employeeId"> Project Id </label>  
											<input type="text" class="form-control" id="employeeId" data-ng-model="ProjectModel.projectId"
												name="projectId" required="required" readonly="readonly" />
										</div>
										
										<div class="form-group">
							
											<label for="name"> Project Name </label>  
											<input type="text" class="form-control" id="name" data-ng-model="ProjectModel.name"
												name="name" required="required" maxlength="35" pattern="[a-z A-Z 0-9]{2,35}" title="Special characters not allowed. Max Length : 35 characters. Min Length: 2 characters" />
										</div>
					
										<div class="form-group">
											<label for="project">Project Manager</label>
											
												<select  name="headedByEmployeeId" class="form-control" id="editManager"
												data-ng-model="ProjectModel.headedByEmployeeId">
													<option style="display:none" value="">Select A Manager</option>
													<option ng-repeat="manager in newManagerList" value="{{manager.id}}"
													 ng-selected="ProjectModel.headedByEmployeeId == manager.id">
														{{manager.firstName}} {{manager.lastName}}
													</option>
													
												</select>
											<span class="err" id="selectManager"></span>
										</div>
										<div class="form-group">
							
											<label for="description"> Project Description </label>  
											<textarea type="text" class="form-control" id="description" data-ng-model="ProjectModel.description"
												name="description" required="required" maxlength="200" pattern="[a-z A-Z]{2,200}" title="Max Length : 200 characters. Min Length: 2 characters"></textarea>
										</div>
										
										<div class="checkbox">
											<label> <input type="checkbox" checked="checked" 
											name="enabled" data-ng-model="ProjectModel.enabled"> Project Active
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
			document.getElementById("mySidenav").style.transform = "translateY(-120%)";
		} 
		function closeEditNav() {
			document.getElementById("myEditSidenav").style.transform = "translateY(-120%)";
		} 

		var app = angular.module("adminApp", []);
		app.controller('adminCtrl', function($scope) {
			
			$scope.projectList = ${projects};
			$scope.managerList = ${managers};
			$scope.newManagerList =  ${newManagers};
			var _ctr = 0,
				_totalProjects =  $scope.projectList.length,
				_project = null;
			
			for ( _ctr; _ctr < _totalProjects; _ctr = _ctr + 1 ) {
				_project = $scope.projectList[ _ctr ];
				$scope.projectList[ _ctr ].activationStatus = _project.enabled ? 'Active' : 'Deactive';
				$scope.projectList[ _ctr ].managerFirstName = $scope.managerList[_ctr].firstName;
				$scope.projectList[ _ctr ].managerLastName = $scope.managerList[_ctr].lastName;
				
			}
			
			

		$scope.ProjectModel = {
				name : '',
				id : '',
				enabled : '',
				projectId : '',
				description : '',
				headedByEmployeeId : '',
				createdBy : '',
				createdDate : '',
			};

			$scope.EditProject = function(project) {
				$scope.ProjectModel.name = project.name;
				$scope.ProjectModel.id = project.id;
				$scope.ProjectModel.enabled = project.enabled;
				$scope.ProjectModel.projectId = project.projectId;
				$scope.ProjectModel.description = project.description;
				$scope.ProjectModel.headedByEmployeeId = project.headedByEmployeeId;
				$scope.ProjectModel.createdBy = project.createdBy;
				$scope.ProjectModel.createdDate = project.createdDate;
				
			
			}

		});
		  $('#addCheck').click(function() {
		        if ($(this).is(':checked')) {
		        	 $('#addBtn').removeAttr('disabled');
		        } else {
		        	$('#addBtn').attr('disabled', 'disabled');
		        }
		    });
		  function validate(){
			  if($('#editManager').val() == ""){
				  $('#selectManager').text("Please select a manager");
				  return false;
			  }
			  else{
				  $('#selectManager').text("");
				  return true;
			  }
		  }

	</script>
	
</body>
</html>


