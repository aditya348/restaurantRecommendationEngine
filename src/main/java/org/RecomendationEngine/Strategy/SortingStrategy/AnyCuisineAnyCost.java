package org.RecomendationEngine.Strategy.SortingStrategy;

import org.RecomendationEngine.Models.*;

import java.util.ArrayList;

public class AnyCuisineAnyCost implements SortingStrategy{

    @Override
    public void sort(User user, ArrayList<Restaurant> restaurant, ArrayList<String> result) {

        ArrayList<String> tempResult = new ArrayList<>();
        int idx = result.size();

        for( int i = 0; i < restaurant.size(); i++ ){
            if( !result.contains(restaurant.get(i).getRestaurantId()) ) {
                tempResult.add(restaurant.get(i).getRestaurantId());
                ++idx;
                if (idx >= 100) return;
            }
        }



        for( int i = 0; i < tempResult.size(); i++){
            result.add(tempResult.get(i));
        }
    }
}
