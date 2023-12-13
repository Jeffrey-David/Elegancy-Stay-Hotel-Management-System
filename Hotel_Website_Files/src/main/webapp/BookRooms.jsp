<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <%@include file="all_component/allCss.jsp"%>
 <link rel="stylesheet" href="all_component/style.css">
</head>
<body>
<%@include file="all_component/navbar.jsp"%>
 <p><br></p>
    <div class="container">
        <div class="row mt-2">
            <div class="col-md-8 offset-md-2">
                <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color:white;  margin-bottom: 100px;">
                    <div class="card-body">
                        <h4 class="text-center">Book Rooms</h4>
                        <form action="BookRoomsServlet" method="post">
                        <div class="row">
				        <!-- First Column -->
				        <div class="col-md-6">
				        	<label for="name">Name</label>
                            <input type="text" class="form-control" id="name" name="name">
                            
                            <label for="dob">DOB</label>
                            <input type="date" name="dob" class="form-control" id="dob">
                            
                            <label for="address">Address</label>
                            <input type="text" class="form-control" id="address" name="address">
                            
                            <label for="roomType">Room Type</label>
							<input type="text" class="form-control" id="roomType" required="required" name="roomType" readonly value="<%= request.getAttribute("roomType") %>">
                            
                            
                            <label for="noOfRooms">No of Rooms</label>
                            <input type="number" class="form-control" id="noOfRooms" required="required" name="noOfRooms">
                            <p id="error-message" style="color: red; display: none;">Number of rooms requested exceeds available rooms or is not valid.</p>
                            
                            <label for="totalCost">Total Cost</label>
                            <input type="number" class="form-control" id="totalCost" required="required" name="totalCost" readonly>
                            
                            
                            <label for="checkInDate">Check-In Date</label>
							<input type="date" class="form-control" id="checkInDate" required="required" name="checkInDate" readonly value="<%= request.getAttribute("checkInDate") %>">
							
                            
				        </div>
				        <div class="col-md-6">
				            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email">
                            
                            <label for="mobNum">Phone No</label>
                            <input type="number" class="form-control" id="mobNum" name="mobNum">
                            
                            <label for="beddingType">Bedding Type</label>
                       <select class="form-control" id="beddingType" name="beddingType">
                        <option>Select Bedding Type</option>
						    <option value="Single" data-cost="0">Single</option>
						    <option value="Double" data-cost="0">Double</option>
						    <option value="Triple" data-cost="10">Triple</option>
						    <option value="Quad" data-cost="20">Quad</option>
                      
                    </select>
                    
                    <label for="costNum">Cost Per Room</label>
                            <input type="number" class="form-control" id="costNum" required="required" name="costNum" readonly value="<%= request.getAttribute("costNum") %>">
                            
                            
                            <label for="maxAvailableRooms">Max Available Rooms</label>
<input type="text" class="form-control" id="maxAvailableRooms" name="maxAvailableRooms" readonly value="<%= request.getAttribute("maxAvailableRooms") %>">
				        
				        <label for="mealPlan">Meal Plan</label>
                            <select class="form-control" id="mealPlan" name="mealPlan">
                        <option>Select Meal Plan</option>
						    <option value="Room only" data-cost="10">Room only</option>
						    <option value="Breakfast" data-cost="10">Breakfast</option>
						    <option value="Half Board" data-cost="15">Half Board</option>
						    <option value="Full Board" data-cost="20">Full Board</option>
                      
                    </select>
				        
				        <label for="checkOutDate">Check-Out Date</label>
							<input type="date" class="form-control" id="checkOutDate" required="required" name="checkOutDate" readonly value="<%= request.getAttribute("checkOutDate") %>">
							
                            
				        </div>
                        </div>
                        
                            
                            <br><br>
                            <div align="center">
                            <button type="submit" class="btn btn-primary" style="background-color:#ff6600; border:none">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
 <script>
    // Function to extract URL parameter by name
    var maxAvailableRooms = parseInt(<%= request.getAttribute("maxAvailableRooms") %>);
    console.log(maxAvailableRooms);

    var noOfRoomsInput = document.getElementById("noOfRooms");
    var errorMessage = document.getElementById("error-message");

    noOfRoomsInput.addEventListener("input", function () {
        var noOfRooms = parseInt(noOfRoomsInput.value);
        if (noOfRooms <= maxAvailableRooms) {
            errorMessage.style.display = "none";
        } else {
            errorMessage.style.display = "block"; // corrected from errorMessage.style display = "block";
        }
    });

    // Get references to the input fields
    var num1Input = document.getElementById("costNum");
    var num2Input = document.getElementById("noOfRooms");
    var mealPlanSelect = document.getElementById("mealPlan");
    var beddingTypeSelect = document.getElementById("beddingType");
    var resultInput = document.getElementById("totalCost");

    // Attach event listeners to the input fields
    num1Input.addEventListener("input", updateResult);
    num2Input.addEventListener("input", updateResult);
    mealPlanSelect.addEventListener("change", updateResult);
    beddingTypeSelect.addEventListener("change", updateResult);

    // Function to update the result field
    function updateResult() {
        // Get input values
        var num1 = parseFloat(num1Input.value) || 0; // Default to 0 if not a valid number
        var num2 = parseFloat(num2Input.value) || 0; // Default to 0 if not a valid number

        // Get meal plan and bedding type values
        var mealPlanCost = parseFloat(mealPlanSelect.options[mealPlanSelect.selectedIndex].getAttribute("data-cost")) || 0;
        var beddingTypeCost = parseFloat(beddingTypeSelect.options[beddingTypeSelect.selectedIndex].getAttribute("data-cost")) || 0;

        // Calculate the total cost
        var product = (num1 + mealPlanCost + beddingTypeCost) * num2;

        // Display the result in the "result" field
        resultInput.value = product;
    }
</script>

    <p><br><br><br><br></p>
    <div class="footer">
    <p>&copy; 2023 Our Hotel. All rights reserved. | <a href="ContactUs.jsp">Contact Us</a></p>
	</div>
</body>
</html>