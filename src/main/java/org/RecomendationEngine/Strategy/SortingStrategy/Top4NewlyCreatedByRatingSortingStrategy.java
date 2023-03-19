package org.RecomendationEngine.Strategy.SortingStrategy;

import org.RecomendationEngine.Models.Restaurant;
import org.RecomendationEngine.Models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Top4NewlyCreatedByRatingSortingStrategy implements SortingStrategy{

    class RatingSortComparator implements Comparator<Restaurant>{

        @Override
        public int compare(Restaurant o1, Restaurant o2) {
            if(o1.getOnBoardedTime().compareTo(o2.getOnBoardedTime()) > 0){
                return -1;
            }
            else if( o1.getOnBoardedTime().compareTo(o2.getOnBoardedTime()) < 0){
                return 1;
            }
            else{
                if( o2.getRating() > o1.getRating()) return 1;
                if(o2.getRating() < o1.getRating()) return -1;
                else return 0;
            }
        }
    }

    @Override
    public void sort(User user, ArrayList<Restaurant> restaurant, ArrayList<String> result) {
         Collections.sort(restaurant, new RatingSortComparator());

        ArrayList<String> tempResult = new ArrayList<>();
        int idx = result.size();

        for( int i = 0; i < 4; i++ ){
            tempResult.add(restaurant.get(i).getRestaurantId());
            ++idx;
            if(idx >= 100) return;
        }



        for( int i = 0; i < tempResult.size(); i++){
            result.add(tempResult.get(i));
        }

    }


}
