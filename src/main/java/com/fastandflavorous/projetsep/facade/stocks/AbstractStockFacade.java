package com.fastandflavorous.projetsep.facade.stocks;

import com.fastandflavorous.projetsep.facade.costs.AbstractCostsFacade;
import com.fastandflavorous.projetsep.facade.costs.CostsFacade;
import com.fastandflavorous.projetsep.facade.menus.AbstractMenuFacade;
import com.fastandflavorous.projetsep.facade.menus.MenuFacade;
import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.costs.Cost;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.stocks.Stock;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStockFacade {

    protected AbstractFactory factory;
    protected AbstractCostsFacade costFacade;
    /**
     * Default constructor
     */
    protected AbstractStockFacade() {
        this.factory = AbstractFactory.getFactory();
        this.costFacade = new CostsFacade();
    }

    public static AbstractStockFacade getFacade(){
        return new StockFacade();
    }

    public abstract List<Stock> getStocks();

    public abstract void dumpStock(String name, int quantity);

    public abstract void buyStock(String name, int quantity);

    public abstract void editStock(int idStock, int quantity);

    public abstract void useStock(String name, int quantity);
}
