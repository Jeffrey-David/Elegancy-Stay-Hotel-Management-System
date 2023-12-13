<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Rooms</title>
    <%@include file="all_component/allCss.jsp"%>
    <link rel="stylesheet" href="all_component/style.css">
</head>
<body>
    <%@include file="all_component/NavBarAdmin.jsp"%>
    <p><br></p>
    <div class="container">
    <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color:white;">
        <div class="row mt-2">
            <div class="col-md-12">
                <h2 class="text-center" style="font-weight:600">List of Rooms</h2>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Room Type</th>
                            <th>No of Rooms</th>
                            <th>Cost (SGD$)</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Loop through the list of rooms and display them in the table -->
                        <c:forEach items="${roomList}" var="room">
                            <tr>
                                <td>${room.roomType}</td>
                                <td>${room.noOfRooms}</td>
                                <td>${room.costNum}</td>
                                <td>
                                    <!-- Edit button that redirects to EditRoom.jsp with room ID -->
                                    <a href="EditRoomsServlet?roomId=${room.id}&roomType=${room.roomType}" class="btn btn-primary"style="background-color:blue; border:none;">Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <!-- Delete button (You can implement this functionality) -->
                                    <a href="DeleteRoomServlet?roomId=${room.id}" class="btn btn-primary" style="background-color:red; border:none;">Delete</a>

                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                    </tbody>
                </table>

            </div>
        </div>
        
    </div>
<div align="center" style =" margin-bottom: 100px; margin-top: 20px">   
<a href="welcome.jsp" class="btn btn-primary" style="background-color:#ff6600; border:none">&nbsp;&nbsp;&nbsp;Home&nbsp;&nbsp;&nbsp;</a>
</div>
	</div>
<p><br><br><br><br></p>
<div class="footer">
    <p>&copy; 2023 Our Hotel. All rights reserved. | <a href="#">Contact Us</a></p>
</div>
</body>
</html>
