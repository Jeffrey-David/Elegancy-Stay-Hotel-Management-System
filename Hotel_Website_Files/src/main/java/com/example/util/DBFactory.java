package com.example.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.jdbc.Blob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
public class DBFactory {

    private static final String JDBC_URL = "jdbc:mysql://hotel.cuawbqmwskx4.us-east-1.rds.amazonaws.com:3306/hotel";
    //private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hotel";
    private static final String USER = "root";
    private static final String PASSWORD = "hotel123";
    


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public static Room fetchRoomDetailsFromDatabase(int roomId) {
        Room room = null;
        try (Connection connection = getConnection()) {
            String sql = "SELECT id, roomType, noOfRooms, costNum FROM rooms WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, roomId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String roomType = resultSet.getString("roomType");
                        int noOfRooms = resultSet.getInt("noOfRooms");
                        BigDecimal costNum = resultSet.getBigDecimal("costNum");
                        
                        // Create a Room object with the retrieved data
                        room = new Room(id, roomType, noOfRooms, costNum);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database-related exceptions
        }

        return room;
    }
    
    public static List<Booking> getBookingsFromDatabase() {
        List<Booking> bookings = new ArrayList<>();

        try (Connection connection = DBFactory.getConnection()) {
            String sql = "SELECT * FROM bookroom";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Booking booking = new Booking();
                        booking.setBookingID(resultSet.getInt("bookingID"));
                        booking.setEmailId(resultSet.getString("emailId"));
                        booking.setName(resultSet.getString("name"));
                        booking.setNoOfRooms(resultSet.getInt("noOfRooms"));
                        booking.setDOB(resultSet.getDate("DOB"));
                        booking.setMobNum(resultSet.getInt("mobNum"));
                        booking.setMealPlan(resultSet.getString("mealPlan"));
                        booking.setCheckIn(resultSet.getDate("checkIn"));
                        booking.setCheckOut(resultSet.getDate("checkOut"));
                        booking.setBeddingType(resultSet.getString("beddingType"));
                        booking.setRoomType(resultSet.getString("roomType"));
                        booking.setCostNum(resultSet.getBigDecimal("costNum"));
                        booking.setAddress(resultSet.getString("address"));
                        booking.setTotalCost(resultSet.getBigDecimal("totalCost"));
                        bookings.add(booking);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database-related exceptions
        }

        return bookings;
    }
    
    public static Booking getBookingFromDatabase(int bookingID) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Booking booking = null;

        try {
            connection = DBFactory.getConnection();
            String query = "SELECT * FROM bookroom WHERE bookingID = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, bookingID);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                booking = new Booking();
                booking.setBookingID(resultSet.getInt("bookingID"));
                booking.setEmailId(resultSet.getString("emailId"));
                booking.setName(resultSet.getString("name"));
                booking.setNoOfRooms(resultSet.getInt("noOfRooms"));
                booking.setDOB(resultSet.getDate("DOB"));
                booking.setMobNum(resultSet.getInt("mobNum"));
                booking.setMealPlan(resultSet.getString("mealPlan"));
                booking.setCheckIn(resultSet.getDate("checkIn"));
                booking.setCheckOut(resultSet.getDate("checkOut"));
                booking.setBeddingType(resultSet.getString("beddingType"));
                booking.setRoomType(resultSet.getString("roomType"));
                booking.setCostNum(resultSet.getBigDecimal("costNum"));
                booking.setAddress(resultSet.getString("address"));
                booking.setTotalCost(resultSet.getBigDecimal("totalCost"));
                // Set other booking attributes as needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions here
        } finally {
            DBFactory.closeConnection(connection);
        }
        
