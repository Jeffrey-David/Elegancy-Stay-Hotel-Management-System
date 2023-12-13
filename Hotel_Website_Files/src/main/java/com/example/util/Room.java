package com.example.util;

import java.math.BigDecimal;

public class Room {
    private int id;
    private String roomType;
    private int noOfRooms;
    private BigDecimal costNum;
    private String base64Image;

    // Constructors, getters, setters, and other methods
    // ...

    public Room(int id, String roomType, int noOfRooms, BigDecimal costNum) {
        this.id = id;
        this.roomType = roomType;
        this.noOfRooms = noOfRooms;
        this.costNum = costNum;
        this.base64Image = null;
    }
    
    public Room(int id, String roomType, int noOfRooms, BigDecimal costNum, String base64Image) {
        this.id = id;
        this.roomType = roomType;
        this.noOfRooms = noOfRooms;
        this.costNum = costNum;
        this.base64Image = base64Image;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public BigDecimal getCostNum() {
        return costNum;
    }

    public void setCostNum(BigDecimal costNum) {
        this.costNum = costNum;
    }
    
    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    // Add getters and setters for each field
    // ...
}

