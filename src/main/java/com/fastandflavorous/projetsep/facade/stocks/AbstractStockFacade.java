package com.fastandflavorous.projetsep.facade.stocks;

import com.fastandflavorous.projetsep.facade.menus.AbstractMenuFacade;
import com.fastandflavorous.projetsep.facade.menus.MenuFacade;
import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.stocks.Stock;

import java.util.ArrayList;
import java.util.List;

public class AbstractStockFacade {

    private AbstractFactory factory;
    /**
     * Default constructor
     */
    protected AbstractStockFacade() {
        this.factory = AbstractFactory.getFactory();
    }

    public static AbstractStockFacade getFacade(){
        return new StockFacade();
    }

    public List<Stock> getStocks(){
        return this.factory.getStockDAO().getStocks();
    }

    public void dumpStock(String name, int quantity){
        int idMenu = factory.getMenuDAO().getMenuIndex(name);
        editStock(idMenu, -quantity);
    }

    public void buyStock(String name, int quantity){
        System.out.println(name);
        int idMenu = factory.getMenuDAO().getMenuIndex(name);
        editStock(idMenu, quantity);
        // add to costs
    }

    public void editStock(int idStock, int quantity){
        System.out.println("Menu ID : "+idStock+"\nQuantity : "+quantity);
        factory.getStockDAO().editStock(idStock, quantity);
    }

    public void useStock(String name, int quantity){
        int idMenu = factory.getMenuDAO().getMenuIndex(name);
        editStock(idMenu, -quantity);
    }
}
