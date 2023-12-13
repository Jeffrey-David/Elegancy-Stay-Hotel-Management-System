<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Room Information</title>
    <%@include file="all_component/allCss.jsp"%>
    <link rel="stylesheet" href="all_component/style.css">
</head>
<body>
    <%@include file="all_component/NavBarAdmin.jsp"%>
    <p><br></p>
    <div class="container">
        <div class="row mt-2">
            <div class="col-md-6 offset-md-3">
                <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color:white;  margin-bottom: 100px;">
                    <div class="card-body">
                        <h2 class="text-center" style="font-weight:600">Edit Room Information</h2>
                        <form action="EditRoomServlet" method="post" enctype="multipart/form-data">
                            <!-- Hidden input field for room ID -->
                            <input type="hidden" name="roomId" value="${room.id}">
                            
                            <label for="roomType">Room Type</label>
                            <input type="text" class="form-control" id="roomType" name="roomType" value="${room.roomType}" readonly>
                            
                            <!-- Other fields for editing -->
                            <label for="noOfRooms">No of Rooms</label>
                            <input type="number" class="form-control" id="noOfRooms" name="noOfRooms" value="${room.noOfRooms}">
                            
                            <label for="costNum">Cost (SGD$)</label>
                            <input type="number" class="form-control" id="costNum" aria-describedby="emailHelp" required="required" name="costNum" value="${room.costNum}">
                            
                            <label for="image">Upload New Image (Optional)</label>
                            <input type="file" name="newImage" class="form-control">
                            <br><br>
                            <div align="center">
                            <button type="submit" class="btn btn-primary" style="background-color:#ff6600; border:none">Save Changes</button>
                            &nbsp;&nbsp;&nbsp;<a href="ListRoomsServlet" class="btn btn-primary" style="background-color:#ff6600; border:none">&nbsp;Back&nbsp;</a>
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
