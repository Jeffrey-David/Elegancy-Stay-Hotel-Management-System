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
                    <h2 style="font-weight:600">Contact Us</h2>
                    <div class="contact-form">
                        <form action="ContactUsServlet" method="post">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" id="email" name="email" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label for="header">Header:</label>
                                <input type="text" id="header" name="header" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label for="message">Message:</label>
                                <textarea id="message" name="message" rows="5" class="form-control" required></textarea>
                            </div>

                            <div class="form-group">
                                <button type="submit" class="btn btn-primary" style="background-color:#ff6600; border:none">Submit</button>
                            </div>
                        </form>
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
