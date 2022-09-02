package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.BookingManager;
import com.wavemaker.manager.UserManager;
import com.wavemaker.manager.implementation.BookingOperations;
import com.wavemaker.manager.implementation.UserOperations;
import com.wavemaker.model.Booking;
import com.wavemaker.model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookingServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
   BookingManager bookingManager=new BookingOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Booking> bookingList = bookingManager.displayBookings();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingList));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        bookingManager.addBooking(Integer.parseInt(request.getParameter("userId")),Integer.parseInt(request.getParameter("bedId")));
    }
}
