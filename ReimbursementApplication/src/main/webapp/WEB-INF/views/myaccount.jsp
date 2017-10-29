<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Account</title>
<style type="text/css">
	.panel-title{
		text-align: center;
	}
	.account{
		margin-top: 100px;
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
			<div class="col-sm-10">
			<div class="container-fluid">
			<div class="row account">
				<div class="col-md-12">
					
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">YOUR DETAILS</h3>
								</div>
								<div class="panel-body">
									<form role="form">
										

										<div class="form-group row">
											<label class="col-sm-5">  Employee Id </label>
											<span  class="col-sm-7"> ${employee.employeeId} </span> 
											<!-- 101 to be replaced with ${employee.employeeId}  -->
											
										</div>

										<div class="form-group row" >

											<label class="col-sm-5">  Name </label>
											<span  class="col-sm-7"> ${employee.firstName} ${employee.lastName} </span> 
											<!-- First Last to be replaced with ${employee.firstName} ${employee.lastName}  -->
										</div>

										<div class="form-group row" >

											<label class="col-sm-5"> Email </label>
											<span  class="col-sm-7"> ${employee.email} </span> 
											<!-- abc@gmail.com to be replaced with ${employee.email}  -->
										</div>


										<div class="form-group row" >

											<label class="col-sm-5"> Designation </label>
											<span  class="col-sm-7"> ${employee.designation.name} </span> 
											<!-- Developer to be replaced with ${employee.designation}  -->
										</div>
										
										<div class="form-group row" >

											<label class="col-sm-5"> Project </label>
											<span  class="col-sm-7"> ${employee.assignedToProject.name} </span> 
											<%-- Project to be replaced with ${employee.project} --%>
										</div>
											
									</form>


								</div>
							</div>
						</div>
						<div class="col-md-3"></div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">CHANGE PASSWORD</h3>
								</div>
								<div class="panel-body">
										<div class="row">
										<label class="col-md-4"></label>
												<a href="changepassword"><button type="submit" class="btn btn-default col-md-4">CHANGE PASSWORD</button></a>
										<label class="col-md-4"></label>
										</div>


								</div>
							</div>
						</div>
						<div class="col-md-3"></div>
					</div>
				</div>
			</div>
		</div>

			</div>
		</div>
	</div>
</body>
</html>