package com.fastandflavorous.projetsep.model.restaurant;

import java.util.List;

public class Room {

    private int idRoom;
    private String name;
    private float squareMeter;
    private int idFloor;


    private List<Table> tables;

    public Room(int idRoom,int idFloor,String name, float squareMeter){
        this.idRoom = idRoom;
        this.idFloor = idFloor;
        this.name = name;
        this.squareMeter = squareMeter;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public String getName() {
        return name;
    }

    public int getIdFloor() {
        return idFloor;
    }

    public float getSquareMeter() {
        return squareMeter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSquareMeter(float squareMeter) {
        this.squareMeter = squareMeter;
    }

    public List<Table> getAllTables() {
        return tables;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public Table getTableById(int idTable) {
        return tables.stream().filter(table -> idTable == table.getIdTable()).findAny().orElse(null);
    }

    public void deleteTable(int idTable) {
        Table tableToRemove = tables.stream()
                .filter(table -> idTable == table.getIdTable()).findAny().orElse(null);

        tables.remove(tableToRemove);
    }
}
    
    