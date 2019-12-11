package com.example.doit13_java;

public class Data {

    private String name;
    private String birthday;
    private String telt;

    public Data(){

    }

    public Data(String name, String birthday, String telt) {
        this.name = name;
        this.birthday = birthday;
        this.telt = telt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelt() {
        return telt;
    }

    public void setTelt(String telt) {
        this.telt = telt;
    }
}
