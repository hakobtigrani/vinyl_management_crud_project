package com.vinyl_management.vinyl_management.model;

public class Vinyl {
    private int id;
    private String title;
    private String artist;
    private String genre;
    private int year;
    private String condition;
    private double price;

    public Vinyl() {
    }

    public Vinyl(int id, String title, String artist,
                 String genre, int year, String condition, double price) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.condition = condition;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return
                "\nVINYL ID: " + id +
                "\nTITLE: " + title +
                "\nARTIST: " + artist +
                "\nGENRE: " + genre +
                "\nYEAR: " + year +
                "\nCONDITION: " + condition +
                "\nPRICE: " + price;
    }
}
