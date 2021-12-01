package com.fastandflavorous.projetsep.model.users;

import java.util.*;

/**
 * 
 */
public class EmployeeManager {

    private List<Employee> employees;
    private static Object syncronizer = new Object();

    /**
     * Default constructor
     */
    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    /**
     * 
     */
    private static EmployeeManager employeeManager;

    public static EmployeeManager getEmployeeManager(){
        if(EmployeeManager.employeeManager == null){
            synchronized (EmployeeManager.syncronizer){
                if(EmployeeManager.employeeManager == null){
                    EmployeeManager.employeeManager = new EmployeeManager();
                }
            }
        }
        return EmployeeManager.employeeManager;
    }


    /**
     * @param employee
     * @return
     */
    public void addEmployee(Employee employee) {
        if(employee!=null){
            employees.add(employee);
        }
    }

    /**
     * @param employee
     * @return
     */
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    /**
     * @return
     */
    public List<Employee> getAllEmployees() {
        // TODO implement here
        return null;
    }

    /**
     * @param email
     * @param password
     * @return
     */
    public boolean login(String email, String password) {
        // TODO implement here
        return false;
    }

}