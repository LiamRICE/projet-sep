package com.fastandflavorous.projetsep.dao.restaurant;

import com.fastandflavorous.projetsep.model.restaurant.Room;
import com.fastandflavorous.projetsep.model.restaurant.Table;

import java.util.List;

public abstract class AbstractTableDAO {

    public abstract void setNumberOfSeats(int idTable, int newNumberOfSeats);

    public abstract List<Table> getAllTables();

    public abstract Table getTableById(int idTable);

    public abstract Table addTable(int idRoom, int numberOfSeats);

    public abstract void removeTableById(int idTable);

}
