<%@page import="com.avizva.utility.PasswordUtility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<head>
	<title>Login</title>
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
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								AVIZVA
							</h3>
						</div>
						<div class="panel-body">
							<form role="form" action="perform_login" method="post">
						<div class="form-group">
							 
							<label for="emailInput">
								Enter Email address
							</label>
							<input type="email" class="form-control" id="emailInput" name="email" required="required" />
						</div>
						<div class="form-group">
							 
							<label for="passwordInput">
								Enter Password
							</label>
							<input type="password" class="form-control" id="passwordInput" name="password" required="required" pattern="(?=^.{8,15}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" />
						</div>
						
						<button type="submit" class="btn btn-default">
							Log In
						</button>
					</form>
						
						
						</div>
						<div class="panel-footer">
						<a href="forgotpassword">	Forgot Password ... </a>
						</div>
					</div>
				</div>
				<div class="col-md-4">
				</div>
			</div>
		</div>
	</div>
</div>
<%-- 	<%  --%>
<!--  		request.setAttribute("password",PasswordUtility.encryptPassword(request.getParameter("password"))); -->
<!--  		request.getParameterMap().put("password", PasswordUtility.encryptPassword(request.getParameter("password"))); -->
<%-- 	%> --%>

</body>
</html>
