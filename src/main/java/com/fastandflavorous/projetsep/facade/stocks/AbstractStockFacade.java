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
        this.factory.getStockDAO().removeStock(name, quantity);
    }

    public void buyStock(String name, int quantity){
        this.factory.getStockDAO().addStock(name, quantity);
    }

    public void useStock(int idStock, int quantity){

    }

    public void useStock(String name, int quantity){
        int idMenu = factory.getMenuDAO().getMenuIndex(name);
        useStock(idMenu, quantity);
    }
}
