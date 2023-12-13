package com.example.util;

import java.math.BigDecimal;
import java.util.Date;

public class Booking {
    private int bookingID;
    private String emailId;
    private String name;
    private int noOfRooms;
    private Date DOB;
    private int mobNum;
    private String mealPlan;
    private Date checkIn;
    private Date checkOut;
    private String beddingType;
    private String roomType;
    private BigDecimal costNum;
    private String address;
    private BigDecimal totalCost;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public int getMobNum() {
        return mobNum;
    }

    public void setMobNum(int mobNum) {
        this.mobNum = mobNum;
    }

    public String getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(String mealPlan) {
        this.mealPlan = mealPlan;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getBeddingType() {
        return beddingType;
    }

    public void setBeddingType(String beddingType) {
        this.beddingType = beddingType;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getCostNum() {
        return costNum;
    }

    public void setCostNum(BigDecimal costNum) {
        this.costNum = costNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
