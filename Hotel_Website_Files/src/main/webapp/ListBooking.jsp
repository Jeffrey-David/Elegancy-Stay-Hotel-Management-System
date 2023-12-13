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
    <%@include file="all_component/NavBarAdmin.jsp"%>
    <p><br></p>
    <div class="container">
        <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color: white;">
            <div class="row mt-2">
                <div class="col-md-12">
                    <h2 class="text-center" style="font-weight: 600">List of Bookings</h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Booking ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Check-In Date</th>
                                <th>Check-Out Date</th>
                                <th>Payment Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Loop through the list of bookings and display them in the table -->
                            <c:forEach items="${bookings}" var="booking" varStatus="loop">
                                <tr>
                                    <td>${booking.bookingID}</td>
                                    <td>${booking.name}</td>
                                    <td>${booking.emailId}</td>
                                    <td>${booking.checkIn}</td>
                                    <td>${booking.checkOut}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${paymentStatusList[loop.index]}">Paid</c:when>
                                            <c:otherwise>
									            Pending
									        </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <!-- View button that redirects to view booking details -->
                                        <a href="ViewBookingServlet?bookingID=${booking.bookingID}" class="btn btn-primary" style="background-color: blue; border: none;">View</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <!-- Delete button (You can implement this functionality) -->
                                        <a href="DeleteBookingServlet?bookingID=${booking.bookingID}" class="btn btn-primary" style="background-color: red; border: none;">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div align="center" style="margin-bottom: 100px; margin-top: 20px">
            <a href="welcome.jsp" class="btn btn-primary" style="background-color: #ff6600; border: none">&nbsp;&nbsp;&nbsp;Home&nbsp;&nbsp;&nbsp;</a>
        </div>
    </div>
    <p><br><br><br><br></p>
    <div class="footer">
        <p>&copy; 2023 Our Hotel. All rights reserved. | <a href="#">Contact Us</a></p>
    </div>
</body>
</html>
