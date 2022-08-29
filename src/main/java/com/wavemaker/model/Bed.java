package com.wavemaker.model;

import java.util.Objects;

public class Bed {
    int id;
    int roomId;
    int bedNo;
    boolean isFull;
    public Bed(int id,int roomId,int bedNo,boolean isFull){
        this.id=id;
        this.roomId=roomId;
        this.bedNo=bedNo;
        this.isFull=isFull;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getBedNo() {
        return bedNo;
    }

    public void setBedNo(int bedNo) {
        this.bedNo = bedNo;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bed bed = (Bed) o;
        return id == bed.id && roomId == bed.roomId && bedNo == bed.bedNo && isFull == bed.isFull;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomId, bedNo, isFull);
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", bedNo=" + bedNo +
                ", isFull=" + isFull +
                '}';
    }
}

