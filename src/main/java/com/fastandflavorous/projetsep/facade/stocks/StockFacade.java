package com.fastandflavorous.projetsep.facade.stocks;

import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.stocks.Stock;

import java.util.List;

public class StockFacade extends AbstractStockFacade{
    protected StockFacade(){
        super();
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
        Menu menu = factory.getMenuDAO().getMenu(idMenu);
        costFacade.addCostWithAmount(name, quantity*menu.getPrice());
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
