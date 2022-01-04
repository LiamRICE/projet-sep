package com.fastandflavorous.projetsep.dao.orders;

import java.sql.Connection;
import java.util.*;

import com.fastandflavorous.projetsep.dao.menus.AbstractMenuDAO;
import com.fastandflavorous.projetsep.dao.menus.MySQLMenuDAO;
import com.fastandflavorous.projetsep.model.orders.*;

public abstract class AbstractOrderDAO {

    /**
     * Default constructor
     */
    public AbstractOrderDAO() {
    }

    /**
     *
     */
    private static AbstractOrderDAO orderDAO;
    private static Object sync = new Object();

    public static AbstractOrderDAO getOrderDAO(Connection connection) {
        if(orderDAO == null){
            synchronized (sync){
                if(orderDAO == null){
                    orderDAO = new MySQLOrderDAO(connection);
                }
            }
        }
        return orderDAO;
    }

}
