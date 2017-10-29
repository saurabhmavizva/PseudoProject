<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CHANGE PASSOWRD ${sessionScope.name }</title>
<style type="text/css">
.panel-title {
	text-align: center;
}

.account {
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
											<h3 class="panel-title">CHANGE PASSWORD</h3>
										</div>
										<div class="panel-body">
											<form role="form" action="changepasswordform" method="post" onsubmit="return(check())">
												<div class="form-group">
													<label for="currentPassword"> Enter Current Password  </label> <input
														type="password" class="form-control" id="currentpassword"
														name="currentpassword" required="required" pattern="(?=^.{8,15}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" />
												</div>
												<div class="form-group">

													<label for="password"> Enter New Password </label> <input
														type="password" class="form-control" id="password"
														name="password" required="required" pattern="(?=^.{8,15}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" />
												</div>
												<div class="form-group">

													<label for="passwordconf"> Confirm new Password </label> <input
														type="password" class="form-control" id="passwordconf"
														 required="required" pattern="(?=^.{8,15}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" />
												</div>
												
												<button value="submit" type="submit" class="btn btn-primary">Change Password</button>

											</form>


										</div>
																			<span id="message"></span>
										
										
									</div>
								</div>
								
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
<script>
	var check = function() {
  if (document.getElementById('password').value == document.getElementById('passwordconf').value) {
    return true;
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = '<div class="panel-footer"> <div class="alert alert-info"> <strong class="text-center">${passwordNotMatchError}</strong> </div> </div>';
    return false;
  }
}
	</script>	
	
</body>
</html>