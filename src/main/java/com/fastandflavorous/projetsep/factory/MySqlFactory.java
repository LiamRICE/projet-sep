package com.fastandflavorous.projetsep.factory;

import com.fastandflavorous.projetsep.dao.costs.AbstractCostsDAO;
import com.fastandflavorous.projetsep.dao.costs.MySQLCostsDAO;
import com.fastandflavorous.projetsep.dao.menus.AbstractMenuDAO;
import com.fastandflavorous.projetsep.dao.menus.MySQLMenuDAO;
import com.fastandflavorous.projetsep.dao.restaurant.*;
import com.fastandflavorous.projetsep.dao.stocks.AbstractStockDAO;
import com.fastandflavorous.projetsep.dao.stocks.MySQLStockDAO;
import com.fastandflavorous.projetsep.dao.users.AbstractUserDAO;
import com.fastandflavorous.projetsep.dao.users.MySQLUserDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlFactory extends AbstractFactory{

    private Connection connection;

    private final String url = "jdbc:mysql://mysql-igstudent74.alwaysdata.net:3306/igstudent74_fastandflavorous";

    private final String user = "250831";

    private final String password = "fastandflavorous";

    public MySqlFactory(){
        super();
        //Establishing connection
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connection Established");

        }catch(Exception e){
            System.err.println(e);
        }
        this.connection = connection;
    }

    public Connection getConnection(){
        return connection;
    }

    public AbstractUserDAO getUserDAO(){
        return new MySQLUserDAO(connection);
    }

    public AbstractMenuDAO getMenuDAO(){
        return new MySQLMenuDAO(connection);
    }

    public AbstractCostsDAO getCostsDAO(){
        return new MySQLCostsDAO(connection);
    }
    public AbstractStockDAO getStockDAO(){
        return new MySQLStockDAO(connection);
    }

    public AbstractRestaurantDAO getRestaurantDAO(){
        return new MySQLRestaurantDAO(connection);
    }
    public AbstractFloorDAO getFloorDAO(){
        return new MySQLFloorDAO(connection);
    }
    public AbstractRoomDAO getRoomDAO(){
        return new MySQLRoomDAO(connection);
    }
    public AbstractTableDAO getTableDAO(){
        return new MySQLTableDAO(connection);
    }
}
