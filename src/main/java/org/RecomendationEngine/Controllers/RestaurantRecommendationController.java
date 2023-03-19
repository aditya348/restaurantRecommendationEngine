package org.RecomendationEngine.Controllers;

import org.RecomendationEngine.Models.Restaurant;
import org.RecomendationEngine.Models.User;
import org.RecomendationEngine.Services.RestaurantRecommendationService;
import org.RecomendationEngine.Strategy.SortingStrategy.SortingStrategy;

import java.util.ArrayList;

public class RestaurantRecommendationController {
    RestaurantRecommendationService restaurantRecommendationService = new RestaurantRecommendationService();
    public ArrayList<String> getRestaurantRecommendation(User user, ArrayList<Restaurant> restaurants, ArrayList<SortingStrategy> sortingStrategies){
        return restaurantRecommendationService.getRestaurantRecommendations(user, restaurants,sortingStrategies);
    }
}
