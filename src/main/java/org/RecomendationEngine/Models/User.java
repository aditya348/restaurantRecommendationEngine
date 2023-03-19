package org.RecomendationEngine.Models;

import java.util.*;

public class User {

    class CuisineTrackingComparator implements Comparator<CuisineTracking>{

        @Override
        public int compare(CuisineTracking o1, CuisineTracking o2) {
            return o2.getNoOfOrders() - o1.getNoOfOrders();
        }

    }

    class CostTrackingComparator implements Comparator<CostTracking>{

        @Override
        public int compare(CostTracking o1, CostTracking o2) {
            return o2.getNoOfOrders() - o1.getNoOfOrders();
        }

    }
    private ArrayList<CuisineTracking> cuisines;
    private ArrayList<CostTracking> costTracking;

    public User() {
        this.cuisines = new ArrayList<>();
        this.costTracking = new ArrayList<>();
    }

    public ArrayList<CuisineTracking> getCuisines() {
        return cuisines;
    }

    public void setCuisines(ArrayList<CuisineTracking> cuisines) {
        this.cuisines = cuisines;
    }

    public ArrayList<CostTracking> getCostTracking() {
        return costTracking;
    }

    public void setCostTracking(ArrayList<CostTracking> costTracking) {
        this.costTracking = costTracking;
    }


    public User sortCuisineTracking(){
        Collections.sort(cuisines, new CuisineTrackingComparator());
        return this;
    }

    public User sortCostTracking(){
        Collections.sort(costTracking, new CostTrackingComparator());
        return this;
    }
}
