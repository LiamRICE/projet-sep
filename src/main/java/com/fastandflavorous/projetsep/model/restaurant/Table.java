package com.fastandflavorous.projetsep.model.restaurant;

import java.util.List;

public class Table {

    private int idTable;

    private int idRoom;

    private int numberOfSeats;

    public Table(int idTable, int idRoom, int numberOfSeats) {
        this.idTable = idTable;
        this.idRoom = idRoom;
        this.numberOfSeats = numberOfSeats;
    }

    public int getIdTable() {
        return idTable;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}