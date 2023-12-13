<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Booking Successful</title>
    <%@include file="all_component/allCss.jsp"%>
    <link rel="stylesheet" href="all_component/style.css">
</head>
<body>
    <%@include file="all_component/navbar.jsp"%>
    <p><br></p>
    <div class="container">
        <div class="row mt-2">
            <div class="col-md-8 offset-md-2">
                <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color: white">
                    <div class="card-body">
                        <h4 class="text-center"><%= request.getAttribute("message") %></h4>
                        <p class="text-center">
                            <strong></strong> <%= request.getAttribute("details") %><br><br><br>
                        </p>
                        <div class="text-center">
                            <a href="<%= request.getAttribute("nextURL") %>" class="btn btn-primary" style="background-color: #ff6600; border: none;">Close</a>
                        </div>
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
