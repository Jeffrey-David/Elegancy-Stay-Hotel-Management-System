<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Booking</title>
    <%@include file="all_component/allCss.jsp"%>
    <link rel="stylesheet" href="all_component/style.css">
</head>
<body>
    <%@include file="all_component/NavBarAdmin.jsp"%>
    <p><br></p>
    <div class="container">
        
            <div class="row mt-2">
                <div class="col-md-6 offset-md-3 text-center">
                <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color: white;">
                    <h2 class="text-center" style="font-weight: 600">Booking Details</h2>
                    <table class="table table-striped">
                        <tbody>
                            <!-- Display the booking information with transposed layout -->
                            <tr>
                                <th>Booking ID:</th>
                                <td>${booking.bookingID}</td>
                            </tr>
                            <tr>
                                <th>Email ID:</th>
                                <td>${booking.emailId}</td>
                            </tr>
                            <tr>
                                <th>Name:</th>
                                <td>${booking.name}</td>
                            </tr>
                            <tr>
                                <th>No of Rooms:</th>
                                <td>${booking.noOfRooms}</td>
                            </tr>
                            <tr>
                                <th>DOB:</th>
                                <td>${booking.DOB}</td>
                            </tr>
                            <tr>
                                <th>Mobile Number:</th>
                                <td>${booking.mobNum}</td>
                            </tr>
                            <tr>
                                <th>Meal Plan:</th>
                                <td>${booking.mealPlan}</td>
                            </tr>
                            <tr>
                                <th>Check-In Date:</th>
                                <td>${booking.checkIn}</td>
                            </tr>
                            <tr>
                                <th>Check-Out Date:</th>
                                <td>${booking.checkOut}</td>
                            </tr>
                            <tr>
                                <th>Bedding Type:</th>
                                <td>${booking.beddingType}</td>
                            </tr>
                            <tr>
                                <th>Room Type:</th>
                                <td>${booking.roomType}</td>
                            </tr>
                            <tr>
                                <th>Cost (SGD$):</th>
                                <td>${booking.costNum}</td>
                            </tr>
                            <tr>
                                <th>Address:</th>
                                <td>${booking.address}</td>
                            </tr>
                            <tr>
                                <th>Total Cost (SGD$):</th>
                                <td>${booking.totalCost}</td>
                            </tr>
                            <tr>
                                <th>Payment Status</th>
                                <td>${payment}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div align="center" style="margin-bottom: 100px; margin-top: 20px">
        <a href="ListBookingServlet" class="btn btn-primary" style="background-color:#ff6600; border:none">Back to List</a>
    </div>
<p><br><br><br><br></p>
    <div class="footer">
        <p>&copy; 2023 Our Hotel. All rights reserved. | <a href="#">Contact Us</a></p>
    </div>
</body>
</html>
