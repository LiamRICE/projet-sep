package com.fastandflavorous.projetsep.dao.restaurant;

import com.fastandflavorous.projetsep.model.restaurant.Floor;
import com.fastandflavorous.projetsep.model.restaurant.Room;

import java.util.List;

public abstract class AbstractRoomDAO {

    public abstract void setRoomName(int idRoom, String newName) ;

    public abstract List<Room> getAllRooms();

    public abstract Room getRoomById(int idRoom);

    public abstract Room addRoom(int idFloor, String name, float squareMeter);

    public abstract void removeRoomById(int idRoom);
}
