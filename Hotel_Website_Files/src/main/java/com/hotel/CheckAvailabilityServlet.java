package com.hotel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.util.DBFactory;
import com.example.util.Room;

public class CheckAvailabilityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CheckAvailabilityServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve check-in and check-out dates from the form
    	String roomType = request.getParameter("roomType");
    	String costNum = request.getParameter("costNum");
        String checkInDateString = request.getParameter("checkInDate");
        String checkOutDateString = request.getParameter("checkOutDate");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date checkInDate = null;
		try {
			checkInDate = dateFormat.parse(checkInDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        java.util.Date checkOutDate = null;
		try {
			checkOutDate = dateFormat.parse(checkOutDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Fetch available rooms based on the selected dates
        java.sql.Date sqlCheckInDate = new java.sql.Date(checkInDate.getTime());
        java.sql.Date sqlCheckOutDate = new java.sql.Date(checkOutDate.getTime());

        // Now you can use sqlCheckInDate and sqlCheckOutDate in your method
        int availableRooms = DBFactory.checkRoomAvailability(roomType, sqlCheckInDate, sqlCheckOutDate);
        if(availableRooms>0) {
        // Set the available rooms as a session attribute
        HttpSession session = request.getSession();
        request.setAttribute("roomType", roomType);
        request.setAttribute("checkInDate", checkInDateString);
        request.setAttribute("checkOutDate", checkOutDateString);
        request.setAttribute("maxAvailableRooms", availableRooms);
        request.setAttribute("costNum", costNum);
        // Redirect to a page to display the available rooms
        request.getRequestDispatcher("BookRooms.jsp").forward(request, response);
        }
        else {
            request.setAttribute("message", "Room Unavailable");
            request.setAttribute("details", "The room is full for the dates. You can try other rooms");
            request.setAttribute("nextURL", "BookServlet");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
