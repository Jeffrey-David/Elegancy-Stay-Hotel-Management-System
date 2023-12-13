<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Bookings</title>
    <%@include file="all_component/allCss.jsp"%>
    <link rel="stylesheet" href="all_component/style.css">
</head>
<body>
    <%@include file="all_component/navbar.jsp"%>
    <p><br></p>
    <div class="container">
        <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color: white;">
            <div class="row mt-2">
                <div class="col-md-12">
                    <h2 class="text-center" style="font-weight: 600">List of Bookings</h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Check-In Date</th>
                                <th>Check-Out Date</th>
                                <th>Room Type</th>
                                <th>Number of Rooms</th>
                        		<th>Total Cost</th>
                                <th>Payment Status</th> <!-- New column for payment status -->
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Loop through the list of bookings and display them in the table -->
                            <c:forEach items="${userBookings}" var="booking" varStatus="loop">
                                <tr>
                                    <td>${booking.name}</td>
                                    <td>${booking.emailId}</td>
                                    <td>${booking.checkIn}</td>
                                    <td>${booking.checkOut}</td>
                                    <td>${booking.roomType}</td>
                                    <td>${booking.noOfRooms}</td>
                                    <td>${booking.totalCost}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${paymentStatusList[loop.index]}">Paid</c:when>
                                            <c:otherwise>
									            <a href="payment.jsp?bookingID=${booking.bookingID}&amount=${booking.totalCost}" class="btn btn-primary" style="background-color: #ff6600; border: none">Pay Now</a>

									        </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div align="center" style="margin-bottom: 100px; margin-top: 20px">
            <a href="index.jsp" class="btn btn-primary" style="background-color: #ff6600; border: none">&nbsp;&nbsp;&nbsp;Home&nbsp;&nbsp;&nbsp;</a>
        </div>
    </div>
    <p><br><br><br><br></p>
    <div class="footer">
        <p>&copy; 2023 Our Hotel. All rights reserved. | <a href="ContactUs.jsp">Contact Us</a></p>
    </div>
</body>
</html>
