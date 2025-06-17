package com.example.androidlistviewmodelapplication.models;

public class Airline {
    static private int globalId = 0;

    private int id;
    private String title;
    private String city;
    private int logoResource;

    public Airline(String title, String city, int logo){
        this.id = ++globalId;
        this.title = title;
        this.city = city;
        this.logoResource = logo;
    }

    public void setTitle(String value) { this.title = value; }
    public String getTitle() { return this.title; }

    public void setCity(String value) { this.city = value; }
    public String getCity() { return this.city; }

    public void setLogo(int value) { this.logoResource = value; }
    public int getLogo() { return this.logoResource; }
}
