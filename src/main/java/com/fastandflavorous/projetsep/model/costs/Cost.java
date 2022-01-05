package com.fastandflavorous.projetsep.model.costs;

import java.util.Date;

public class Cost {
    private int idCost;
    private String label;
    private float amount;
    private Date lastModificationDate;

    public Cost(String label){
        this.label = label;

    }
    public Cost(int idCost, String label,float amount, Date lastModificationDate){
        this.idCost = idCost;
        this.label = label;
        this.amount = amount;
        this.lastModificationDate = lastModificationDate;

    }

    public float getAmount(){
        return amount;
    }

    public int getIdCost(){
        return idCost;
    }

    public String getLabel(){ return label;}

    public void setAmount(float newAmount){
        amount = newAmount;
        lastModificationDate = new Date();
    }
    public void initializeAmount(){
        amount = 0;
    }

    public void addAmount(float additionalAmount){
        amount += additionalAmount;
        lastModificationDate = new Date();

    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "idCost=" + idCost +
                ", label='" + label + '\'' +
                ", amount=" + amount +
                ", lastModificationDate=" + lastModificationDate +
                '}';
    }
}
