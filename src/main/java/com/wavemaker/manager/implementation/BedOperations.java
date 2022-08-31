package com.wavemaker.manager.implementation;

import com.wavemaker.connectivity.MySQLConnectionUtility;
import com.wavemaker.manager.BedManager;
import com.wavemaker.model.Bed;
import com.wavemaker.model.Room;
import com.wavemaker.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BedOperations implements BedManager {
    @Override
    public void addBed(int roomId,int totalBeds){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into Bed(Bed_No,Room_Id,isfull) values(?,?,false)";
        try {

            for(int i=1;i<=totalBeds;i++) {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, i);
                ps.setInt(2, roomId);
                ps.execute();
            }

        }
        catch (SQLException e) {
            System.out.println("Exception found in adding bed");
        }
    }
    @Override
    public void deleteBed(int roomId,int totalBeds){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "DELETE FROM Bed WHERE Room_Id = ? and Bed_No=?";
        try {
            for(int i=1;i<=totalBeds;i++) {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, roomId);
                ps.setInt(2, i);
                ps.execute();
            }
        } catch (SQLException e) {
            System.out.println("Exception found in deleting bed");
        }
    }
    @Override
    public List<Bed> displayBeds(){

        List<Bed> bedList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Bed");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int roomId = resultSet.getInt("Room_Id");
                int bedNo = resultSet.getInt("Bed_No");
                boolean isFull=resultSet.getBoolean("isfull");
                bedList.add(new Bed(id,roomId,bedNo,isFull));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying bedlist");
        }
        return bedList;
    }
    @Override
    public int searchBedId(int roomNo,int floorNo,int bedNo){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "select Id from Room where Room_No=? and Floor_No=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, roomNo);
            statement.setInt(2, floorNo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                sql = "SELECT Id FROM Bed where Room_Id=? and Bed_No=?";
                try {
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.setInt(2, bedNo);
                    resultSet = ps.executeQuery();
                    while (resultSet.next()) {
                        id = resultSet.getInt("ID");
                    return id;
                    }
                }
                catch (Exception e) {
                    System.out.println("Exception found in searching bed id");
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception found in searching room id");
        }
        return -1;
    }
    @Override
    public void updateBedStatusOccupied(int id){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "update Bed set isfull=true where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in updating status");
        }

    }
    @Override
    public void updateBedStatusVaccant(int id){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "update Bed set isfull=false where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in updating status");
        }

    }

}
