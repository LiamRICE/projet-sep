package com.fastandflavorous.projetsep.model.schedule;

import com.fastandflavorous.projetsep.model.users.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Slot {

    private String startingTime;

    private String endingTime;

    private Date date;

    private List<Employee> listOfAssignedEmploye;

    public Slot(String startingTime,String endingTime){
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        listOfAssignedEmploye = new ArrayList<>();
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
}
