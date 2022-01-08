package com.fastandflavorous.projetsep.facade.costs;

import com.fastandflavorous.projetsep.dao.costs.AbstractCostsDAO;
import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.costs.Cost;
import com.fastandflavorous.projetsep.model.costs.CostDashoboard;

import java.util.Date;
import java.util.List;

public class CostsFacade extends AbstractCostsFacade{
    private final AbstractCostsDAO costsDAO;
    private static final CostDashoboard costDashoboard = new CostDashoboard();
    public CostsFacade() {
        costsDAO = AbstractFactory.getFactory().getCostsDAO();

    }

    public List<Cost> getAllCosts(){
        List<Cost> costs = costsDAO.getAllCosts();
        for (Cost cost : costs){
            costDashoboard.addCost(cost);
        }
        return costs;
    }
    public Cost addCost(String label){
        Cost cost = costsDAO.addCost(label);
        costDashoboard.addCost(cost);
        return cost;
    }

    public void deleteCost(int idCost){
        costsDAO.removeCostById(idCost);
        costDashoboard.deleteCost(idCost);
    }

    public void initializeAmountCostById(int idCost){
        costsDAO.setCostAmount(idCost,0,new Date());
        costDashoboard.getCostById(idCost).initializeAmount();
    }

    public void setAmount(int idCost, float newAmount){
        costsDAO.setCostAmount(idCost,newAmount,new Date());
        costDashoboard.getCostById(idCost).setAmount(newAmount);
    }

    public void setLabel(int idCost, String newLabel){
        costsDAO.setCostLabel(idCost,newLabel,new Date());
        costDashoboard.getCostById(idCost).setLabel(newLabel);
    }

    public void addAmountToCostById(int idCost,float additionalAmount){
        float currentAmount = costDashoboard.getCostById(idCost).getAmount();
        costsDAO.setCostAmount(idCost,currentAmount+additionalAmount,new Date());
        costDashoboard.getCostById(idCost).addAmount(additionalAmount);
    }
}
