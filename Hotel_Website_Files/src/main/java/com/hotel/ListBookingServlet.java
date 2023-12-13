package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.util.DBFactory;
import com.example.util.Booking;

/**
 * Servlet implementation class ListBookingServlet
 */
public class ListBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Retrieve the list of bookings from your database or data source
        List<Booking> bookings = DBFactory.getBookingsFromDatabase(); // Implement this method
        List<Boolean> paymentStatusList = new ArrayList<>();
        
        for (Booking booking : bookings) {
            boolean isPaymentDone = DBFactory.isPaymentDoneForBooking(booking.getBookingID());
            paymentStatusList.add(isPaymentDone);
        }

        request.setAttribute("paymentStatusList", paymentStatusList);

        // Set the list of bookings as a request attribute
        request.setAttribute("bookings", bookings);

        // Forward the request to the ListBooking.jsp
        request.getRequestDispatcher("ListBooking.jsp").forward(request, response);
   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
