package com.fastandflavorous.projetsep.model.schedule;

import com.fastandflavorous.projetsep.model.users.Employee;

import java.util.Date;
import java.util.List;

public class SlotManager {

    private static SlotManager slotManager;

    private List<Slot> slotList;

    private SlotManager(){

    }

    public static SlotManager getSlotManager(){
        if(SlotManager.slotManager == null){
            SlotManager.slotManager = new SlotManager();
        }
        return slotManager;
    }

    public List<Slot> getSlots(){
        return slotList;
    }

    public Slot getSlotById(int idSlot){
        return slotList.stream().filter(slot -> idSlot == slot.getIdSlot()).findAny().orElse(null);
    }

    public Slot getSlotByInfo(String startingTime, String endingTime, Date date){
        return slotList.stream().filter(slot -> slot.getStartingTime().equals(startingTime) && slot.getEndingTime().equals(endingTime) && slot.getDate().equals(date)).findAny().orElse(null);
    }

    public void addSlot(Slot slot){
        slotList.add(slot);
    }

    public void deleteSlot(Slot slot){
        slotList.add(slot);
    }

    public void addEmployeeToSlot(Employee employee,Slot slot){
        slot.addEmployee(employee);
    }

    public void removeEmployeeFomSlot(Employee employee,Slot slot){
        slot.removeEmployee(employee);
    }
}
