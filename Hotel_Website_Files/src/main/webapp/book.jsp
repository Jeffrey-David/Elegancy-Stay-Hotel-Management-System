<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@include file="all_component/allCss.jsp"%>

<link rel="stylesheet" href="all_component/style.css">
</head>
<body>
<%@include file="all_component/navbar.jsp"%>
<p><br></p>
  <div class="container-fluid back-img">
        <div class="row">
            <div class="col-md-8 offset-md-2 text-center">
            <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color:white;  margin-bottom: 100px;">
					<div class="card-body">
				    <h2 style="font-weight:600">Rooms and Rates</h2>
				    <div class="room-container" style="height: 400px; overflow: auto;">
				    <table border="0px" cellspacing="3px" cellpadding="10px" style="color:black" align="center">
				        <c:forEach items="${productList}" var="product">
				          <td>
							    <div class="room-card">
							        <img src="data:image/jpg;base64,${product.base64Image}" width="220" height="150" /><br>
							        <div class="card">
							            <div class="card-body">
							                <h5 class="card-title">${product.roomType}</h5>
							                <p class="card-text">$${product.costNum}</p>
							                <a href="CheckAvailability.jsp?roomType=${product.roomType}&costNum=${product.costNum}">
							                    <button class="btn btn-primary" style="width: 90%; background-color:#ff6600; border:none">Book Now</button>
							                </a>
							            </div>
							        </div>
							    </div>
							</td>

        </c:forEach>
  </table>
  </div>
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