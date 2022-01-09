package com.fastandflavorous.projetsep.facade.restaurant;

import com.fastandflavorous.projetsep.model.restaurant.Restaurant;

public abstract class AbstractRestaurantFacade {

    public abstract void initRestaurant();

    public abstract void setRestaurantName(String name);

    public abstract void setFloorName(int idFloor,String name);

    public abstract void setRoomName(int idFloor,int idRoom, String name);

    public abstract void setNumberOfSeats(int idFloor,int idRoom,int idTable, int numberOfSeats);

    public abstract void addFloorToRestaurant(String floorName);

    public abstract void addRoomToFloor(int idFloor, String roomName, int squareMeter);

    public abstract void addTableToRoom(int idFloor, int idRoom, int idTable,int numberOfSeats);

    public abstract void deleteFloor(int idFloor);

    public abstract void deleteRoom(int idFloor, int idRoom);

    public abstract void deleteTable(int idFloor, int idRoom,int idTable);



}
