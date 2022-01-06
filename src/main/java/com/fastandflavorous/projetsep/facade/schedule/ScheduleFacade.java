package com.fastandflavorous.projetsep.facade.schedule;

import com.fastandflavorous.projetsep.dao.schedule.AbstractScheduleDAO;
import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.schedule.Slot;
import com.fastandflavorous.projetsep.model.schedule.SlotManager;
import com.fastandflavorous.projetsep.model.users.Employee;

import java.util.Date;
import java.util.List;

public class ScheduleFacade extends AbstractScheduleFacade{

    private final AbstractScheduleDAO scheduleDAO;

    private final SlotManager slotManager;

    public ScheduleFacade() {
        this.slotManager = SlotManager.getSlotManager();
        this.scheduleDAO =  AbstractFactory.getFactory().getScheduleDAO();
    }

    public List<Slot> getAllSlots(){
        List<Slot> slots = scheduleDAO.getSlots();
        for (Slot slot : slots){
            slotManager.addSlot(slot);
        }
        return slots;
    }


    public void addEmployeeToSlot(String startingTime, String endingTime, Date date, Employee employee){
        Slot slot = null;
        if(slotManager.getSlotByInfo(startingTime,endingTime,date) == null){
            slot = scheduleDAO.addSlot(startingTime,endingTime,date);
            getAllSlots();

        }else {
            slot = slotManager.getSlotByInfo(startingTime,endingTime,date);

        }
        scheduleDAO.addEmployeeToSlot(slot,employee);
    }

}
