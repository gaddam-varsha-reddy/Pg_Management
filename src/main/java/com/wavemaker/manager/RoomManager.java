package com.wavemaker.manager;
import com.wavemaker.model.Room;

import java.util.ArrayList;
import java.util.List;

public interface RoomManager {
    void addRoom(Room room);
    List<Room> displayRooms();
    void deleteRoom(int floorNo,int roomNo);
}
