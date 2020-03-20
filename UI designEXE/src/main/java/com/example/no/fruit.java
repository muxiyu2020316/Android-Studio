package com.example.no;

public class fruit{
    private String name;
    private int imageId;


    public fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}