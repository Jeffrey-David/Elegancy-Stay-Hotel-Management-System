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

// ... (other imports)

public class ContactUsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data from the request
        String email = request.getParameter("email");
        String header = request.getParameter("header");
        String message = request.getParameter("message");

        // Database connection details (update these with your database information)

        try (Connection connection = DBFactory.getConnection()) {
            String insertQuery = "INSERT INTO contact_queries (email, header, message) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, header);
                preparedStatement.setString(3, message);

                // Execute the insert statement
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors as needed
        }

        // Redirect back to the ContactUs.jsp page or a thank-you page
		request.setAttribute("message", "Thank You for Contacting Us");
        request.setAttribute("details","We will get back to you within 2 working days");
        request.setAttribute("nextURL", "index.jsp");
        request.getRequestDispatcher("success.jsp").forward(request, response);
    }
}
