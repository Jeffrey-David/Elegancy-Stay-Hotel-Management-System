<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Our Hotel</title>
<%@include file="all_component/allCss.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
body {
    background: url("image/hotel_background.jpg") no-repeat center center fixed;
    background-size: cover;
    min-height: 100vh;
    background-color: #000000; /* Set the desired pale background color */
    background-blend-mode: exclusion;
    display: flex;
    flex-direction: column;
}
.welcome-container {
    flex-grow: 1; /* Take up available space */
    display: flex;
    flex-direction: column;
    justify-content: flex-end; /* Push content to the bottom */
    text-align: center;
    color: white;
    padding: 20px 0;
}
.welcome-message {
    font-size: 36px;
    font-weight: bold;
    text-shadow: 2px 2px 4px #000000;
}
.btn-book-now-container {
  
    padding: 20px 0;
    text-align: center;
}
.btn-book-now {
    padding: 10px 20px;
    font-size: 18px;
    background-color: #ff6600;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}
.btn-book-now:hover {
    background-color: #e65400;
}
.footer {
    background-color: #222;
    color: #fff;
    padding: 20px 0;
    text-align: center;
}
.footer a {
    color: #ff6600;
    text-decoration: none;
}
.footer a:hover {
    text-decoration: underline;
}
</style>
</head>
<body>
<%@include file="all_component/navbar.jsp"%>

<div class="welcome-container">
    <div class="welcome-message">
        Indulge in Luxurious Comfort at Our Exquisite Hotel
    </div>
</div>

<div class="btn-book-now-container">
    <a href="BookServlet">
        <button class="btn-book-now">Book Now</button>
    </a>
</div>

<div class="footer">
    <p>&copy; 2023 Our Hotel. All rights reserved. | <a href="#">Contact Us</a></p>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
