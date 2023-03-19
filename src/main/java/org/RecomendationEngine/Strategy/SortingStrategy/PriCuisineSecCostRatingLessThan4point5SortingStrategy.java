package org.RecomendationEngine.Strategy.SortingStrategy;

import org.RecomendationEngine.Models.*;

import java.util.ArrayList;

public class PriCuisineSecCostRatingLessThan4point5SortingStrategy implements SortingStrategy{
    @Override
    public void sort(User user, ArrayList<Restaurant> restaurant, ArrayList<String> result) {
        ArrayList<CuisineTracking> cuisines = user.sortCuisineTracking().getCuisines();
        Cuisine primaryCuisine = cuisines.get(0).getCuisineType();

        ArrayList<CostTracking> costTracking = user.sortCostTracking().getCostTracking();
        CostBracket secondaryCostBracket1 = costTracking.get(1).getCostBrackettype();
        CostBracket secondaryCostBracket2 = costTracking.get(2).getCostBrackettype();

        if( primaryCuisine == null || secondaryCostBracket1 == null || secondaryCostBracket2 == null )  return;

        ArrayList<String> tempResult = new ArrayList<>();
        int idx = result.size();

        for( int i = 0; i < restaurant.size(); i++ ){
            if( restaurant.get(i).getRating() < 4.5 &&
                    restaurant.get(i).getCuisine().equals(primaryCuisine) &&
                    (restaurant.get(i).getCostBracket().equals(secondaryCostBracket1) || restaurant.get(i).getCostBracket().equals(secondaryCostBracket2))){
                tempResult.add(restaurant.get(i).getRestaurantId());
            }
            ++idx;
            if(idx >= 100) return;
        }



        for( int i = 0; i < tempResult.size(); i++){
            result.add(tempResult.get(i));
        }

    }
}
