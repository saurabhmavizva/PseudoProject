<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<head>
	<style type="text/css">
		.panel.panel-primary {
	    	margin-top: 250px;
		}
	</style>
	<title>Forgot Password</title>
</head>
<body>

<div class="container-fluid">
		<jsp:include page="includes/header.jsp"></jsp:include>
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-4">
					
				</div>
				<div class="col-md-4 ">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								FORGOT PASSWORD
							</h3>
						</div>
						<div class="panel-body">
					<form role="form" action="forgotpasswordform" method="post">
						<div class="form-group">
							 
							<label for="emailInput">
								Enter Email address
							</label>
							<input type="email" class="form-control" id="emailInput" name="email" required="required" />
						</div>
						
						<button type="submit" class="btn btn-default">
							Change Password
						</button>
					</form>
						
						
						</div>
						<div class="panel-footer">
						<div class="alert alert-info">
							<strong>ALERT:</strong> Make sure you are registered with this email address 
						</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
				</div>
			</div>
		</div>
	</div>
</div>


</body>
</html>
