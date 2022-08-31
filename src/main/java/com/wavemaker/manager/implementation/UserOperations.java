package com.wavemaker.manager.implementation;
import com.wavemaker.connectivity.MySQLConnectionUtility;
import com.wavemaker.manager.UserManager;
import com.wavemaker.model.Room;
import com.wavemaker.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserOperations implements UserManager {
    @Override
    public void addUser(User user){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into User(First_Name,Last_Name,Mobile_No,Email,Age) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getMobileNo());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getAge());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in adding user");
        }
    }
    @Override
    public void deleteUser(String Email){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "DELETE FROM User WHERE Email=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Email);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in deleting user");
        }
    }
    @Override
    public List<User> displayUsers(){
        List<User> userList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()) {
                int Id = resultSet.getInt("ID");
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                String mobileNo = resultSet.getString("Mobile_No");
                String email= resultSet.getString("Email");
                int age = resultSet.getInt("Age");
                userList.add(new User(Id,firstName,lastName,mobileNo,email,age));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying user");
        }
        return userList;
    }
    @Override
    public int searchUserId(String email){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "SELECT Id FROM User where email=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                return id;
            }
        }
        catch (Exception e) {
            System.out.println("Exception found in searching user id");
        }
       return -1;
    }
}
