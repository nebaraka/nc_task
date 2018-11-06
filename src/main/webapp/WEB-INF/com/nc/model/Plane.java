package com.nc.model;

public class Plane {
    private int id;
    private String modelName;
    private int seatsAmount;
    private String mark;
    private String airlane;
    private int radius;

    public Plane() {
        this.id = 0;
        this.modelName = null;
        this.seatsAmount = 0;
        this.mark = null;
        this.airlane = null;
        this.radius = 0;
    }

    public Plane(int id, String modelName, int seatsAmount, String mark, String airlane, int radius) {
        this.id = id;
        this.modelName = modelName;
        this.seatsAmount = seatsAmount;
        this.mark = mark;
        this.airlane = airlane;
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getSeatsAmount() {
        return seatsAmount;
    }

    public void setSeatsAmount(int seatsAmount) {
        this.seatsAmount = seatsAmount;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getAirlane() {
        return airlane;
    }

    public void setAirlane(String airlane) {
        this.airlane = airlane;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
