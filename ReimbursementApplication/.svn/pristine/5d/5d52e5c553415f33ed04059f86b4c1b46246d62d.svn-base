<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" href="https://bootswatch.com/simplex/bootstrap.min.css">
	
	<style type="text/css">
		.panel.panel-primary {
  			margin-top: 250px;
		}
	</style>
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
				<span id="message"></span>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								FIRST TIME USER
							</h3>
						</div>
						<div class="panel-body">
						<legend> Reset Password  </legend>
							<form role="form" action="firsttimepassupdate" method="post" onsubmit="return(check())">
						<div class="form-group">
							<label for="password">
								Enter New Password
							</label>
							<input type="password" class="form-control" id="password" name="password" required="required" pattern="(?=^.{8,15}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" />
						</div>
						<div class="form-group">
							 
							<label for="passwordInput">
								Confirm Password
							</label>
							<input type="password" class="form-control" id="passwordInput" required="required" pattern="(?=^.{8,15}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" />
						</div>
						
						<button type="submit" class="btn btn-default">
							Reset Password
						</button>
						
					</form>
						
						
						</div>
						<div class="panel-footer">
						<div class="alert alert-info">
							<strong>Password Policy:</strong> Password Must have One Uppercase , One Lowercase, One Number and One Special Character 
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

<script>
	var check = function() {
  if (document.getElementById('password').value == document.getElementById('passwordInput').value) {
    return true;
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = '<h2 class="text-center">Password Not matching</h2>';
    return false;
  }
}
	</script>


</body>
</html>
