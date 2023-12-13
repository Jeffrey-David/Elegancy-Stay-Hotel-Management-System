package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.util.Functionality;


public class SearchAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the search query from the request parameters
        String query = request.getParameter("text");

        // Perform the search and get a list of related functionalities and their URLs
        List<Functionality> searchResults = performSearch(query);

        // Set the search results as an attribute in the request
        request.setAttribute("searchResults", searchResults);

        // Forward the request to the SearchUser.jsp page
        request.getRequestDispatcher("SearchAdmin.jsp").forward(request, response);
    }

    private List<Functionality> performSearch(String query) {
        // Replace this with your actual search logic
        List<Functionality> results = new ArrayList<>();

        // Simulated search results (you should replace this with real data)
        if ("".equalsIgnoreCase(query)||"room".equalsIgnoreCase(query)||"rooms".equalsIgnoreCase(query)) {
            results.add(new Functionality("Add Rooms", "AddRooms.jsp"));
            results.add(new Functionality("List Rooms", "ListRoomsServlet"));
        } 
        if ("".equalsIgnoreCase(query)||"book".equalsIgnoreCase(query)||"booking".equalsIgnoreCase(query)||"bookings".equalsIgnoreCase(query)) {
            results.add(new Functionality("List Bookings", "ListBookingServlet"));
        } 
        if ("".equalsIgnoreCase(query)||"viz".equalsIgnoreCase(query)||"visualization".equalsIgnoreCase(query)||"visualisation".equalsIgnoreCase(query)) {
            results.add(new Functionality("Visualize", "vizDate.jsp"));
        } 
        
        if ("".equalsIgnoreCase(query)||"query".equalsIgnoreCase(query)||"contact".equalsIgnoreCase(query)||"contact us".equalsIgnoreCase(query)) {
            results.add(new Functionality("List Queries", "ListQueryServlet"));
        }
        
        
        return results;
    }
}

