package com.fastandflavorous.projetsep.model.restaurant;

import java.util.List;

public class Floor {

    private int idFloor;
    private String name;

    private List<Room> rooms;

    public Floor(int idFloor, String name){
        this.idFloor = idFloor;
        this.name = name;
    }

    public int getIdFloor() {
        return idFloor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public Room getRoomById(int idRoom){
        return rooms.stream().filter(room -> idRoom == room.getIdRoom()).findAny().orElse(null);
    }

    public void deleteRoom(int idRoom){
        Room roomToRemove = rooms.stream()
                .filter(room -> idRoom == room.getIdRoom()).findAny().orElse(null);

        rooms.remove(roomToRemove);
    }
    
    
}
