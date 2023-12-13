<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View My Booking</title>
    <%@include file="all_component/allCss.jsp"%>
    <link rel="stylesheet" href="all_component/style.css">
</head>
<body>
    <%@include file="all_component/navbar.jsp"%>

    <div class="container">
        <div class="row mt-2">
            <div class="col-md-8 offset-md-2">
                <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color: white">
                    <div class="card-body">
                        <h4 class="text-center">View My Booking</h4>
                        <form action="ViewMyBookingServlet" method="post">
                            <div class="form-group">
                                <label for="email">Enter your Email ID:</label>
                                <input type="email" class="form-control" id="email" name="emailId" required>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary" style="background-color: #ff6600; border: none;">View Bookings</button>
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
