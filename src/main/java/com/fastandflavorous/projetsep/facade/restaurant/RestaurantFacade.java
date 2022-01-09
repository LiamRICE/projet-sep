package com.fastandflavorous.projetsep.facade.restaurant;

import com.fastandflavorous.projetsep.dao.costs.AbstractCostsDAO;
import com.fastandflavorous.projetsep.dao.restaurant.AbstractFloorDAO;
import com.fastandflavorous.projetsep.dao.restaurant.AbstractRestaurantDAO;
import com.fastandflavorous.projetsep.dao.restaurant.AbstractRoomDAO;
import com.fastandflavorous.projetsep.dao.restaurant.AbstractTableDAO;
import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.costs.CostDashoboard;
import com.fastandflavorous.projetsep.model.restaurant.Floor;
import com.fastandflavorous.projetsep.model.restaurant.Restaurant;
import com.fastandflavorous.projetsep.model.restaurant.Room;
import com.fastandflavorous.projetsep.model.restaurant.Table;

public class RestaurantFacade extends AbstractRestaurantFacade{
    private final AbstractRestaurantDAO restaurantDAO;
    private final AbstractFloorDAO floorDAO;
    private final AbstractRoomDAO roomDAO;
    private final AbstractTableDAO tableDAO;

    public RestaurantFacade() {
        restaurantDAO = AbstractFactory.getFactory().getRestaurantDAO();
        floorDAO = AbstractFactory.getFactory().getFloorDAO();
        roomDAO = AbstractFactory.getFactory().getRoomDAO();
        tableDAO = AbstractFactory.getFactory().getTableDAO();
    }

    @Override
    public void initRestaurant() {
        Restaurant.getRestaurant().setName(restaurantDAO.getRestaurant().getName());
    }

    @Override
    public void setRestaurantName(String name) {
        restaurantDAO.setRestaurantName(name);
        Restaurant.getRestaurant().setName(name);
    }

    @Override
    public void setFloorName(int idFloor, String name) {
        floorDAO.setFloorName(idFloor,name);
        Restaurant.getRestaurant().getFloorById(idFloor).setName(name);
    }

    @Override
    public void setRoomName(int idFloor, int idRoom, String name) {
        roomDAO.setRoomName(idRoom, name);
        Restaurant.getRestaurant().getFloorById(idFloor).getRoomById(idRoom).setName(name);
    }

    @Override
    public void setNumberOfSeats(int idFloor, int idRoom, int idTable, int numberOfSeats) {
        tableDAO.setNumberOfSeats(idTable, numberOfSeats);
        Restaurant.getRestaurant().getFloorById(idFloor).getRoomById(idRoom).getTableById(idTable).setNumberOfSeats(numberOfSeats);
    }

    @Override
    public void addFloorToRestaurant(String floorName) {
        Floor floor = floorDAO.addFloor(floorName);
        Restaurant.getRestaurant().addFloor(floor);
    }

    @Override
    public void addRoomToFloor(int idFloor, String roomName, int squareMeter) {
        Room room = roomDAO.addRoom(idFloor,roomName,squareMeter);
        Restaurant.getRestaurant().getFloorById(idFloor).addRoom(room);
    }

    @Override
    public void addTableToRoom(int idFloor,int idRoom, int idTable, int numberOfSeats) {
        Table table = tableDAO.addTable(idRoom,numberOfSeats);
        Restaurant.getRestaurant().getFloorById(idFloor).getRoomById(idRoom).addTable(table);

    }

    @Override
    public void deleteFloor(int idFloor) {
        floorDAO.removeFloorById(idFloor);
        Restaurant.getRestaurant().deleteFloor(idFloor);

    }

    @Override
    public void deleteRoom(int idFloor,int idRoom) {
        roomDAO.removeRoomById(idRoom);
        Restaurant.getRestaurant().getFloorById(idFloor).deleteRoom(idRoom);

    }

    @Override
    public void deleteTable(int idFloor, int idRoom, int idTable) {
        tableDAO.removeTableById(idTable);
        Restaurant.getRestaurant().getFloorById(idFloor).getRoomById(idRoom).deleteTable(idTable);

    }
}
