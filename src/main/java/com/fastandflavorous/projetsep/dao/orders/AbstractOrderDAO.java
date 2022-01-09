package com.fastandflavorous.projetsep.dao.orders;

import java.sql.Connection;
import java.util.*;

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

    /**
     * @return
     */
    public List<Order> getOrders() {
        return null;
    }

    /**
     * @return
     */
    public Order getOrder(int id){return null;}

    /**
     * @param order
     * @return
     */
    public void addOrder(Order order) {
        System.out.println("Adding a new order : "+order.toString());
    }

    /**
     * @param order
     * @return
     */
    public void editOrder(Order order) {}

    /**
     * @param order
     * @return
     */
    public void deleteOrder(Order order) {
        System.out.println("Deleting order : "+order.toString());
    }





}
