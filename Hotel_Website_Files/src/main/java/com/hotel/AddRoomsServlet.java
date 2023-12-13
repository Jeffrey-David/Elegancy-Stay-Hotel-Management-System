package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.annotation.MultipartConfig;
import com.example.util.DBFactory;

/**
 * Servlet implementation class AddRoomsServlet
 */
@MultipartConfig
public class AddRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomsServlet() {
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
		// TODO Auto-generated method stub
        String roomType = request.getParameter("roomType");
        int noOfRooms = Integer.parseInt(request.getParameter("noOfRooms"));
        BigDecimal costNum = new BigDecimal(request.getParameter("costNum"));
        
        // Get the uploaded file part
        Part filePart = request.getPart("files");
        InputStream fileInputStream = filePart.getInputStream();
        
        int x=0;

        try (Connection connection = DBFactory.getConnection()) {
            String sql = "INSERT INTO hotel.rooms (roomType, noOfRooms, costNum, image) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, roomType);
                statement.setInt(2, noOfRooms);
                statement.setBigDecimal(3, costNum);
                statement.setBlob(4, fileInputStream);
                x = statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database-related exceptions
        }
        if(x>0) {
        // Redirect or display a success message
        request.setAttribute("message", "Room Added Successfully");
        request.setAttribute("details","The room has been succesfully added.");
        request.setAttribute("nextURL", "welcome.jsp");
        request.getRequestDispatcher("success.jsp").forward(request, response);      
        }
        
        else {
			request.setAttribute("message", "Error in Creating Room");
	        request.setAttribute("details","Please try again later");
	        request.setAttribute("nextURL", "welcome.jsp");
	        request.getRequestDispatcher("error.jsp").forward(request, response);
        }
	}
}
