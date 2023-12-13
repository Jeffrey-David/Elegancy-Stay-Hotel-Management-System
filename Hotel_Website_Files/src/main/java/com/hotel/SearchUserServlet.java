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


public class SearchUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the search query from the request parameters
        String query = request.getParameter("text");

        // Perform the search and get a list of related functionalities and their URLs
        List<Functionality> searchResults = performSearch(query);

        // Set the search results as an attribute in the request
        request.setAttribute("searchResults", searchResults);

        // Forward the request to the SearchUser.jsp page
        request.getRequestDispatcher("SearchUser.jsp").forward(request, response);
    }

    private List<Functionality> performSearch(String query) {
        // Replace this with your actual search logic
        List<Functionality> results = new ArrayList<>();

        // Simulated search results (you should replace this with real data)
        if ("".equalsIgnoreCase(query)||"room".equalsIgnoreCase(query)||"rooms".equalsIgnoreCase(query)||"book".equalsIgnoreCase(query)||"booking".equalsIgnoreCase(query)||"bookings".equalsIgnoreCase(query)) {
            results.add(new Functionality("To Book Room", "BookServlet"));
        } 
        if ("".equalsIgnoreCase(query)||"room".equalsIgnoreCase(query)||"history".equalsIgnoreCase(query)||"book".equalsIgnoreCase(query)||"booking".equalsIgnoreCase(query)||"bookings".equalsIgnoreCase(query)) {
            results.add(new Functionality("View Booking History", "MyBooking.jsp"));
        } 
        if ("".equalsIgnoreCase(query)||"room".equalsIgnoreCase(query)||"payment".equalsIgnoreCase(query)||"book".equalsIgnoreCase(query)||"booking".equalsIgnoreCase(query)||"bookings".equalsIgnoreCase(query)) {
            results.add(new Functionality("For Payment", "MyBooking.jsp"));
        } 
        
        if ("".equalsIgnoreCase(query)||"login".equalsIgnoreCase(query)||"admin".equalsIgnoreCase(query)) {
            results.add(new Functionality("Admin Login", "login.jsp"));
        }
        if ("".equalsIgnoreCase(query)||"registration".equalsIgnoreCase(query)||"admin".equalsIgnoreCase(query)) {
            results.add(new Functionality("Admin Registration", "registration.jsp"));
        }
        if ("".equalsIgnoreCase(query)||"query".equalsIgnoreCase(query)||"contact".equalsIgnoreCase(query)) {
            results.add(new Functionality("Contact Us", "ContactUs.jsp"));
        }
        
        return results;
    }
}

