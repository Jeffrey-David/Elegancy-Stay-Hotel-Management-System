<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
    <%@include file="all_component/allCss.jsp"%>
    <link rel="stylesheet" href="all_component/style.css">
</head>
<body>
    <%@include file="all_component/navbar.jsp"%>
    <p><br></p>
    <div class="container">
        <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color:white;">
            <div class="row mt-2">
                <div class="col-md-12">
                    <h2 class="text-center" style="font-weight:600">List of Functionalities</h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Function</th>
                                <th>Link</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Loop through the list of functionalities and display them in the table -->
                            <c:forEach items="${searchResults}" var="functionality">
                                <tr>
                                    <td>${functionality.name}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${not empty functionality.url}">
                                                <a href="${functionality.url}" class="btn btn-primary" style="background-color: blue; border: none;">Visit</a>
                                            </c:when>
                                            <c:otherwise>
                                                <button class="btn btn-primary" style="background-color: gray; border: none;">NA</button>
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
        <p>&copy; 2023 Our Hotel. All rights reserved. | <a href="#">Contact Us</a></p>
    </div>
</body>
</html>