        return booking;
    }


    public static List<Room> fetchRoomListFromDatabase() {
        List<Room> roomList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT id, roomType, noOfRooms, costNum FROM rooms";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String roomType = resultSet.getString("roomType");
                    int noOfRooms = resultSet.getInt("noOfRooms");
                    BigDecimal costNum = resultSet.getBigDecimal("costNum");

                    // Create a Room object and add it to the list
                    Room room = new Room(id, roomType, noOfRooms, costNum);
                    roomList.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database-related exceptions
        }

        return roomList;
    }
    
    public static List<Booking> getBookingsForUser(String emailId) {
        List<Booking> userBookings = new ArrayList<>();

        // Define your database connection and SQL query
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM bookroom WHERE emailId = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, emailId);

                // Execute the query
                ResultSet resultSet = statement.executeQuery();

                // Iterate through the result set and create Booking objects
                while (resultSet.next()) {
                    Booking booking = new Booking();
                    booking.setBookingID(resultSet.getInt("bookingID"));
                    booking.setEmailId(resultSet.getString("emailId"));
                    booking.setName(resultSet.getString("name"));
                    booking.setNoOfRooms(resultSet.getInt("noOfRooms"));
                    booking.setDOB(resultSet.getDate("DOB"));
                    booking.setMobNum(resultSet.getInt("mobNum"));
                    booking.setMealPlan(resultSet.getString("mealPlan"));
                    booking.setCheckIn(resultSet.getDate("checkIn"));
                    booking.setCheckOut(resultSet.getDate("checkOut"));
                    booking.setBeddingType(resultSet.getString("beddingType"));
                    booking.setRoomType(resultSet.getString("roomType"));
                    booking.setCostNum(resultSet.getBigDecimal("costNum"));
                    booking.setAddress(resultSet.getString("address"));
                    booking.setTotalCost(resultSet.getBigDecimal("totalCost"));
                    userBookings.add(booking);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database-related exceptions
        }

        return userBookings;
    }

    public static boolean deleteRoom(int id) {
    	try (Connection connection = getConnection()){
    		String sql = "DELETE FROM rooms where id = ?";
    		try(PreparedStatement statement = connection.prepareStatement(sql)){
    		statement.setInt(1, id);
    		int rowsAffected = statement.executeUpdate();
    		if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
    		}

    		}
    	catch (SQLException e) {
            e.printStackTrace();
            // Handle database-related exceptions
        }
    	return false;
    }
    
    public static boolean deleteBooking(int bookingId) {
        // Define the SQL statement to delete a booking by bookingId
        String deleteBookingSQL = "DELETE FROM bookroom WHERE bookingID = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteBookingSQL)) {
            preparedStatement.setInt(1, bookingId);

            // Execute the delete operation
            int rowsAffected = preparedStatement.executeUpdate();

            // If the query deleted one or more rows, it was successful
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions that occur during the delete operation
        }

        return false; // Return false if the deletion was not successful
    }
    
    public static int checkRoomAvailability(String roomType, Date checkInDate, Date checkOutDate) {
       
        int noOfRooms=0;
        try {
            Connection connection = getConnection();
            if (connection != null) {
                String query = "SELECT rooms.roomType, " +
                        "rooms.noOfRooms - IFNULL(b.bookedRooms, 0) AS remainingRooms " +
                        "FROM rooms " +
                        "LEFT JOIN ( " +
                        "   SELECT roomType, SUM(noOfRooms) AS bookedRooms " +
                        "   FROM bookroom " +
                        "   WHERE " +
                        "      (checkIn >= ? AND checkIn < ?) " +
                        "      OR (checkOut > ? AND checkOut <= ?) " +
                        "      OR (checkIn < ? AND checkOut > ?) " +
                        "   GROUP BY roomType " +
                        ") AS b " +
                        "ON rooms.roomType = b.roomType " +
                        "WHERE rooms.roomType = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                
                preparedStatement.setDate(1, checkInDate);
                preparedStatement.setDate(2, checkOutDate);
                preparedStatement.setDate(3, checkInDate);
                preparedStatement.setDate(4, checkOutDate);
                preparedStatement.setDate(5, checkInDate);
                preparedStatement.setDate(6, checkOutDate);
                preparedStatement.setString(7, roomType);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String roomTypeResult = resultSet.getString("roomType");
                    noOfRooms = resultSet.getInt("remainingRooms");

                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noOfRooms;
    }
    
    public static boolean addPayment(int bookingId, BigDecimal amount, Date paymentDate, String paymentMethod) {
        try (Connection con = getConnection()) {
            String insertQuery = "INSERT INTO payments (booking_id, amount, payment_date, payment_method) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertQuery)) {
                ps.setInt(1, bookingId);
                ps.setBigDecimal(2, amount);
                ps.setDate(3, paymentDate);
                ps.setString(4, paymentMethod);

                int numRowsInserted = ps.executeUpdate();
                return numRowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly in your application
            return false;
        }
    }
    
    public static boolean isPaymentDoneForBooking(int bookingId) {
        try (Connection con = getConnection()) {
            String query = "SELECT COUNT(*) FROM payments WHERE booking_id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, bookingId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int paymentCount = rs.getInt(1);
                        return paymentCount > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }
        return false;
    }
    
    public static List<QueryData> getQueriesFromDatabase() {
        List<QueryData> queries = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String query = "SELECT query_id, email, header, message, submission_date, resolved FROM contact_queries ORDER BY resolved";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int queryId = resultSet.getInt("query_id");
                    String email = resultSet.getString("email");
                    String header = resultSet.getString("header");
                    String message = resultSet.getString("message");
                    java.sql.Timestamp submissionDate = resultSet.getTimestamp("submission_date");
                    boolean resolved = resultSet.getBoolean("resolved");

                    QueryData queryData = new QueryData();
                    queryData.setQueryId(queryId);
                    queryData.setEmail(email);
                    queryData.setHeader(header);
                    queryData.setMessage(message);
                    queryData.setSubmissionDate(submissionDate);
                    queryData.setResolved(resolved);

                    queries.add(queryData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return queries;
    }
    
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
