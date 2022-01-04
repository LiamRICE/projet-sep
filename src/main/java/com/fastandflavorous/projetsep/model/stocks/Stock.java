package com.fastandflavorous.projetsep.model.stocks;

public class Stock {
    private int id;
    private String name;
    private int quantity;

    public Stock(int id, String name, int quantity){
        this.id = id;
        this.name = name;
        this.setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.name + " | " + this.quantity;
    }
}
