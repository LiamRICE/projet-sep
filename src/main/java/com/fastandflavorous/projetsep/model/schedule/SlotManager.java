package com.fastandflavorous.projetsep.model.schedule;

import com.fastandflavorous.projetsep.model.users.Employee;

import java.util.List;

public class SlotManager {

    private static SlotManager slotManager;

    private List<Slot> slotList;

    private SlotManager(){

    }

    public SlotManager getSlotManager(){
        if(SlotManager.slotManager == null){
            SlotManager.slotManager = new SlotManager();
        }
        return slotManager;
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
