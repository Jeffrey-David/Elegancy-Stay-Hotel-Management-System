<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hotel: Home</title>
    <%@include file="all_component/allCss.jsp"%>
    <link rel="stylesheet" href="all_component/style.css">
</head>
<body>
    <%@include file="all_component/NavBarAdmin.jsp"%>
    <p><br><br></p>
    <div class="container-fluid back-img">
        <div class="row">
            <div class="col-md-4 offset-md-4 text-center">
                <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color:white">
                    <div class="card-body">
                        <h2 style="font-weight:600"><br>Choose the Dates to Visualize</h2>

                        <!-- Add form to select date range -->
                        <form method="post" onSubmit="submitForm(); return false;" >
                            <label for="startDate">Start Date:</label>
                            <input type="date" id="startDate" name="startDate" class="form-control" required>
                            <br>

                            <label for="endDate">End Date:</label>
                            <input type="date" id="endDate" name="endDate" class="form-control" required>
                            <br>

                            <input type="submit" name="submitType" class="btn btn-success" style="background-color:#ff6600; border:none" value="View Room Occupancy">
						    <input type="submit" name="submitType" class="btn btn-success" style="background-color:#ff6600; border:none" value="View Daily Occupancy">
						</form>


						<script>
						    function submitForm() {
						        // Get the selected values for startDate and endDate
						        var startDateValue = document.getElementById("startDate").value;
						        var endDateValue = document.getElementById("endDate").value;
						
						        if (document.activeElement.value === "View Room Occupancy") {
						            // Redirect to the first servlet for Room Occupancy with parameters
						            window.location.href = "vizRoom.jsp?startDate=" + startDateValue + "&endDate=" + endDateValue;
						        } else if (document.activeElement.value === "View Daily Occupancy") {
						            // Redirect to the second servlet for Daily with parameters
						            window.location.href = "vizBooking.jsp?startDate=" + startDateValue + "&endDate=" + endDateValue;
						        }
						    }
						</script>
											
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
