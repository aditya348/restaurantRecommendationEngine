package org.RecomendationEngine.Strategy.SortingStrategy;

import org.RecomendationEngine.Models.*;

import java.util.ArrayList;

public class FeaturedRestaurantSortingStrategy implements SortingStrategy {

    @Override
    public void sort(User user, ArrayList<Restaurant> restaurant, ArrayList<String> result) {
        ArrayList<CuisineTracking> cuisines = user.sortCuisineTracking().getCuisines();
        Cuisine primaryCuisine = cuisines.get(0).getCuisineType();
        Cuisine secondaryCuisine1 = cuisines.get(1).getCuisineType();
        Cuisine secondaryCuisine2 = cuisines.get(2).getCuisineType();

        ArrayList<CostTracking> costTracking = user.sortCostTracking().getCostTracking();
        CostBracket primaryCostBracket = costTracking.get(0).getCostBrackettype();
        CostBracket secondaryCostBracket1 = costTracking.get(1).getCostBrackettype();
        CostBracket secondaryCostBracket2 = costTracking.get(2).getCostBrackettype();

        if( primaryCuisine == null || primaryCostBracket == null )  return;

        ArrayList<String> tempResult = new ArrayList<>();
        int idx = result.size();

        for( int i = 0; i < restaurant.size(); i++ ){
            if( restaurant.get(i).isRecommended() == true && restaurant.get(i).getCuisine().equals(primaryCuisine) && restaurant.get(i).getCostBracket().equals(primaryCostBracket)){
                tempResult.add(restaurant.get(i).getRestaurantId());
            }
            ++idx;
            if(idx >= 100) return;
        }

        if(tempResult.size() == 0 ){

            if( secondaryCostBracket1 == null || secondaryCostBracket2 == null )  return;

            for( int i = 0; i < restaurant.size(); i++ ){
                if( restaurant.get(i).isRecommended() == true &&
                        restaurant.get(i).getCuisine().equals(primaryCuisine) &&
                           (restaurant.get(i).getCostBracket().equals(secondaryCostBracket1) || restaurant.get(i).getCostBracket().equals(secondaryCostBracket2)) ){

                    tempResult.add(restaurant.get(i).getRestaurantId());

                }
                ++idx;
                if(idx >= 100) return;
            }

            if(secondaryCuisine1 == null || secondaryCuisine2 == null )  return;

            for( int i = 0; i < restaurant.size(); i++ ){
                if( restaurant.get(i).isRecommended() == true &&
                        (restaurant.get(i).getCuisine().equals(secondaryCuisine1) || restaurant.get(i).getCuisine().equals(secondaryCuisine2)) &&
                           restaurant.get(i).getCostBracket().equals(primaryCostBracket)){

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
}
