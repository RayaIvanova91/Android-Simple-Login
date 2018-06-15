package com.example.rayaivanova.lesson33.model;

public class Hotel {
    public static final int MIN_STARS_COUNT = 0;
    public static final int MAX_STARS_COUNT = 5;
    int image;
    private String name;
    private int countStars;
    private double rating;
    private String address;
    private int distanceFromCenter;
    private int price;
    private boolean prepayment;

    public Hotel(int countStars, int image, String name, double rating, String address, int distanceFromCenter, int price, boolean prepayment) {
        setCountStars(countStars);
        this.image = image;
        this.name = name;
        this.rating = rating;
        this.address = address;
        this.distanceFromCenter = distanceFromCenter;
        this.price = price;
        this.prepayment = prepayment;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getDistanceFromCenter() {
        return distanceFromCenter;
    }

    public int getPrice() {
        return price;
    }

    public boolean isPrepayment() {
        return prepayment;
    }

    public int getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public int getCountStars() {
        return countStars;
    }

    public void setCountStars(int countStars) {
        if (countStars >= MIN_STARS_COUNT && countStars <= MAX_STARS_COUNT) {
            this.countStars = countStars;
        }
    }
}
