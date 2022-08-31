package com.wavemaker.model;

import java.util.Objects;

public class Roombed {
    int room_No;
    int floorNo;
    int bed_No;
    boolean isfull;

    public Roombed() {
    }

    public Roombed(int room_No, int floorNo, int bed_No, boolean isfull){
        this.room_No=room_No;
        this.floorNo=floorNo;
        this.bed_No=bed_No;
        this.isfull=isfull;
    }

    public int getRoom_No() {
        return room_No;
    }

    public void setRoom_No(int room_No) {
        this.room_No = room_No;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getBed_No() {
        return bed_No;
    }

    public void setBed_No(int bed_No) {
        this.bed_No = bed_No;
    }

    public boolean getIsfull() {
        return isfull;
    }

    public void setIsfull(boolean isfull) {
        this.isfull = isfull;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roombed roomBed = (Roombed) o;
        return room_No == roomBed.room_No && floorNo == roomBed.floorNo && bed_No == roomBed.bed_No && isfull == roomBed.isfull;
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_No, floorNo, bed_No, isfull);
    }

    @Override
    public String toString() {
        return "Roombed{" +
                "room_No=" + room_No +
                ", floorNo=" + floorNo +
                ", bed_No=" + bed_No +
                ", isfull=" + isfull +
                '}';
    }
}
