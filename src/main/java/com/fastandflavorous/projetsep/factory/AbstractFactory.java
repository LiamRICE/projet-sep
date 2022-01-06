package com.fastandflavorous.projetsep.factory;

import com.fastandflavorous.projetsep.dao.menus.AbstractMenuDAO;
import com.fastandflavorous.projetsep.dao.schedule.AbstractScheduleDAO;
import com.fastandflavorous.projetsep.dao.stocks.AbstractStockDAO;
import com.fastandflavorous.projetsep.dao.users.AbstractUserDAO;

public abstract class AbstractFactory {
    protected AbstractFactory() {
    }

    // static and tools
    private String configDAO = "MySQL";
    private static AbstractFactory factory;
    private static Object sync = new Object();

    public static AbstractFactory getFactory() {
        if(factory == null){
            synchronized (sync){
                if(factory == null){
                    factory = new MySqlFactory();
                }
            }
        }
        return factory;
    }

    public abstract AbstractUserDAO getUserDAO();

    public abstract AbstractMenuDAO getMenuDAO();

    public abstract AbstractStockDAO getStockDAO();

    public abstract AbstractScheduleDAO getScheduleDAO();


}
