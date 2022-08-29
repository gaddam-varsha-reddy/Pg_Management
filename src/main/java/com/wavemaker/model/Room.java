package com.wavemaker.model;
import java.util.Objects;

public class Room {
    int id;
    int roomNo;
    int floorNo;
    int totalBeds;
    public Room(int id,int roomNo,int floorNo,int totalBeds){
        this.id=id;
        this.roomNo=roomNo;
        this.floorNo=floorNo;
        this.totalBeds=totalBeds;
    }

    public int getId() {
        return id;
    }
    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(int totalBeds) {
        this.totalBeds = totalBeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && roomNo == room.roomNo && floorNo == room.floorNo && totalBeds == room.totalBeds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNo, floorNo, totalBeds);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNo=" + roomNo +
                ", floorNo=" + floorNo +
                ", totalBeds=" + totalBeds +
                '}';
    }
}
