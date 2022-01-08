package com.fastandflavorous.projetsep.dao.costs;

import com.fastandflavorous.projetsep.model.costs.Cost;

import java.util.Date;
import java.util.List;

public abstract class AbstractCostsDAO {

    public abstract List<Cost> getAllCosts();

    public abstract Cost getCostById(int idCost);

    public abstract Cost addCostWithAmount(String label,float amount);

    public abstract Cost addCostWithoutAmount(String label);

    public abstract void removeCostById(int idCost);

    public abstract void setCostAmount(int idCost, float amount, Date modificationDate);

    public abstract void setCostLabel(int idCost, String label, Date modificationDate);
}
