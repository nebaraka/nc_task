package com.nc.model;

public class Destination {
    private int id;
    private String city;
    private String country;
    private int distance;

    public Destination() {
        this.id = 0;
        this.city = null;
        this.country = null;
        this.distance = 0;
    }

    public Destination(int id, String city, String country, int distance) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
