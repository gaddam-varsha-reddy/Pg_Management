package com.wavemaker.manager;

import com.wavemaker.model.Roombed;

import java.util.List;

public interface RoomBedManager {
    List<Roombed> displayAllRooms();
    List<Roombed> displayAllOccupiedRooms();
    List<Roombed> displayAllVaccantRooms();
}
