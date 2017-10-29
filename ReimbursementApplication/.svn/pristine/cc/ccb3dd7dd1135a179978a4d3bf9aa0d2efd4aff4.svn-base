<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link rel="stylesheet"
	href="https://bootswatch.com/simplex/bootstrap.min.css">

</head>
<body>

					<%-- <select name="designationId">
						<c:forEach items="${designations }" var="designation">
							<option value='<c:out value="designation.Id"></c:out>'> <c:out value="designation.name"></c:out> </option>
						</c:forEach>
						</select> --%>
						
						
						<%-- <select name="assignedToProjectId">
						<c:forEach items="${projects }" var="project">
							<option value='<c:out value="project.Id"> </c:out>' > <c:out value="project.name"></c:out></option>
						</c:forEach>
					</select> --%>

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="jumbotron well">
						<h2>Global Content</h2>
					</div>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">ADD EMPLOYEE</h3>
								</div>
								<div class="panel-body">
									<form role="form" action="register" method="post">
										<legend>Register Employee</legend>

										<div class="form-group">

											<label for="firstName"> Enter Employee's First Name </label>
											<input type="text" class="form-control" id="empId"
												name="firstName" required="required" />
										</div>

										<div class="form-group">

											<label for="lastName"> Enter Employee's Last Name </label> <input
												type="text" class="form-control" id="lastName"
												name="lastName" required="required" />
										</div>

										<div class="form-group">

											<label for="emailInput"> Enter Employee's Email </label> <input
												type="email" class="form-control" id="emailInput"
												name="email" required="required" />
										</div>


										<div class="form-group">
											<label for="project">Enter Project</label>
												<select name="assignedToProjectId" class="form-control" id="project">
													<option>-- None Yet --</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
										</div>
										
										<div class="form-group">
											<label for="designation">Enter Designation</label>
												<select class="form-control" id="desgination">
													<option>-- None Yet --</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
										</div>
										<div class="form-group">
											<label for="project">Define Role</label>
												<select class="form-control" id="project">
													<option>-- None Yet --</option>
													<option value="">Employee</option>
													<option value="">Manager</option>
													<option value="">Finance</option>
													<option value="">Admin</option>
												</select>
										</div>

												<div class="checkbox">
													<label> <input type="checkbox" checked="checked" name="enabled"> Employee
														Active
													</label>
												</div>

												<button type="submit" class="btn btn-default">Add Employee</button>
									</form>


								</div>
							</div>
						</div>
						<div class="col-md-4"></div>
					</div>
				</div>
			</div>
		</div>


</body>
</html>