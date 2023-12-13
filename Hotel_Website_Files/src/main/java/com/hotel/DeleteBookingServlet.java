package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.util.DBFactory;

/**
 * Servlet implementation class DeleteBookingServlet
 */
public class DeleteBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Retrieve the booking ID from the request
        int bookingId = Integer.parseInt(request.getParameter("bookingID"));

        // Delete the booking from the database
        boolean isDeleted = DBFactory.deleteBooking(bookingId);

        if (isDeleted) {
            // Booking deleted successfully, set success attributes and forward to a success page
            request.setAttribute("message", "Booking Deleted");
            request.setAttribute("details", "The booking has been successfully deleted.");
            request.setAttribute("nextURL", "ListBookingServlet");
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            // Handle the case where the booking could not be deleted (e.g., booking not found)
            request.setAttribute("message", "Error");
            request.setAttribute("details", "The booking deletion encountered an error. Try again later.");
            request.setAttribute("nextURL", "ListBookingServlet");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
