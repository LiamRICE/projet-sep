package com.fastandflavorous.projetsep.model.schedule;

import com.fastandflavorous.projetsep.model.users.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Slot {

    private int idSlot;

    private String startingTime;

    private String endingTime;

    private Date date;



    private List<Employee> listOfAssignedEmploye;

    public Slot(int idSlot, String startingTime,String endingTime){
        this.idSlot = idSlot;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        listOfAssignedEmploye = new ArrayList<>();
    }

    public Slot(int idSlot,String startingTime,String endingTime,Date date){
        this(idSlot,startingTime,endingTime);
        this.date = date;
    }

    public Slot(int idSlot,String startingTime,String endingTime,Date date, List<Employee> employees){
        this(idSlot,startingTime,endingTime,date);
        this.listOfAssignedEmploye = employees;
    }

    public boolean isEmpty(){
        return listOfAssignedEmploye.size() == 0;
    }

    public int numberOfAssignedEmployee(){
        return listOfAssignedEmploye.size();
    }

    public void addEmployee(Employee employee){
        listOfAssignedEmploye.add(employee);
    }

    public void removeEmployee(Employee employee){
        listOfAssignedEmploye.remove(employee);
    }

    public int getIdSlot(){
        return idSlot;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public Date getDate() {
        return date;
    }
}
