<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Payment Page</title>
    <%@include file="all_component/allCss.jsp"%>
    <link rel="stylesheet" href="all_component/style.css">
    <script>
        function validateForm() {
            var cardNumber = document.getElementById("cardNumber").value;
            var expiryDate = document.getElementById("expiryDate").value;
            var cvv = document.getElementById("cvv").value;

            // Card number should be 16 digits
            if (cardNumber.length !== 16) {
                alert("Please enter a valid 16-digit card number.");
                return false;
            }

            // Expiry date should match a valid pattern (e.g., MM/YY)
            var expiryDatePattern = /^(0[1-9]|1[0-2])\/\d{2}$/;
            if (!expiryDate.match(expiryDatePattern)) {
                alert("Please enter a valid expiry date in MM/YY format.");
                return false;
            }

            // CVV should be 3 digits
            if (cvv.length !== 3) {
                alert("Please enter a valid 3-digit CVV.");
                return false;
            }

            // If all validations pass, the form will be submitted
            return true;
        }
    </script>
</head>
<body>
    <%@include file="all_component/navbar.jsp"%>
    <div class="container">
        <div class="row mt-2">
            <div class="col-md-8 offset-md-2">
                <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color: white; margin-bottom: 100px;">
                    <div class="card-body">
                        <h4 class="text-center">Payment</h4>
                        <form action="PaymentServlet" method="post">
                        	<div class="form-group">
							    <label for="paymentMethod">Payment Method</label>
							    <select class="form-control" id="paymentMethod" name="paymentMethod" required>
							        <option value="credit">Credit Card</option>
							        <option value="debit">Debit Card</option>
							    </select>
							</div>
                        	
                            <div class="form-group">
                                <label for="cardNumber">Card Number</label>
                                <input type="text" class="form-control" id="cardNumber" name="cardNumber" required>
                            </div>
							<div class="form-group">
							    <label for="expiryDate">Expiry Date (MM/YY)</label>
							    <input type="text" class="form-control" id="expiryDate" name="expiryDate" required>
							</div>
							
							<script>
							document.getElementById('expiryDate').addEventListener('input', function (e) {
							    // Get the input value
							    let inputValue = e.target.value;
							    
							    // Remove any non-numeric characters
							    inputValue = inputValue.replace(/\D/g, '');
							    
							    // Add '/' after the second character (MM/YY)
							    if (inputValue.length > 2) {
							        inputValue = inputValue.slice(0, 2) + '/' + inputValue.slice(2);
							    }
							    
							    // Update the input value
							    e.target.value = inputValue;
							});
							</script>


                            <div class="form-group">
                                <label for="cvv">CVV</label>
                                <input type="text" class="form-control" id="cvv" name="cvv" required>
                            </div>
							<div class="form-group">
							    <label for="amount">Amount</label>
							    <input type="text" class="form-control" id="amount" name="amount" required readonly value="${param.amount}">
							</div>
							<input type="hidden" name="bookingID" value="${param.bookingID}">
        					<input type="hidden" name="totalCost" value="${param.totalCost}">
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary" style="background-color: #ff6600; border: none">Pay Now</button>
                            </div>
                        </form>
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
