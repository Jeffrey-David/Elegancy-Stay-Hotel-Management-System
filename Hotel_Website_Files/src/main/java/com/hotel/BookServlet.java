package com.hotel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//import jakarta.sql.DataSource;
import com.example.util.Room;

import com.example.util.DBFactory;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // Your database connection details
		List<Room> productList = new ArrayList<>();
		DBFactory df= new DBFactory();
		 try {
	            // Establish a database connection
			 Connection connection = df.getConnection();

	            // Prepare the SQL query to retrieve image and price
	            String sql = "SELECT id,roomType,noOfRooms,costNum,image FROM rooms";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);

	            // Execute the query
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String roomType=resultSet.getString("roomType");
	                int noOfRooms=resultSet.getInt("noOfRooms");
	                BigDecimal costNum=resultSet.getBigDecimal("costNum");
	                Blob blob= resultSet.getBlob("image");
	                

	                // Convert the Blob to a byte array
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096]; //4096
	                int bytesRead = -1;
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);
	                }
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	                inputStream.close();
	                outputStream.close();
	              //  byte[] imageBytes = blob.getBytes(1, (int) blob.length());

	                Room product = new Room( id,roomType,noOfRooms,costNum,base64Image);
	                productList.add(product);
	                
	            }

	            resultSet.close();
	            preparedStatement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        request.setAttribute("productList", productList);
	        request.getRequestDispatcher("/book.jsp").forward(request, response);
	    }
    
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
