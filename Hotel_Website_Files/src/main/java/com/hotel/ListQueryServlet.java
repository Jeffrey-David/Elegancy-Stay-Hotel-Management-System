package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.util.DBFactory;
import com.example.util.QueryData;

public class ListQueryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<QueryData> queries = DBFactory.getQueriesFromDatabase(); // Implement this method to get queries from the database

        request.setAttribute("queries", queries);
        request.getRequestDispatcher("/ListQuery.jsp").forward(request, response);
    }

    // Implement a method to get queries from the database (similar to previous servlets)
}