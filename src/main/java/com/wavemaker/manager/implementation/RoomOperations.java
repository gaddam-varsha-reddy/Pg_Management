package com.wavemaker.manager.implementation;
import com.wavemaker.connectivity.MySQLConnectionUtility;
import com.wavemaker.manager.BedManager;
import com.wavemaker.manager.RoomManager;
import com.wavemaker.model.Room;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomOperations implements RoomManager {
    @Override
    public void addRoom(Room room) {
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into Room(Room_No,Floor_No,Total_Beds) values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, room.getRoomNo());
            ps.setInt(2, room.getFloorNo());
            ps.setInt(3, room.getTotalBeds());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in adding room");
        }
    }
    @Override
    public List<Room> displayRooms(){
        List<Room> roomList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Room");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int roomNo = resultSet.getInt("Room_No");
                int floorNo = resultSet.getInt("Floor_No");
                int totalBeds = resultSet.getInt("Total_Beds");
                roomList.add(new Room(id,roomNo,floorNo,totalBeds));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying room");
        }
        return roomList;
    }
    @Override
    public void deleteRoom(int floorNo,int roomNo){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "DELETE FROM Room WHERE Room_No = ? and Floor_No=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, roomNo);
            ps.setInt(2, floorNo);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in deleting room");
        }
    }
}