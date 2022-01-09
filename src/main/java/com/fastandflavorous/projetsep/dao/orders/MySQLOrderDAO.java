package com.fastandflavorous.projetsep.dao.orders;

import com.fastandflavorous.projetsep.model.orders.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLOrderDAO extends AbstractOrderDAO {

    private Connection connection;

    /**
     * Default constructor
     */
    public MySQLOrderDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Order> getOrders() {
        String query = "SELECT * FROM Order;";
        Order order = null;
        List<Order> orderList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getInt("idOrder"), true, true, true, Double.parseDouble(rs.getString("price")));
                orderList.add(order);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return orderList;
    }

    @Override
    public Order getOrder(int id) {
        String query = "SELECT * FROM Order WHERE Order.idOrder = id;";
        Order order = null;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            order = new Order(rs.getInt("idOrder"), true, true, true, Double.parseDouble(rs.getString("price")));
        } catch (SQLException e) {
            System.err.println(e);
        }
        return order;
    }


    @Override
    public void addOrder(Order order) {
        String query = "INSERT INTO Order VALUES (" + getMaxId() + ",'" + order.isPaid() + "','" + order.isFullfilled() + "'," + order.getPrice() + ");";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void editOrder(Order order) {
        deleteOrder(order);
        addOrder(order);
    }

    /**
     * @param order
     * @return
     */
    public void deleteOrder(Order order) {
        System.out.println("Deleting ordeer : " + order.toString());
        String query = "DELETE FROM Order WHERE id='" + order.getId() + "';";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private int getMaxId(){
        String query = "SELECT idOrder FROM Order;";
        List<Integer> orderList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orderList.add(rs.getInt("idOrder"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        int max = 0;
        for(Integer x : orderList){
            if(x>max){
                max = x;
            }
        }
        return max+1;
    }
}
