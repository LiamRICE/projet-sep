package com.fastandflavorous.projetsep.dao.stocks;

import com.fastandflavorous.projetsep.dao.menus.AbstractMenuDAO;
import com.fastandflavorous.projetsep.dao.menus.MySQLMenuDAO;
import com.fastandflavorous.projetsep.model.stocks.Stock;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AbstractStockDAO {
    private static AbstractStockDAO stockDAO;
    private static Object sync = new Object();

    public static AbstractStockDAO getStockDAO(Connection connection) {
        if(stockDAO == null){
            synchronized (sync){
                if(stockDAO == null){
                    stockDAO = new MySQLStockDAO(connection);
                }
            }
        }
        return stockDAO;
    }

    public List<Stock> getStocks(){
        return new ArrayList<>();
    }

    public void addStock(String name, int quantity){

    }

    public void removeStock(String name, int quantity){

    }
}
