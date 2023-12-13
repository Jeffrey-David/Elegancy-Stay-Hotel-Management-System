package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.util.DBFactory;

/**
 * Servlet implementation class VizRoomServlet
 */
public class VizRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VizRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the start and end dates from the request parameters
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<RoomOccupancy> roomOccupancyData = null;
        try {
            // Parse the start and end date strings into java.util.Date objects
            java.util.Date startDateUtil = dateFormat.parse(startDateStr);
            java.util.Date endDateUtil = dateFormat.parse(endDateStr);

            // Convert java.util.Date objects to java.sql.Date objects
            java.sql.Date startDate = new java.sql.Date(startDateUtil.getTime());
            java.sql.Date endDate = new java.sql.Date(endDateUtil.getTime());

            // Call the getRoomOccupancyData method with the converted dates
            roomOccupancyData = getRoomOccupancyData(startDate, endDate);

            // ... (rest of the code remains the same)
        }
        catch (ParseException e) {
            // Handle date parsing error
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format");
        }// Replace with your logic

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

    // Simulated method to query the database and get room occupancy data
    private List<RoomOccupancy> getRoomOccupancyData(Date startDate, Date endDate) {
        List<RoomOccupancy> roomOccupancyData = new ArrayList<>();

        try (Connection connection = DBFactory.getConnection()) {
            String query = "SELECT roomType, SUM(noOfRooms) AS occupancy " +
                           "FROM hotel.bookroom " +
                           "WHERE checkIn >= ? AND checkOut <= ? " +
                           "GROUP BY roomType";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDate(1, startDate);
                preparedStatement.setDate(2, endDate);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String roomType = resultSet.getString("roomType");
                        int occupancy = resultSet.getInt("occupancy");
                        System.out.println(occupancy);
                        roomOccupancyData.add(new RoomOccupancy(roomType, occupancy));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception properly in your application
        }

        return roomOccupancyData;
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class RoomOccupancy {
    private String roomType;
    private int occupancy;

    public RoomOccupancy(String roomType, int occupancy) {
        this.roomType = roomType;
        this.occupancy = occupancy;
    }

    // Getters and setters (or public fields) for roomType and occupancy

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }
}