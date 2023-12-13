package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

import com.example.util.DBFactory;

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve payment details from the form
		String bookingIDStr = request.getParameter("bookingID");
		String paymentMethod = request.getParameter("paymentMethod");
	    String cardNumber = request.getParameter("cardNumber");
	    String expiryDate = request.getParameter("expiryDate");
	    String cvv = request.getParameter("cvv");
	    String amountStr = request.getParameter("amount");

	    try {
	        // Parse bookingID and amount into their respective data types
	        int bookingID = Integer.parseInt(bookingIDStr);
	        BigDecimal amount = new BigDecimal(amountStr);

	        // Perform some validation on cardNumber, expiryDate, and cvv if needed

	        // You might also want to validate other payment details

	        // Call the addPayment method
	        boolean paymentAdded = DBFactory.addPayment(bookingID, amount, new Date(System.currentTimeMillis()), paymentMethod);

	        if (paymentAdded) {
	        	request.setAttribute("message", "Payment Successful");
	            request.setAttribute("details", "Thank You for Choosing Us");
	            request.setAttribute("nextURL", "index.jsp");
	            request.getRequestDispatcher("success.jsp").forward(request, response);
	        } else {
	            // Payment was not added, handle the error
	            // You can redirect to an error page or handle it as needed
	        	request.setAttribute("message", "Payment Unsuccessful");
	            request.setAttribute("details", "Please try again Later");
	            request.setAttribute("nextURL", "MyBooking.jsp");
	            request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	    } catch (Exception e) {
	        // Handle exceptions, for example, invalid number format or database error
	        e.printStackTrace(); // Log the error
	        // Redirect to an error page or handle it as needed
	    }
    }

}
