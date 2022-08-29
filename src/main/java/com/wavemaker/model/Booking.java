package com.wavemaker.model;

import java.util.Objects;

public class Booking {
    int Id;
    int userId;
    int bedId;
    public Booking(int Id,int userId,int bedId){
        this.Id=Id;
        this.userId=userId;
        this.bedId=bedId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Id == booking.Id && userId == booking.userId && bedId == booking.bedId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, userId, bedId);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", bedId=" + bedId +
                '}';
    }
}
