package com.fastandflavorous.projetsep.dao.schedule;

import com.fastandflavorous.projetsep.model.schedule.Slot;
import com.fastandflavorous.projetsep.model.users.Employee;

import java.util.Date;
import java.util.List;

public abstract class AbstractScheduleDAO {

    public abstract List<Slot> getSlots();

    public abstract List<Employee> getEmployesFromSlot(Slot slot);

    public abstract Slot addSlot(String startingTime, String endingTime, Date date);

    public abstract void addEmployeeToSlot(Slot slot,Employee employee);

    public abstract void deleteSlot(Slot slot);

    public abstract void deleteEmployeeFromSlot(Slot slot,Employee employee);
}
