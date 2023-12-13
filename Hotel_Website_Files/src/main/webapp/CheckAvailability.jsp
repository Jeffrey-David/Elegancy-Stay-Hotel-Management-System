
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Check Availability</title>
    <%@include file="all_component/allCss.jsp"%>
    <link rel="stylesheet" href="all_component/style.css">
</head>
<body>
    <%@include file="all_component/navbar.jsp"%>
    <p><br></p>
    <div class="container">
        <div class="row mt-2">
            <div class="col-md-6 offset-md-3">
                <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color:white">
                    <div class="card-body">
                        <h2 class="text-center" style="font-weight:600">Check Room Availability</h2>
                        <form action="CheckAvailabilityServlet" method="post">
                            <div class="form-group">
							    <label for="roomType">Room Type</label>
							    <input type="text" class="form-control" id="roomType" name="roomType" value="${param.roomType}" readonly="readonly" required="required">
							</div>
							<div class="form-group">
							    <label for="costNum">Room Cost</label>
							    <input type="text" class="form-control" id="costNum" name="costNum" value="${param.costNum}" readonly="readonly" required="required">
							</div>
							<div class="form-group">
							    <label for="checkInDate">Check-In Date</label>
							    <input type="date" class="form-control" id="checkInDate" name="checkInDate" required="required">
							</div>
							<div class="form-group">
							    <label for="checkOutDate">Check-Out Date</label>
							    <input type="date" class="form-control" id="checkOutDate" name="checkOutDate" required="required">
							</div>
							<div align="center">
							<button type="submit" class="btn btn-primary" style="background-color:#ff6600; border:none">Check Availability</button>
							</div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <p><br><br><br><br></p>
    <div class="footer">
    <p>&copy; 2023 Our Hotel. All rights reserved. | <a href="ContactUs.jsp">Contact Us</a></p>
	</div>
</body>
</html>