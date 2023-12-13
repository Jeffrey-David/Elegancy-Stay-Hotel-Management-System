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

public class ResolveQueryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the queryId from the request parameters
        String queryIdStr = request.getParameter("queryId");

        if (queryIdStr != null) {
            try {
                int queryId = Integer.parseInt(queryIdStr);

                // Update the query as resolved in the database
                updateQueryAsResolved(queryId);

                // Redirect to the list of queries
                response.sendRedirect("ListQueryServlet");
            } catch (NumberFormatException e) {
                // Handle invalid queryId
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid queryId");
            }
        } else {
            // Handle missing queryId
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "QueryId parameter missing");
        }
    }

    private void updateQueryAsResolved(int queryId) {
        try (Connection connection = DBFactory.getConnection()) {
            String updateQuery = "UPDATE contact_queries SET resolved = ? WHERE query_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setBoolean(1, true); // Set resolved as true
                preparedStatement.setInt(2, queryId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            // Handle any database-related errors
            e.printStackTrace();
        }
    }
}
