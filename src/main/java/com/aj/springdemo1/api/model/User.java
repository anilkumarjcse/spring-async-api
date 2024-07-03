package com.aj.springdemo1.api.model;

public class User {

    private String name;
    private int id;
    private String city;

    public User(int id, String name, String city){
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }


}
