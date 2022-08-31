package com.wavemaker.manager.implementation;

import com.wavemaker.connectivity.MySQLConnectionUtility;
import com.wavemaker.manager.RoomBedManager;
import com.wavemaker.model.Roombed;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomBedOperations implements RoomBedManager {
    @Override
    public List<Roombed> displayAllRooms(){
        List<Roombed> roomBedList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select Room.Room_No,Room.Floor_No,Bed.Bed_No,Bed.isfull from Room inner join Bed on Room.Id=Bed.Room_Id;");
            while (resultSet.next()) {
                int roomno = resultSet.getInt("Room_No");
                int floorno = resultSet.getInt("Floor_No");
                int bedno = resultSet.getInt("Bed_No");
                boolean isfull = resultSet.getBoolean("isfull");
                roomBedList.add(new Roombed(roomno,floorno,bedno,isfull));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying all rooms");
        }
        return roomBedList;
    }
    @Override
    public List<Roombed> displayAllOccupiedRooms(){
        List<Roombed> roomBedList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select Room.Room_No,Room.Floor_No,Bed.Bed_No,Bed.isfull from Room inner join Bed on Room.Id=Bed.Room_Id where isfull=true;");
            while (resultSet.next()) {
                int roomno = resultSet.getInt("Room_No");
                int floorno = resultSet.getInt("Floor_No");
                int bedno = resultSet.getInt("Bed_No");
                boolean isfull = resultSet.getBoolean("isfull");
                roomBedList.add(new Roombed(roomno,floorno,bedno,isfull));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying all rooms");
        }
        return roomBedList;
    }
    @Override
    public List<Roombed> displayAllVaccantRooms(){
        List<Roombed> roomBedList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select Room.Room_No,Room.Floor_No,Bed.Bed_No,Bed.isfull from Room inner join Bed on Room.Id=Bed.Room_Id where isfull=false;");
            while (resultSet.next()) {
                int roomno = resultSet.getInt("Room_No");
                int floorno = resultSet.getInt("Floor_No");
                int bedno = resultSet.getInt("Bed_No");
                boolean isfull = resultSet.getBoolean("isfull");
                roomBedList.add(new Roombed(roomno,floorno,bedno,isfull));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying all rooms");
        }
        return roomBedList;
    }
}
