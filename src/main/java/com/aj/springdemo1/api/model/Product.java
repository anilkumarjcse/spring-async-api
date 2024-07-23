package com.aj.springdemo1.api.model;

public class Product {

    public Product(int id, String name){
        this.id = id;
        this.name= name;
    }
    public void setTrackingNum(String trackingNum) {
        this.trackingNum = trackingNum;
    }
    public String getTrackingNum() {
        return trackingNum;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    String name;
    int id;
    private String trackingNum;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    private String errorCode;


}
