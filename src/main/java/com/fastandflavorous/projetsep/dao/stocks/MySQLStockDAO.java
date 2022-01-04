package com.fastandflavorous.projetsep.dao.stocks;

import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.stocks.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLStockDAO extends AbstractStockDAO{
    private Connection connection ;

    /**
     * Default constructor
     */
    public MySQLStockDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Stock> getStocks(){
        String query = "SELECT idProduct, name, quantity FROM Menu, Stock WHERE idProduct = idMenu;";
        Stock stock = null;
        List<Stock> stockList = new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                stock = new Stock(rs.getInt("idProduct"), rs.getString("name"), rs.getInt("quantity"));
                stockList.add(stock);
            }
        } catch(SQLException e){
            System.err.println(e);
        }
        return stockList;
    }

    public void addStock(String name, int quantity){

    }

    public void removeStock(String name, int quantity){

    }


}
