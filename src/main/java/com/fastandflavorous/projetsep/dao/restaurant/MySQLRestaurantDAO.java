package com.fastandflavorous.projetsep.dao.restaurant;

import com.fastandflavorous.projetsep.model.restaurant.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLRestaurantDAO extends AbstractRestaurantDAO{
    private Connection connection;
    public MySQLRestaurantDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Restaurant getRestaurant() {
        String query = "SELECT * FROM Restaurant;";
        Restaurant restaurant = Restaurant.getRestaurant();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                restaurant.setName(rs.getString("name"));
            }

        } catch(SQLException e){
            System.err.println(e);
        }
        return restaurant;
    }

    @Override
    public void setRestaurantName(String newName) {
        String update = "UPDATE Restaurant SET name = '"+newName+"' WHERE name='"+Restaurant.getRestaurant().getName()+"'";
        try{
            PreparedStatement ps=connection.prepareStatement(update);
            ps.executeUpdate();

        } catch(SQLException e){
            System.err.println(e);
        }

    }
}
