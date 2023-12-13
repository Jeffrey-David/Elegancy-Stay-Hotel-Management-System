<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hotel: hotelHome</title>
<%@include file="all_component/allCss.jsp"%>
<link rel="stylesheet" href="all_component/style.css">
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card" style="background-color: rgba(0, 0, 0, 0.8); color:white">
					<div class="card-body">
						<h4 class="text-center">Registration Page</h4>
						<form action="RegistrationServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name ="userName">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="emailId">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Phone number</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="mobNum">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" required="required" name="pass">
							</div>
							<div align="center">
							<button type="submit" class="btn btn-primary" style="background-color:#ff6600; border:none">Submit</button>
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