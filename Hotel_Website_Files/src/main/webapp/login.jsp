<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hotel: Login</title>
<%@include file="all_component/allCss.jsp"%>

<link rel="stylesheet" href="all_component/style.css">
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<p><br>
	<br></p>
	<div class="container">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card" style="background-color: rgba(0, 0, 0, 0.8); color:white">
					<div class="card-body">
						<h2 class="text-center">Login</h2>
						<br>
						<form action="LoginServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="emailId">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="pass">
							</div>
							<div class="text-center">
								<br>
								<button type="submit" class="btn btn-primary" style="background-color:#ff6600; border:none">Login</button>
								<br><br> <a href="registration.jsp" style="color:#ff6600">Create account</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<p><br><br><br><br></p>
<div class="footer">
    <p>&copy; 2023 Our Hotel. All rights reserved. | <a href="#">Contact Us</a></p>
</div>
</body>
</html>