package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.util.DBFactory;
import com.example.util.PasswordHasher;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve user input from the registration form
        String userName = request.getParameter("userName");
        String emailId = request.getParameter("emailId");
        String mobNum = request.getParameter("mobNum");
        String password = request.getParameter("pass");

        // Validate user input (e.g., check for empty fields or valid email format)

        // Hash the password for security (use a strong password hashing library)
        String hashedPassword = PasswordHasher.hashPassword(emailId,password);

        // Insert user data into the database (you should replace this with your database code)
        boolean isUserRegistered = registerUser(userName, emailId, mobNum, hashedPassword);

        if (isUserRegistered) {
            // If registration is successful, you can redirect to a success page
        	request.setAttribute("message", "Registration Successful");
            request.setAttribute("details","Your account has been successfully registered");
            request.setAttribute("nextURL", "login.jsp");
            request.getRequestDispatcher("success.jsp").forward(request, response); 	
        } else {
            // If registration fails, you can redirect back to the registration page with an error message
        	request.setAttribute("message", "Registration Not Successful");
            request.setAttribute("details","Try again");
            request.setAttribute("nextURL", "registration.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response); 	
        }
    }


    public boolean registerUser(String userName, String emailId, String mobNum, String hashedPassword) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // Establish a database connection
            conn = DBFactory.getConnection();

            // Define your SQL query to insert a new user
            String sql = "INSERT INTO hotel.users (name, email, mobile_number, password) VALUES (?, ?, ?, ?)";

            // Create a PreparedStatement with the SQL query
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setString(2, emailId);
            stmt.setString(3, mobNum);
            stmt.setString(4, hashedPassword);

            // Execute the query to insert the new user
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0; // Registration is successful if at least one row is affected
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Close the database resources in a finally block
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
