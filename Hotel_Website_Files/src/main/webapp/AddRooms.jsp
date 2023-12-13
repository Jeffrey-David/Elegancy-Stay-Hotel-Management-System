<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<meta charset="ISO-8859-1">
<title>Add Rooms Page</title>
<%@include file="all_component/allCss.jsp"%>
<link rel="stylesheet" href="all_component/style.css">
</head>
<body>
    <%@include file="all_component/NavBarAdmin.jsp"%>
    <p></p>
	<div class="container">
		<div class="row mt-2">
			<div class="col-md-6 offset-md-3">
				<div class="card" style="background-color: rgba(0, 0, 0, 0.8); color:white;  margin-bottom: 100px;">
					<div class="card-body">
						<h2 class="text-center">Add Rooms</h2>
						<form action="AddRoomsServlet" enctype="multipart/form-data" method="post">
							<div class="form-group">
								<label for="exampleFormControlSelect1">Room Type</label> <input
									type="text" class="form-control" id="exampleFormControlSelect1" name="roomType">
							</div>
							<div class="form-group">
								<label for="exampleFormControlSelect1">No of Rooms</label> <input 
									type="number" class="form-control" id="exampleFormControlSelect1" name="noOfRooms">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Cost (SGD$)</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="costNum">
							</div>
							<div class="card" style="background-color: rgba(0, 0, 0, 0.3); color:white">
								<div class="card-body">
										<div class="mb-3">
											<label>Upload Image</label><br><input type="file" name="files"
												class="form-control">
										</div>
								</div>
							</div>
							<div align="center">
							<button type="submit" class="btn btn-primary" style="background-color:#ff6600; border:none">&nbsp;&nbsp;Submit&nbsp;&nbsp;</button>    
							&nbsp;&nbsp;&nbsp;<a href="welcome.jsp" class="btn btn-primary" style="background-color:#ff6600; border:none">&nbsp;Back&nbsp;</a>
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