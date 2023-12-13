package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.util.Booking;
import com.example.util.DBFactory;

/**
 * Servlet implementation class ViewBookingServlet
 */
public class ViewBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookingID = Integer.parseInt(request.getParameter("bookingID"));

        // Retrieve booking details from the database
        Booking booking = DBFactory.getBookingFromDatabase(bookingID);
        String isPaymentDone = DBFactory.isPaymentDoneForBooking(booking.getBookingID())?"Paid":"Pending";
        
        if(booking.getName()==null)
        {
        	request.setAttribute("message", "Booking Not Found");
            request.setAttribute("details","Try again");
            request.setAttribute("nextURL", "ListBookingServlet");
            request.getRequestDispatcher("error.jsp").forward(request, response); 	
        }
        else {
        // Set the booking as a request attribute
        request.setAttribute("booking", booking);
        request.setAttribute("payment", isPaymentDone);
        
        // Forward the request to the ViewBooking.jsp
        request.getRequestDispatcher("ViewBooking.jsp").forward(request, response);
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
