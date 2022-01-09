package com.fastandflavorous.projetsep.model.restaurant;

import com.fastandflavorous.projetsep.model.costs.Cost;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static Restaurant restaurant;
    private String name;
    private List<Floor> floors;

    public Restaurant() {
        floors = new ArrayList<>();
    }

    public static Restaurant getRestaurant(){
        if(restaurant == null){
            restaurant = new Restaurant();
        }
        return restaurant;
    }

    public void setName(String name){
        restaurant.name = name;
    }

    public String getName() {
        return name;
    }

    public void addFloor(Floor floor){
        floors.add(floor);
    }

    public Floor getFloorById(int idFloor){
        return floors.stream().filter(floor -> idFloor == floor.getIdFloor()).findAny().orElse(null);
    }

    public void deleteFloor(int idFloor){
        Floor floorToRemove = floors.stream()
                .filter(floor -> idFloor == floor.getIdFloor())
                .findAny()
                .orElse(null);

        floors.remove(floorToRemove);
    }

    public List<Floor> getAllFloor(){
        return floors;
    }

}
