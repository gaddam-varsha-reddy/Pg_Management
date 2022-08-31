package com.wavemaker.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.RoomManager;
import com.wavemaker.manager.implementation.Roomoperations;
import com.wavemaker.model.Room;
import com.wavemaker.model.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class RoomServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    RoomManager roomManager=new Roomoperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Room> room = roomManager.displayRooms();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(room));
    }
}
