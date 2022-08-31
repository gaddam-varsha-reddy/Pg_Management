package com.wavemaker.manager;

import com.wavemaker.model.Bed;

import java.util.List;

public interface BedManager {
    void addBed(int roomId,int totalBeds);
    void deleteBed(int roomId,int totalBeds);
    List<Bed> displayBeds();
    int searchBedId(int roomNo,int floorNo,int bedNo);
    void updateBedStatusOccupied(int id);
    void updateBedStatusVaccant(int id);
}
