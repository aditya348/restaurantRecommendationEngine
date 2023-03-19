package org.RecomendationEngine.Models;

import java.util.Date;

public class Restaurant {
    private String restaurantId;
    private Cuisine cuisine;
    private CostBracket costBracket;
    private float rating;
    private boolean isRecommended;
    private Date onBoardedTime;

    public Restaurant(String restaurantId, Cuisine cuisine, CostBracket costBracket, Date onBoardedTime) {
        this.restaurantId = restaurantId;
        this.cuisine = cuisine;
        this.costBracket = costBracket;
        this.onBoardedTime = onBoardedTime;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public CostBracket getCostBracket() {
        return costBracket;
    }

    public void setCostBracket(CostBracket costBracket) {
        costBracket = costBracket;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public void setRecommended(boolean recommended) {
        isRecommended = recommended;
    }

    public Date getOnBoardedTime() {
        return onBoardedTime;
    }

    public void setOnBoardedTime(Date onBoardedTime) {
        this.onBoardedTime = onBoardedTime;
    }

}
