<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<head>
<title>Error</title>
</head>
<body>

	<div class="container-fluid">
		<jsp:include page="includes/header.jsp"></jsp:include>
			<div class="row">
				<div class="col-sm-3 col-md-2 col-lg-2">
					<jsp:include page="includes/navigationMenu.jsp"></jsp:include>
				</div>
				<div class="col-lg-8 ">
					<div class="jumbotron alert-danger ">
						<p>
						<h1>Oh Snap!</h1>
						<br> Something Went Wrong. Please Try Again Later.
						</p>
					</div>
				</div>
			</div>
	</div>
</body>
</html>
