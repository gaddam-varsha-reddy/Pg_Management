package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.RoomBedManager;
import com.wavemaker.manager.RoomManager;
import com.wavemaker.manager.UserManager;
import com.wavemaker.manager.implementation.RoomBedOperations;
import com.wavemaker.manager.implementation.Roomoperations;
import com.wavemaker.manager.implementation.UserOperations;
import com.wavemaker.model.Roombed;
import com.wavemaker.model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet  extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
   UserManager userManager=new UserOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> userList = userManager.displayUsers();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userList));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = objectMapper.readValue(request.getReader(), User.class);
        userManager.addUser(user);
    }
    @Override
    protected void doDelete(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //User user=objectMapper.readValue(request.getReader(),User.class);
        userManager.deleteUser(request.getParameter("email"));
    }

}
