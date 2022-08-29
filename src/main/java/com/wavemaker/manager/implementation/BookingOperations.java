package com.wavemaker.manager.implementation;
import com.wavemaker.connectivity.MySQLConnectionUtility;
import com.wavemaker.manager.BookingManager;
import com.wavemaker.model.Booking;
import com.wavemaker.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingOperations implements BookingManager {
    @Override
    public void addBooking(int userId,int bedId){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into Booking(User_Id,Bed_Id) values(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, bedId);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in adding booking");
        }

    }
    @Override
    public void deleteBooking(int userId,int bedId){

        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "DELETE FROM Booking WHERE User_Id = ? and Bed_Id=?";
        try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, userId);
                ps.setInt(2, bedId);
                ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in deleting booking");
        }
    }
    @Override
    public List<Booking> displayBookings(){

        List<Booking> bookingList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Booking");
            while (resultSet.next()) {
                int Id = resultSet.getInt("ID");
                int userId = resultSet.getInt("User_Id");
                int bedId = resultSet.getInt("Bed_Id");
                bookingList.add(new Booking(Id,userId,bedId));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying bookings");
        }
        return bookingList;
    }
}
