package com.fastandflavorous.projetsep.facade.costs;

import com.fastandflavorous.projetsep.model.costs.Cost;

import java.util.List;

public abstract class AbstractCostsFacade {

    public abstract List<Cost> getAllCosts();

    public abstract Cost addCostWithoutAmount(String label);

    public abstract Cost addCostWithAmount(String label,float amount);

    public abstract void deleteCost(int idCost);

    public abstract void initializeAmountCostById(int idCost);

    public abstract void setAmount(int idCost, float newAmount);

    public abstract void setLabel(int idCost, String newLabel);

    public abstract void addAmountToCostById(int idCost,float additionalAmount);


    }
