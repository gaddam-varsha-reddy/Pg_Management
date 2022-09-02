package com.wavemaker.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.RoomBedManager;
import com.wavemaker.manager.RoomManager;
import com.wavemaker.manager.UserManager;
import com.wavemaker.manager.implementation.RoomBedOperations;
import com.wavemaker.manager.implementation.Roomoperations;
import com.wavemaker.manager.implementation.UserOperations;
import com.wavemaker.model.Room;
import com.wavemaker.model.Roombed;
import com.wavemaker.model.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class RoomServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    RoomManager roomManager=new Roomoperations();
    RoomBedManager roomBedManager=new RoomBedOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Room> room = roomManager.displayRooms();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(room));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Room room = objectMapper.readValue(request.getReader(), Room.class);
        roomManager.addRoom(room);
    }
    @Override
    protected void doDelete(HttpServletRequest request,HttpServletResponse response) throws IOException{
        roomManager.deleteRoom(Integer.parseInt(request.getParameter("floorNo")),Integer.parseInt(request.getParameter("roomNo")));
    }
}
