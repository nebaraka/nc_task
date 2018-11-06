package com.nc.model;

public class Arrival {
    private int id;
    private String number;
    private String destName;
    private String arrTime;
    private String depTime;
    private String gate;
    private String airlaneName;
    private String planeMark;

    public Arrival() {
        this.id = 0;
        this.number = null;
        this.destName = null;
        this.arrTime = null;
        this.depTime = null;
        this.gate = null;
        this.airlaneName = null;
        this.planeMark = null;
    }

    public Arrival(int id, String number, String destName, String arrTime, String depTime, String gate, String airlaneName, String planeMark) {
        this.id = id;
        this.number = number;
        this.destName = destName;
        this.arrTime = arrTime;
        this.depTime = depTime;
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

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
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
