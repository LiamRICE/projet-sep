package com.fastandflavorous.projetsep.facade.costs;

import com.fastandflavorous.projetsep.model.costs.Cost;

import java.util.List;

public abstract class AbstractCostsFacade {

    public abstract List<Cost> getAllCosts();

    public abstract Cost addCost(String label);

    public abstract void deleteCost(int idCost);

    public abstract void initializeAmountCostById(int idCost);

    public abstract void setAmount(int idCost, float newAmount);

    public abstract void addAmountToCostById(int idCost,float additionalAmount);


    }
