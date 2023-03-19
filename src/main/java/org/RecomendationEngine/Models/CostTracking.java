package org.RecomendationEngine.Models;

public class CostTracking {
    private CostBracket costBrackettype;
    private int noOfOrders;

    public CostTracking(CostBracket costBrackettype, int noOfOrders) {
        this.costBrackettype = costBrackettype;
        this.noOfOrders = noOfOrders;
    }

    public CostBracket getCostBrackettype() {
        return costBrackettype;
    }

    public void setCostBrackettype(CostBracket costBrackettype) {
        this.costBrackettype = costBrackettype;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void setNoOfOrders(int noOfOrders) {
        this.noOfOrders = noOfOrders;
    }
}
