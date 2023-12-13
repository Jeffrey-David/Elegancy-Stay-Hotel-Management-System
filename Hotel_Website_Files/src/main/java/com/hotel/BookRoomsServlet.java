package com.hotel;


import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import com.example.util.DBFactory;
import com.mysql.cj.Session;

/**
 * Servlet implementation class BookRoomsServlet
 */
@WebServlet("/BookRoomsServlet")
public class BookRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRoomsServlet() {
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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		int mobNum = Integer.parseInt(request.getParameter("mobNum"));
		String address=request.getParameter("address");
		String beddingType=request.getParameter("beddingType");
		String roomType=request.getParameter("roomType");
		BigDecimal costNum = new BigDecimal(request.getParameter("costNum"));
		int noOfRooms = Integer.parseInt(request.getParameter("noOfRooms"));
		BigDecimal totalCost=  new BigDecimal(request.getParameter("totalCost"));
		String mealPlan=request.getParameter("mealPlan");
		String checkIn = request.getParameter("checkInDate");
		String checkOut = request.getParameter("checkOutDate");
		 System.out.println("1: " + name);
	    System.out.println("2: " + email);
	    System.out.println("3: " + dob);
	    System.out.println("4: " + mobNum);
	    System.out.println("5: " + address);
	    System.out.println("6: " + beddingType);
	    System.out.println("7: " + roomType);
	    System.out.println("8: " + costNum);
	    System.out.println("9: " + noOfRooms);
	    System.out.println("10: " + totalCost);
	    System.out.println("11: " + mealPlan);
	    System.out.println("12: " + checkOut);
		
		// Perform validation, parsing, or any necessary processing
		/*
		if (dob != null && !dob.isEmpty()) {
		    try {
		        java.util.Date dob1 = java.sql.Date.valueOf(dob);
		        
		    } catch (IllegalArgumentException e) {
		        
		    }
		}
		
		if (checkOut != null && !checkOut.isEmpty()) {
		    try {
		        java.util.Date checkOut1 = java.sql.Date.valueOf(checkOut);
		        
		    } catch (IllegalArgumentException e) {
		        
		    }
		}
		*/
		
		//SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		//java.util.Date jdate = null;
		//java.util.Date dob1 =  s.parse(dob);
		DBFactory df= new DBFactory();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try {
			
			Connection con = df.getConnection();
			System.out.println("");
			PreparedStatement ps = con.prepareStatement("INSERT INTO bookroom (emailId, name, noOfRooms, DOB, mobNum, mealPlan, checkIn, checkOut, beddingType, roomType, costNum, address, totalCost) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,email);
			ps.setString(2, name);
			ps.setInt(3, noOfRooms);
			java.util.Date dob1 = java.sql.Date.valueOf(dob);
			ps.setDate(4,   (Date) dob1);
			ps.setInt(5, mobNum);
			ps.setString(6, mealPlan);
			java.util.Date checkIn1 = java.sql.Date.valueOf(checkIn);
			ps.setDate(7,(Date) checkIn1);
			java.util.Date checkOut1 = java.sql.Date.valueOf(checkOut);
			ps.setDate(8,(Date) checkOut1);
			ps.setString(9, beddingType);
			ps.setString(10, roomType);
			ps.setBigDecimal(11, costNum);
			ps.setString(12, address);
			ps.setBigDecimal(13, totalCost);
			
			
			int x  = ps.executeUpdate();
			if(x>0){
				System.out.println("Data is stored successfully");
				session.setAttribute("succMsg", "Added successfull");
				out.println("Added successfull");
				request.setAttribute("message", "Booking Successful");
		        request.setAttribute("details","The booking has been succesfully received. <br> You can choose to Pay from the View My Booking page whenever you want<br>Thank You for choosing us");
		        request.setAttribute("nextURL", "index.jsp");
		        request.getRequestDispatcher("success.jsp").forward(request, response);
				con.commit();
			}
			else {
				request.setAttribute("message", "Error in Booking");
		        request.setAttribute("details","Please try again later <br> Thank You for choosing us");
		        request.setAttribute("nextURL", "index.jsp");
		        request.getRequestDispatcher("error.jsp").forward(request, response);
			}

			df.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
