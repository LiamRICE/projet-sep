package com.fastandflavorous.projetsep.dao.restaurant;

import com.fastandflavorous.projetsep.model.restaurant.Floor;

import java.util.List;

public abstract class AbstractFloorDAO {

    public abstract void setFloorName(int idFloor, String newName);

    public abstract List<Floor> getAllFloors();

    public abstract Floor getFloorById(int idFloor);

    public abstract Floor addFloor(String name);

    public abstract void removeFloorById(int idFloor);
}
