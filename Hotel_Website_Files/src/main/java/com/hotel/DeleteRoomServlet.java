package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.util.DBFactory;

/**
 * Servlet implementation class DeleteRoomServlet
 */
public class DeleteRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int roomId = Integer.parseInt(request.getParameter("roomId"));

	        // Delete the room from the database
	        boolean isDeleted = DBFactory.deleteRoom(roomId);

	        // Check if the room was deleted successfully
	        if (isDeleted) {
	            // Redirect to the list of rooms or display a success message
	            request.setAttribute("message", "Room Deleted");
	            request.setAttribute("details","The room has been succesfully deleted.");
	            request.setAttribute("nextURL", "ListRoomsServlet");
	            request.getRequestDispatcher("success.jsp").forward(request, response);
	        } else {
	            // Handle the case where the room could not be deleted (e.g., room not found)
	        	request.setAttribute("message", "Error");
	            request.setAttribute("details","The room deletion encountered an error. <br>Try again Later");
	            request.setAttribute("nextURL", "ListRoomsServlet");
	            request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
