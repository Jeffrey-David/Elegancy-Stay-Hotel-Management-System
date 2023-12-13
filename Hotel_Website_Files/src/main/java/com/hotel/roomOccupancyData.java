package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class roomOccupancyData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve room occupancy data from a data source or use hard-coded data
        List<RoomOccupancy> roomOccupancyData = getRoomOccupancyData(); // Replace with your logic

        // Create a JSON array manually
        StringBuilder jsonData = new StringBuilder();
        jsonData.append("[");

        for (RoomOccupancy room : roomOccupancyData) {
            jsonData.append("{");
            jsonData.append("\"roomType\":\"").append(room.getRoomType()).append("\",");
            jsonData.append("\"occupancy\":").append(room.getOccupancy());
            jsonData.append("},");
        }

        // Remove the trailing comma
        if (roomOccupancyData.size() > 0) {
            jsonData.deleteCharAt(jsonData.length() - 1);
        }

        jsonData.append("]");

        // Set response content type to JSON
        response.setContentType("application/json");

        // Write JSON data to the response
        PrintWriter out = response.getWriter();
        out.write(jsonData.toString());
        out.flush();
    }

    // Simulated method to get room occupancy data
    private List<RoomOccupancy> getRoomOccupancyData() {
        // Replace this with your logic to fetch room occupancy data
        List<RoomOccupancy> roomOccupancyData = new ArrayList<>();
        roomOccupancyData.add(new RoomOccupancy("Single Room", 8));
        roomOccupancyData.add(new RoomOccupancy("Double Room", 12));
        roomOccupancyData.add(new RoomOccupancy("Suite", 5));
        return roomOccupancyData;
    }
}

