package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.util.Booking;
import com.example.util.DBFactory;


public class ViewMyBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the email ID entered by the user
        String emailId = request.getParameter("emailId");

        // Retrieve bookings for the given email ID from the database
        List<Booking> userBookings = DBFactory.getBookingsForUser(emailId);

        // Create a separate list to store payment statuses
        List<Boolean> paymentStatusList = new ArrayList<>();

        // Check if there are any bookings for the user
        if (userBookings != null && !userBookings.isEmpty()) {
            // Iterate through the user bookings and check payment status for each booking
            for (Booking booking : userBookings) {
                boolean isPaymentDone = DBFactory.isPaymentDoneForBooking(booking.getBookingID());
                paymentStatusList.add(isPaymentDone);
            }

            // Set both lists as request attributes
            request.setAttribute("userBookings", userBookings);
            request.setAttribute("paymentStatusList", paymentStatusList);

            // Forward the request to the ViewMyBooking.jsp to display the bookings
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListMyBooking.jsp");
            dispatcher.forward(request, response);
        } else {
            // If no bookings are found, display a message
            request.setAttribute("message", "No bookings found for the provided email ID.");
            request.setAttribute("details", "Please check your email ID and try again.");
            request.setAttribute("nextURL", "MyBooking.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
