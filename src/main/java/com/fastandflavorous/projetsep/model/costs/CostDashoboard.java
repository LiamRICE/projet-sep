package com.fastandflavorous.projetsep.model.costs;

import java.util.ArrayList;
import java.util.List;

public class CostDashoboard {
    private float totalSalary;
    private float stockCost;
    private float turnover;
    private List<Cost> costs;

    public CostDashoboard(){
        costs = new ArrayList<>();
    }

    public void addCost(Cost cost){
        costs.add(cost);
    }

    public Cost getCostById(int idCost){
        return costs.stream().filter(cost -> idCost == cost.getIdCost()).findAny().orElse(null);
    }

    public void deleteCost(int idCost){
        Cost costToRemove = costs.stream()
                .filter(cost -> idCost == cost.getIdCost())
                .findAny()
                .orElse(null);

        costs.remove(costToRemove);
    }

    public void initTurnover(){
    this.turnover = 0;
    }

    public void setTurnover(float newAmount){
        this.turnover = newAmount;
    }

    public void addAmountToTurnover(float additionalAmount){
        this.turnover += additionalAmount;
    }

    public void initStockCost(){
        this.stockCost = 0;
    }

    public void setStockCost(float newAmount){
        this.stockCost = newAmount;
    }

    public void addAmountToStockCost(float additionalAmount){
        this.stockCost += additionalAmount;
    }

    public void initTotalSalary(){
        this.totalSalary = 0;
    }

    public void setTotalSalary(float newAmount){
        this.totalSalary = newAmount;
    }

    public void addAmountToTotalSalary(float additionalAmount){
        this.totalSalary += additionalAmount;
    }
}
