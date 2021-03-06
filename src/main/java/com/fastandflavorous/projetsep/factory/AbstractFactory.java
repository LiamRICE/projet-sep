package com.fastandflavorous.projetsep.factory;

import com.fastandflavorous.projetsep.dao.costs.AbstractCostsDAO;
import com.fastandflavorous.projetsep.dao.menus.AbstractMenuDAO;
import com.fastandflavorous.projetsep.dao.orders.AbstractOrderDAO;
import com.fastandflavorous.projetsep.dao.schedule.AbstractScheduleDAO;
import com.fastandflavorous.projetsep.dao.restaurant.AbstractFloorDAO;
import com.fastandflavorous.projetsep.dao.restaurant.AbstractRestaurantDAO;
import com.fastandflavorous.projetsep.dao.restaurant.AbstractRoomDAO;
import com.fastandflavorous.projetsep.dao.restaurant.AbstractTableDAO;
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

    public abstract AbstractOrderDAO getOrderDAO();

    public abstract AbstractCostsDAO getCostsDAO();

    public abstract AbstractStockDAO getStockDAO();

    public abstract AbstractScheduleDAO getScheduleDAO();

    public abstract AbstractRestaurantDAO getRestaurantDAO();

    public abstract AbstractFloorDAO getFloorDAO();

    public abstract AbstractRoomDAO getRoomDAO();

    public abstract AbstractTableDAO getTableDAO();


}
