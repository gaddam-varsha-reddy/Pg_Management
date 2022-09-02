package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.BedManager;
import com.wavemaker.manager.implementation.BedOperations;
import com.wavemaker.model.Bed;
import com.wavemaker.model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BedServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    BedManager bedManager=new BedOperations();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int bedid=Integer.parseInt(request.getParameter("bedId"));
        bedManager.updateBedStatusOccupied(bedid);
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int bedid=Integer.parseInt(request.getParameter("bedId"));
        bedManager.updateBedStatusVaccant(bedid);
    }
}
