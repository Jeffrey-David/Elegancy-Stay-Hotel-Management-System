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
import com.example.util.Room;

@WebServlet("/EditRoomServlet")
@MultipartConfig
public class EditRoomsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditRoomsServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve room ID from the URL parameter
        int roomId = Integer.parseInt(request.getParameter("roomId"));

        // Fetch room details from the database based on roomId
        Room room = DBFactory.fetchRoomDetailsFromDatabase(roomId); // Implement this method

        // Set room details as request attributes
        request.setAttribute("room", room);

        // Forward the request to the edit form (EditRooms.jsp)
        request.getRequestDispatcher("EditRooms.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve room ID from the hidden input field
        int roomId = Integer.parseInt(request.getParameter("roomId"));

        // Retrieve other form fields for editing
        String roomType = request.getParameter("roomType");
        int noOfRooms = Integer.parseInt(request.getParameter("noOfRooms"));
        BigDecimal costNum = new BigDecimal(request.getParameter("costNum"));

        // Get the uploaded new image (if provided)
        Part newImagePart = request.getPart("newImage");
        InputStream newImageInputStream = newImagePart.getInputStream();
        int x=0;
        try (Connection connection = DBFactory.getConnection()) {
            String sql = "UPDATE hotel.rooms SET roomType=?, noOfRooms=?, costNum=?, image=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, roomType);
                statement.setInt(2, noOfRooms);
                statement.setBigDecimal(3, costNum);
                statement.setBlob(4, newImageInputStream);
                statement.setInt(5, roomId);
                x = statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database-related exceptions
        }
        if(x>0) {
            request.setAttribute("message", "Room Edited");
            request.setAttribute("details","The room has been succesfully edited.");
            request.setAttribute("nextURL", "ListRoomsServlet");
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }
        else {
        	request.setAttribute("message", "Error");
            request.setAttribute("details","Encountered an error. <br>Try again Later");
            request.setAttribute("nextURL", "ListRoomsServlet");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}
