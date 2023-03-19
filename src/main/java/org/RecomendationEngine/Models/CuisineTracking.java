package org.RecomendationEngine.Models;

public class CuisineTracking {
    private Cuisine cuisineType;
    private int noOfOrders;

    public CuisineTracking(Cuisine cuisineType, int noOfOrders) {
        this.cuisineType = cuisineType;
        this.noOfOrders = noOfOrders;
    }

    public Cuisine getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(Cuisine cuisineType) {
        this.cuisineType = cuisineType;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void setNoOfOrders(int noOfOrders) {
        this.noOfOrders = noOfOrders;
    }
}
