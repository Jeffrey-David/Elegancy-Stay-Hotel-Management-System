package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.util.DBFactory;
import com.example.util.PasswordHasher;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve user input from the login form
        String email = request.getParameter("emailId");
        String password = request.getParameter("pass");

        // Perform authentication logic (you should replace this with your actual authentication code)
        boolean isAuthenticated = authenticateUser(email, password);

        if (isAuthenticated) {
            // If authentication is successful, you can redirect to a welcome page
            response.sendRedirect("welcome.jsp");
        } else {
            // If authentication fails, you can redirect back to the login page with an error message
        	request.setAttribute("message", "Incorrect Email ID or Password");
            request.setAttribute("details","Try again");
            request.setAttribute("nextURL", "login.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response); 
        }
    }

    private boolean authenticateUser(String email, String password) {
        try (Connection connection = DBFactory.getConnection()) {
            // Prepare a SQL query to check if the user with the provided email and password exists
        	String hashedPassword = PasswordHasher.hashPassword(email,password);
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, hashedPassword);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // If there is a matching user in the table, authentication is successful
                    return resultSet.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // If there was an error or no matching user, authentication fails
        return false;
    }
}