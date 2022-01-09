package com.fastandflavorous.projetsep.model.orders;

import com.fastandflavorous.projetsep.model.menus.Menu;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Menu> menus;
    private int id;
    private boolean paid;
    private boolean completed;
    private boolean fullfilled;
    private double price;

    /**
     * Default constructor
     */
    public Order(int id,ArrayList<Menu> menus,boolean paid,boolean completed,boolean fullfilled){
        this.id = id;
        this.menus = new ArrayList<Menu>(menus);
        this.paid = paid;
        this.completed = completed;
        this.fullfilled = fullfilled;
        this.price = 0;
    }

    public Order(int id,boolean paid,boolean completed,boolean fullfilled, double price){
        this.id = id;
        this.menus = new ArrayList<Menu>();
        this.paid = paid;
        this.completed = completed;
        this.fullfilled = fullfilled;
        this.price = price;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public int getId() {
        return id;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isFullfilled() {
        return fullfilled;
    }

    public void setFullfilled(boolean fullfilled) {
        this.fullfilled = fullfilled;
    }

    /**
     *
     */
    public double getPrice(){
        double price = 0;
        for(Menu m : this.menus){
            price+= m.getPrice();
        }
        return price;
    }

    /**
     *
     */
    public void addMenuToOrder(Menu menu){
        this.menus.add(menu);
    }

    /**
     *
     */
    public void removeMenuFromOrder(Menu menu){
        this.menus.remove(menu);
    }

}
