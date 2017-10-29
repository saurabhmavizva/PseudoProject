<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Category</title>

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
</style>
</head>
<body ng-app="adminApp" ng-controller="adminCtrl">
	<div class="container-fluid">
		<jsp:include page="includes/header.jsp"></jsp:include>
		<div class="row">
			<div class="col-sm-3 col-md-2 col-lg-2">
				<jsp:include page="includes/navigationMenu.jsp"></jsp:include>
			</div>
			<div class="col-lg-10">
				<form class="form-horizontal">
					<fieldset>
						<legend class="text-left">Category Management</legend>

						<div class="form-group">
							<div class="col-lg-5">
								<input type="text" class="form-control"
									ng-model="searchCategory" placeholder="Search Category">

							</div>
							<div class="col-lg-2">
								<select class="form-control" ng-model="singleSelect" ng-options="item for item in categoryType" >
									<option style="display:none" value="">Select A Category</option>
								</select>
							</div>
							<div class="col-lg-4 col-lg-offset-1">
								<span class="btn btn-primary" onclick="openNav()">Add New
									Category</span>
							</div>
						</div>

						<div class="form-group tab">
							<div class="col-lg-10">
								<table class="table table-striped table-hover table-bordered ">
									<thead>
										<tr>
											<th ng-click="orderByField='categoryId'; reverseSort = !reverseSort">Category Id
											<span ng-show="orderByField == 'categoryId' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'categoryId' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th ng-click="orderByField='name'; reverseSort = !reverseSort">Category Name
											<span ng-show="orderByField == 'name' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'name' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th ng-click="orderByField='type'; reverseSort = !reverseSort">Type
											<span ng-show="orderByField == 'type' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'type' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th ng-click="orderByField='status'; reverseSort = !reverseSort">Status
											<span ng-show="orderByField == 'status' && !reverseSort" class="fa fa-caret-down"></span>
            								<span ng-show="orderByField == 'status' && reverseSort" class="fa fa-caret-up"></span>
											</th>
											<th>Edit</th>
											
										</tr>
									</thead>
									<tbody>
										<tr class="active"
	 										ng-repeat="(i,category) in categoryList | filter: searchCategory | mySelect:{ category:{ type: singleSelect} } | orderBy:orderByField:reverseSort "> 
											<td>{{category.categoryId}}</td>
											<td>{{category.name}}</td>
											<td>{{category.type}}</td>
											<td>{{category.activationStatus}}
											</td>
											<td><input type="button" class="btn btn-default btn-xs"
												value="Edit" data-ng-click="EditCategory(category)"
												onclick="openEditNav()" /></td>
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
	<!-- ADD CATEGORY	  -->
	<div class="sidenav" id="mySidenav">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-9">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							Add Category <a class="pull-right" onclick="closeNav()" style="cursor: pointer;"><i class="fa fa-window-close" aria-hidden="true"></i></a>
						</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="registercategory" method="post">
							<legend>Register Category</legend>

							<div class="form-group">

								<label for="name"> Enter Category's Name </label> <input
									type="text" class="form-control" id="name" name="name"
									 data-ng-model="name" ng-change="checkName()" maxlength="35"
									required="required" pattern="[a-z A-Z]{2,35}" title="Category Name can not have digits or special characters. Max Length: 35 Characters. Minimum length: 2 characters" />
									<p ng-show="showError" style="color: red;">Name already exists</p>
							</div>
													
						
							<div class="form-group">
								<label for="type">Category Type</label>
								 <select name="type"
									class="form-control" id="type" name="type">
									<option value="PAYROLL">Payroll</option>
									<option value="NON_PAYROLL">Non Payroll</option>
								
								</select>
							</div>

							<div class="checkbox">
								<label> <input type="checkbox" checked="checked" id="addCheck"
									name="enabled"> Category Active
								</label>
							</div>

							<button id="addBtn" type="submit" class="btn btn-default"  id="addBtn">Add
							</button>
							
						</form>


					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>

	<!-- EDIT CATEGORY -->

	<div class="sidenav" id="myEditSidenav">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-9">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							Edit Category <a class="pull-right" onclick="closeEditNav()" style="cursor: pointer;"><i class="fa fa-window-close" aria-hidden="true"></i></a>
						</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="updatecategory" method="post">
							<legend>Edit Category</legend>
							<input type="hidden" name="id" value="{{CategoryModel.id}}" />
							<input type="hidden" name="createdBy" value="{{CategoryModel.createdBy}}" />
							<input type="hidden" name="createdDate" value="{{CategoryModel.createdDate}}" /> 
							
							<div class="form-group">

								<label for="name"> Category Id </label>
								 <input type="text" class="form-control" id="categoryId"
									data-ng-model="CategoryModel.categoryId" name="categoryId"
									required="required" readonly="readonly"/>
							</div>
							
							<div class="form-group">

								<label for="name"> Category's Name </label> <input
									type="text" class="form-control" id="name" maxlength="35"
									data-ng-model="CategoryModel.name" name="name" pattern="[a-z A-Z]{2,35}" title="Category Name can not have digits or special characters. Max Length: 35 Characters. Minimum length: 2 characters"
									required="required" />
							</div>

						
							<div class="form-group">
								<label for="type">Category Type</label> <input name="type"
									class="form-control" id="type" readonly="readonly"
									data-ng-model="CategoryModel.type" />
									
							</div>

							<div class="checkbox">
								<label> <input type="checkbox" checked="checked"
									name="enabled" data-ng-model="CategoryModel.enabled"> Category Active
								</label>
							</div>

							<button type="submit" class="btn btn-default">Save Changes
							</button>
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
		
		app.filter('mySelect' , function(){
			
			return function(category , filterObj){
				var retArr = [];				
				for(var i =0 ; i < category.length ; i = i+1){
					if(undefined === filterObj.category.type){
						return category;
					}
					if('BOTH' === filterObj.category.type){
						return category;
					}
					if(category[i].type === filterObj.category.type){
						retArr.push(category[i]);
					}
				}
				return retArr;
			}
		});
		
		app.controller('adminCtrl', function($scope) {

			$scope.categoryList = ${categories};
			$scope.categoryNames = ${categoryNames};
			$scope.categoryType = ${categoryType};
			$scope.categoryType.push("BOTH");
			
			var _ctr = 0,
			_totalCategories =  $scope.categoryList.length,
			_category = null;
		
		for ( _ctr; _ctr < _totalCategories; _ctr = _ctr + 1 ) {
			_category = $scope.categoryList[ _ctr ];
			$scope.categoryList[ _ctr ].activationStatus = _category.enabled ? 'Active' : 'Deactive';
			
			
		}

			$scope.CategoryModel = {
				id : '',
				name : '',
				categoryId : '',
				type : '',
				createdBy : '',
				createdDate : '',
				enabled : '',
				
			};

			$scope.EditCategory = function(category) {
				$scope.CategoryModel.id = category.id;
				$scope.CategoryModel.name = category.name;
				$scope.CategoryModel.categoryId = category.categoryId;
				$scope.CategoryModel.type = category.type;
				$scope.CategoryModel.createdBy = category.createdBy;
				$scope.CategoryModel.createdDate = category.createdDate;
				$scope.CategoryModel.enabled = category.enabled;
				

			}
			
			$scope.checkName = function (){
				   if($scope.categoryNames.includes($scope.name)){
				     $scope.showError = true;
				     $('#addBtn').attr("disabled","true");
				   } else {
				     $scope.showError = false;
				     $('#addBtn').removeAttr("disabled");
				   }
			}
			
			 $scope.filterExpression = function(category) {  
	                return (category.type === $scope.categoryType );
	            };

		});
		 $('#addCheck').click(function() {
		        if ($(this).is(':checked')) {
		        	 $('#addBtn').removeAttr('disabled');
		        } else {
		        	$('#addBtn').attr('disabled', 'disabled');
		        }
		    });
		
	</script>
</body>
</html>