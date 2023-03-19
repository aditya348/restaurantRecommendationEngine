package org.RecomendationEngine;

import org.RecomendationEngine.Controllers.RestaurantRecommendationController;
import org.RecomendationEngine.Models.*;
import org.RecomendationEngine.Strategy.SortingStrategy.*;

import java.util.ArrayList;
import java.util.Date;

public class Client {
    public static void main(String[] args) {
        RestaurantRecommendationController restaurantRecommendationController = new RestaurantRecommendationController();
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("123", Cuisine.SOUTHINDIAN, CostBracket.TWO,  new Date("01-Mar-2023")));
        restaurants.add(new Restaurant("235", Cuisine.NORTHINDIAN, CostBracket.ONE,  new Date("02-Mar-2023")));
        restaurants.add(new Restaurant("457", Cuisine.CHINESE, CostBracket.FOUR,  new Date("04-Mar-2023")));
        restaurants.add(new Restaurant("658", Cuisine.ITALIAN, CostBracket.ONE,  new Date("21-Mar-2023")));
        restaurants.add(new Restaurant("856", Cuisine.NORTHINDIAN, CostBracket.FIVE,  new Date("15-Mar-2023")));

        User user = new User();
        user.getCuisines().add(new CuisineTracking(restaurants.get(0).getCuisine(), 1));
        user.getCostTracking().add(new CostTracking(restaurants.get(0).getCostBracket(), 1));

        user.getCuisines().add(new CuisineTracking(restaurants.get(2).getCuisine(), 1));
        user.getCostTracking().add(new CostTracking(restaurants.get(2).getCostBracket(), 1));

        user.getCuisines().add(new CuisineTracking(restaurants.get(4).getCuisine(), 1));
        user.getCostTracking().add(new CostTracking(restaurants.get(4).getCostBracket(), 1));

        ArrayList<SortingStrategy> sortingStrategies = new ArrayList<>();
        sortingStrategies.add(new FeaturedRestaurantSortingStrategy());
        sortingStrategies.add(new PriCuisinePriCostRatingGreaterThan4SortingStrategy());
        sortingStrategies.add(new PriCuisineSecCostRating4point5SortingStrategy());
        sortingStrategies.add(new SecCuisinePriCostRating4point5SortingStrategy());
        sortingStrategies.add(new Top4NewlyCreatedByRatingSortingStrategy());
        sortingStrategies.add(new PriCuisinePriCostRatingLessThan4SortingStrategy());
        sortingStrategies.add(new PriCuisineSecCostRatingLessThan4point5SortingStrategy());
        sortingStrategies.add(new SecCuisinePriCostRatingLessThan4point5SortingStrategy());
        sortingStrategies.add(new AnyCuisineAnyCost());

        ArrayList<String> recommendations = restaurantRecommendationController.getRestaurantRecommendation(user, restaurants, sortingStrategies);
        for( String str : recommendations){
            System.out.println(str);
        }

    }
}