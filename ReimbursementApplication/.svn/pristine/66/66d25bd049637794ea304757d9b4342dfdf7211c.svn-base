<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Reimbursement Queue</title>
		<style>
		div#mySidenav, div#myEditSidenav {
			height: 100%;
			width: 100%;
			position: fixed;
			z-index: 1;
			top: 0;
			right: 0;
			overflow-x: hidden;
			argin-top: 0px;
			transition: transform 0.2s linear;
			transform: translateY(-120%);
		}
		
		.legend_borderless {
			border-bottom: 0px !important;
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
							<legend>Reimbursement Queue</legend>
							<div class="form-group tab">
								<div class="col-lg-10">
									<table class="table table-striped table-hover table-bordered ">
										<thead>
											<tr style="cursor: pointer;">
												<th ng-click="orderByField='i'; reverseSort = !reverseSort"> #
													<span ng-show="orderByField == 'i' && !reverseSort" class="fa fa-caret-down"></span>
            										<span ng-show="orderByField == 'createdDate' && reverseSort" class="fa fa-caret-up"></span>
												</th>
												<th ng-click="orderByField='reimbursementId'; reverseSort = !reverseSort">Request Id
													<span ng-show="orderByField == 'reimbursementId' && !reverseSort" class="fa fa-caret-down"></span>
            										<span ng-show="orderByField == 'reimbursementId' && reverseSort" class="fa fa-caret-up"></span>
												</th>
												<th ng-click="orderByField='employee.firstName'; reverseSort = !reverseSort">Employee Name
													<span ng-show="orderByField == 'employee.firstName' && !reverseSort" class="fa fa-caret-down"></span>
            										<span ng-show="orderByField == 'employee.firstName' && reverseSort" class="fa fa-caret-up"></span>
												</th>
												<th ng-click="orderByField='employee.employeeId'; reverseSort = !reverseSort">Employee ID
													<span ng-show="orderByField == 'employee.employeeId' && !reverseSort" class="fa fa-caret-down"></span>
            										<span ng-show="orderByField == 'employee.employeeId' && reverseSort" class="fa fa-caret-up"></span>
												</th>
												<th ng-click="orderByField='category.name'; reverseSort = !reverseSort">Category
													<span ng-show="orderByField == 'categoryName' && !reverseSort" class="fa fa-caret-down"></span>
            										<span ng-show="orderByField == 'categoryName' && reverseSort" class="fa fa-caret-up"></span>
												</th>
												<th ng-click="orderByField='createdDate'; reverseSort = !reverseSort">Submission Date
													<span ng-show="orderByField == 'createdDate' && !reverseSort" class="fa fa-caret-down"></span>
            										<span ng-show="orderByField == 'createdDate' && reverseSort" class="fa fa-caret-up"></span>
												</th>
												<th>State</th>
												<th >Action</th>
											</tr>
										</thead>
										<tbody>
											<tr class="active" ng-repeat="(i,reimbursementRequest) in reimbursementRequests | orderBy:orderByField:reverseSort" >
											 
												<td>{{i+1}}
												</td>
												<td>{{reimbursementRequest.reimbursementId}}</td>
												<td>{{reimbursementRequest.employee.firstName}} {{reimbursementRequest.employee.lastName}}</td>
												<td>{{reimbursementRequest.employee.employeeId}}</td>
												<td>{{reimbursementRequest.category.name}} </td>
												<td>{{reimbursementRequest.submissionDate | date : "dd-MM-yyyy"}} </td>
												<td ng-if="reimbursementRequest.state=='MANAGER_DRAFT'||reimbursementRequest.state=='FINANCE_DRAFT'">DRAFT</td>
												<td ng-if="reimbursementRequest.state=='WITH_MANAGER'||reimbursementRequest.state=='WITH_FINANCE'">NEW</td>
												<td id="mySideNav"><div ng-if="reimbursementRequest.state != 'DRAFT'"><a style="cursor: pointer;" ng-click="openNav(reimbursementRequest.id , i)" >Details </a></div> <div ng-if="reimbursementRequest.state == 'DRAFT'"> DRAFT</div></td>
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
		<!-- Item Details -->
		<div class="sidenav" id="mySidenav">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-9">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">Items Details <a class="pull-right" ng-click="closeNav()" style="cursor: pointer;"><i class="fa fa-window-close" aria-hidden="true"></i></a></h3>
						</div>
						<div class="panel-body">
								
								
								
								
								
								<div class="row">
										<div class="col-md-3">
											<div class="col-md-12">Request Id</div>
											
											<legend class="col-md-12 legend_borderless">
											<strong>{{context.reimbursementId}}</strong>
											</legend>
											
										</div>
										<div class="col-md-3">
											<div class="col-md-12">Employee Name</div>
											
											<legend class="col-md-12 legend_borderless">
											<strong>{{context.employee.firstName}}
												{{context.employee.lastName}}</strong>
											</legend>
											
										</div>
										<div class="col-md-3">
											<div class="col-md-12 ">Category</div>
											
											<legend class="col-md-12 legend_borderless">
											<strong>{{context.category.name}}</strong>
											</legend>
											
										</div>
										<div class="col-md-3"  ng-if="context.category.type=='NON_PAYROLL'">
											<div class="col-md-12 ">Project Name</div>
											
											<legend class="col-md-12 legend_borderless">
											<strong>{{context.employee.assignedToProject.name}}</strong>
											</legend>
											
										</div>
										<div class="col-md-3" ng-if="context.category.type=='NON_PAYROLL' && userRole=='Finance'">
											<div class="col-md-12 ">Manager Email</div>
											
											<legend class="col-md-12 legend_borderless">
											<strong>{{context.manageremail}}</strong>
											</legend>
											
										</div>
										
									</div>
								
								
							<div class="row">
								<div class="col-md-12">
									<table class="table table-striped table-hover table-bordered">
										<thead>
											<tr>
												<th>
													<input type="checkbox" ng-click="toggleAll()">
												</th>
												<th>
													# 
												</th>
												<th>
													Bill Number
												</th>
												<th>
													Bill Date
												</th>
												<th>
													Description
												</th>
												<th>
													Amount Requested
												</th>
												<th>
													Exchange Rate
												</th>
												<th ng-if="context.category.type=='NON_PAYROLL' && userRole=='Finance'">
													Manager Approval
												</th>
												<th>	
													Documents
												</th>
											</tr>
										</thead>
										<tbody>
											<tr ng-repeat = "(i,reimbursementItem) in context.items">
												<td>
													<!-- <span ng-if="userRole=='Finance' && context.category.type=='NON_PAYROLL' && !reimbursementItem.managerApproved"></span>
													<span ng-if="!(userRole=='Finance' && context.category.type=='NON_PAYROLL' && !reimbursementItem.managerApproved)">
														<input type="checkbox" checked ng-click="toggleItem(reimbursementItem.id,reimbursementItem.amount)" ng-if="reimbursementItem.approved">
														<input type="checkbox" ng-click="toggleItem(reimbursementItem.id,reimbursementItem.amount)" ng-if="!reimbursementItem.approved">
													</span> -->
													<span ng-if="userRole=='Finance'">
														<span ng-if="context.category.type=='NON_PAYROLL' && !reimbursementItem.managerApproved">
														</span>
														<span ng-if="!(context.category.type=='NON_PAYROLL' && !reimbursementItem.managerApproved)">
															<input type="checkbox" checked ng-click="toggleItem(reimbursementItem.id,reimbursementItem.amount)" ng-if="reimbursementItem.financeApproved">
															<input type="checkbox" ng-click="toggleItem(reimbursementItem.id,reimbursementItem.amount)" ng-if="!reimbursementItem.financeApproved">
														</span>
													</span>
													<span ng-if="userRole=='Manager'">
														<input type="checkbox" checked ng-click="toggleItem(reimbursementItem.id,reimbursementItem.amount)" ng-if="reimbursementItem.managerApproved">
														<input type="checkbox" ng-click="toggleItem(reimbursementItem.id,reimbursementItem.amount)" ng-if="!reimbursementItem.managerApproved">
													</span>
												</td>
												<td>
													{{i+1}}
												</td>
												<td>
													{{reimbursementItem.billNumber}}
												</td>
												<td class="col-md-1">
													{{reimbursementItem.billDate|date:'dd-MM-yyyy'}}
												</td>
												<td>
													{{reimbursementItem.description}}
												</td>
												<td>
													{{reimbursementItem.amount / reimbursementItem.exchangeRate | currency:reimbursementItem.currency:true}}
												</td>
												<td>
													{{reimbursementItem.exchangeRate | number}}
												</td>
												<td ng-if="context.category.type=='NON_PAYROLL' && userRole=='Finance'">
													<span ng-if="reimbursementItem.managerApproved">Approved</span>
													<span ng-if="!reimbursementItem.managerApproved">Rejected</span>
												</td>
												<td>
													<a target="_blank" href="download?fileName={{reimbursementItem.fileName}}">Download</a>
												</td>
											</tr>
											
										</tbody>
									</table>
								</div>
								
								<!-- 
								 -->
								
								<div class="row">
										<div class="col-md-2">
											<div class="col-md-12">Amount Requested</div>
											
											<legend class="col-md-12 legend_borderless">
											<strong>{{context.amountRequested |
									currency:'INR'}}</strong>
											</legend>
											
										</div>
										<div class="col-md-2">
											<div class="col-md-12 ">Amount Approved</div>
											
											<legend class="col-md-12 legend_borderless">
											<strong>{{context.amountApproved |
									currency:'INR'}}</strong>
											</legend>
											
										</div>
										<div class="col-md-4" ng-if="context.category.type=='NON_PAYROLL' && userRole=='Finance'">
											<div class="col-md-12 ">Manager Comments</div>
											
											<legend class="col-md-12 legend_borderless">
											<strong>{{context.managerComments}}</strong>
											</legend>
											
										</div>
										
									</div>
								<form action="processRequest" method="post">

									<div class="col-sm-12">
									<div class="form-group">
									<label for="comment">
									Comment
									</label>
									<textarea id="comment" ng-if="userRole=='Manager'" rows="3" class="form-control" required="true" name="comment" maxlength="250">{{context.managerComments}}</textarea>
									<textarea id="comment" ng-if="userRole=='Finance'" rows="3" class="form-control" required="true" name="comment" maxlength="250">{{context.financeComments}}</textarea>
									</div>
									<input type="hidden" name="reimbursementId" value="{{context.id}}">
									<input type="hidden" name="selectedItemsString" value="{{selectedItems}}" >
									
									</div>
									
									<div class="row text-center">
									<input type="submit" class="btn btn-default" value="Approve" name="action" onclick="return checkEmpty()">
									<input type="submit" class="btn btn-default" value="Save as Draft" name="action">
									</div>
									
									</form>
								
							</div>
							
						</div>
						<div class="panel-footer">
							<div class="alert alert-info"><strong>Note:</strong>
								<ul>
									<li>Select items for approval using the chekboxes provided in formt of each item</li>
									<li>Unselected items will be automatically rejected</li>
									<li>Comments are mandatory(max size 250 Characters)</li>
									<li>Checkbox in table header can be used to select/deselect all items at once</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
		
	
	<script>
	
		function checkEmpty(event){
			var string=$(document).find('input[name="selectedItemsString"]').val();
			if(string=='[]'){
				return confirm('All items in this request will be rejected since you have not selected any. Do you want to continue?');
			}
			return true;
		}
		
		function openEditNav() {
			document.getElementById("myEditSidenav").style.width = "100%";
		}
		
		function closeEditNav() {
			document.getElementById("myEditSidenav").style.width = "0%";
		}
		var app = angular.module("adminApp", []);
		app.controller('adminCtrl', function($scope) {
			
			$scope.reimbursementRequests = ${reimbursementRequests};
			$scope.reimbursementItemsMap = {};
			$scope.userRole='${sessionScope.role}';
			
			$scope.formatDate=function(){
				$scope.reimbursementRequests.forEach(request=>{
					request.submissionDate=Date.parse(request.submissionDate);
					request.items.forEach(item=>{
						item.billDate=Date.parse(item.billDate);
					});
				});
			}
			$scope.formatDate();
			
			$scope.convertToMap = function( list ) {
				
				var _ctr = 0,
				_totalItems = $scope.reimbursementRequests.length,
				_context = {};
				
				for ( _ctr; _ctr < _totalItems; _ctr = _ctr + 1 ) {
					$scope.reimbursementItemsMap[ $scope.reimbursementRequests[ _ctr ].id ]	= $scope.reimbursementRequests[ _ctr ];
				}
			};
			
			$scope.convertToMap();
		
			$scope.selectedItems=[];
			
			$scope.toggleCheckboxes=function(value){
				$('.panel-body').find('input[type="checkbox"]').prop('checked',value);
			}
			
			$scope.toggleAll=function(){
				if($scope.selectedItems.length!=$scope.context.itemIds.length){
					$scope.selectedItems=$scope.context.itemIds;
					$scope.context.amountApproved=$scope.context.totalAmount;
					$scope.toggleCheckboxes(true);
				}else{
					$scope.selectedItems=[];
					$scope.context.amountApproved=0;
					$scope.toggleCheckboxes(false);
				}
			}
			
			$scope.toggleItem=function(itemId,itemAmount){
				if($scope.selectedItems.indexOf(itemId)==-1){
					$scope.selectedItems.push(itemId);
					$scope.context.amountApproved+=itemAmount;
					if($scope.selectedItems.length==$scope.context.itemIds.length)
						$scope.toggleCheckboxes(true);
				}else{
					if($scope.selectedItems.length==$scope.context.itemIds.length)
						$('.panel-body').find('thead').find('input[type="checkbox"]').prop('checked',false);
					$scope.selectedItems.splice($scope.selectedItems.indexOf(itemId),1);
					$scope.context.amountApproved-=itemAmount;
				}
			}
			
			$scope.openNav = function( id ,  i) {
				document.getElementById("mySidenav").style.transform="translateY(10%)";
				$scope.convertToMap();
				$scope.toggleCheckboxes(false);
					var _context = $scope.reimbursementItemsMap[ id ];
					$scope.context = _context;
					$scope.context.itemIds=[];
					$scope.context.totalAmount=0;
					if($scope.userRole=='Manager'){
						$scope.context.totalAmount=$scope.context.amountRequested;
					}else if($scope.userRole=='Finance'){
						if($scope.context.category.type=='PAYROLL')
							$scope.context.totalAmount=$scope.context.amountRequested;
						else if($scope.context.category.type=='NON_PAYROLL'){
							if($scope.context.state=='WITH_FINANCE')
								$scope.context.amountApproved=0;
							$scope.context.items.forEach((item)=>{
								if(item.managerApproved)
									$scope.context.totalAmount+=item.amount;
							});
						}
					}
					$scope.selectedItems=[];
					if($scope.userRole=='Manager'){
						$scope.context.items.forEach(item=>{
							$scope.context.itemIds.push(item.id);
							if(item.managerApproved){
								$scope.selectedItems.push(item.id);
							}
						});
					}
					else if($scope.userRole=='Finance'){
						$scope.context.items.forEach(item=>{
							if($scope.context.category.type=='PAYROLL')
								$scope.context.itemIds.push(item.id);
							else if ($scope.context.category.type=='NON_PAYROLL') {
								if(item.managerApproved)
									$scope.context.itemIds.push(item.id);
							}
							if(item.financeApproved){
								$scope.selectedItems.push(item.id);
							}
						});
					}
			};
			$scope.closeNav = function() {
				document.getElementById("mySidenav").style.transform="translateY(-100%)";
			};
		});
	</script>
	
</body>
</html>