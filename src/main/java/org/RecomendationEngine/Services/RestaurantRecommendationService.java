package org.RecomendationEngine.Services;

import org.RecomendationEngine.Models.Restaurant;
import org.RecomendationEngine.Models.User;
import org.RecomendationEngine.Strategy.SortingStrategy.SortingStrategy;

import java.util.ArrayList;

public class RestaurantRecommendationService {
    ArrayList<String> result;

    public RestaurantRecommendationService() {
        this.result = new ArrayList<>();
    }

    public ArrayList<String> getRestaurantRecommendations( User user, ArrayList<Restaurant> restaurant, ArrayList<SortingStrategy> sortingOrder){

        for( int i = 0; i < sortingOrder.size(); i++ ){
            sortingOrder.get(i).sort(user, restaurant, this.result);
            if(this.result.size() >= 100) break;
        }

        return result;
    }
}
