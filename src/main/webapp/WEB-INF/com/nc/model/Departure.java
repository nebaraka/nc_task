package com.nc.model;

public class Departure {
    private int id;
    private String number;
    private String destName;
    private String depTime;
    private String arrTime;
    private String gate;
    private String airlaneName;
    private String planeMark;

    public Departure() {
        this.id = 0;
        this.number = null;
        this.destName = null;
        this.depTime = null;
        this.arrTime = null;
        this.gate = null;
        this.airlaneName = null;
        this.planeMark = null;
    }

    public Departure(int id, String number, String destName, String depTime, String arrTime, String gate, String airlaneName, String planeMark) {
        this.id = id;
        this.number = number;
        this.destName = destName;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.gate = gate;
        this.airlaneName = airlaneName;
        this.planeMark = planeMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getAirlaneName() {
        return airlaneName;
    }

    public void setAirlaneName(String airlaneName) {
        this.airlaneName = airlaneName;
    }

    public String getPlaneMark() {
        return planeMark;
    }

    public void setPlaneMark(String planeMark) {
        this.planeMark = planeMark;
    }
}
