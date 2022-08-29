package com.wavemaker.manager;

import com.wavemaker.model.Booking;

import java.util.List;

public interface BookingManager {
    void addBooking(int userId,int bedId);
    void deleteBooking(int userId,int bedId);
    List<Booking> displayBookings();
}
