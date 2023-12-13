package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.util.DBFactory;

public class VizBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public VizBookingServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<BookingData> bookingData = null;
        try {
            java.util.Date startDateUtil = dateFormat.parse(startDateStr);
            java.util.Date endDateUtil = dateFormat.parse(endDateStr);

            java.sql.Date startDate = new java.sql.Date(startDateUtil.getTime());
            java.sql.Date endDate = new java.sql.Date(endDateUtil.getTime());

            bookingData = getBookingData(startDate, endDate);
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format");
        }

        // Convert the booking data to JSON
        String jsonData = convertToJson(bookingData);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write(jsonData);
        out.flush();
    }

    private List<BookingData> getBookingData(Date startDate, Date endDate) {
        List<BookingData> bookingData = new ArrayList<>();

        try (Connection connection = DBFactory.getConnection()) {
            // Calculate all the dates between start and end dates
            List<Date> dateList = getDatesBetween(startDate, endDate);

            for (Date date : dateList) {
                String query = "SELECT ?, roomType, SUM(noOfRooms) AS numRooms " +
                               "FROM hotel.bookroom " +
                               "WHERE checkIn <= ? AND checkOut > ? " +
                               "GROUP BY roomType";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setDate(1, date);
                    preparedStatement.setDate(2, date);
                    preparedStatement.setDate(3, date);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            String roomType = resultSet.getString("roomType");
                            int numRooms = resultSet.getInt("numRooms");
                            bookingData.add(new BookingData(date, roomType, numRooms));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookingData;
    }

    private String convertToJson(List<BookingData> bookingData) {
        StringBuilder jsonData = new StringBuilder();
        jsonData.append("[");

        for (BookingData booking : bookingData) {
            jsonData.append("{");
            jsonData.append("\"Date\":\"").append(booking.getDate()).append("\",");
            jsonData.append("\"RoomType\":\"").append(booking.getRoomType()).append("\",");
            jsonData.append("\"NumRooms\":").append(booking.getNumRooms());
            jsonData.append("},");
        }

        if (bookingData.size() > 0) {
            jsonData.deleteCharAt(jsonData.length() - 1);
        }

        jsonData.append("]");

        return jsonData.toString();
    }

    // Helper function to get dates between two dates
    private List<Date> getDatesBetween(Date startDate, Date endDate) {
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        while (!calendar.getTime().after(endDate)) {
            Date date = new Date(calendar.getTime().getTime());
            dates.add(date);
            calendar.add(Calendar.DATE, 1);
        }

        return dates;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

class BookingData {
    private Date date;
    private String roomType;
    private int numRooms;

    public BookingData(Date date, String roomType, int numRooms) {
        this.date = date;
        this.roomType = roomType;
        this.numRooms = numRooms;
    }

    public Date getDate() {
        return date;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNumRooms() {
        return numRooms;
    }
}
