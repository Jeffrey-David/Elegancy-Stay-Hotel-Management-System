package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.example.util.DBFactory;
import com.example.util.Room;

public class ListRoomsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListRoomsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch the list of rooms from the database using your DBFactory method
        List<Room> roomList = DBFactory.fetchRoomListFromDatabase(); // Use DBFactory method
        // Set the list of rooms as an attribute in the request
        request.setAttribute("roomList", roomList);

        // Forward the request to ListRooms.jsp for rendering
        request.getRequestDispatcher("ListRooms.jsp").forward(request, response);
    }
}
