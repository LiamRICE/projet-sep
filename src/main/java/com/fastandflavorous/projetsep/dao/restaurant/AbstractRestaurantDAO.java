package com.fastandflavorous.projetsep.dao.restaurant;

import com.fastandflavorous.projetsep.model.restaurant.Restaurant;

import java.sql.Connection;

public abstract class AbstractRestaurantDAO {


    public AbstractRestaurantDAO(){

    }
    public abstract Restaurant getRestaurant();
    public abstract void setRestaurantName(String newName);
}
