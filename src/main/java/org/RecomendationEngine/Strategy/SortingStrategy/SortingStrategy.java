package org.RecomendationEngine.Strategy.SortingStrategy;

import org.RecomendationEngine.Models.Restaurant;
import org.RecomendationEngine.Models.User;

import java.util.ArrayList;

public interface SortingStrategy {
    public void sort(User user, ArrayList<Restaurant> restaurant, ArrayList<String> result);
}
