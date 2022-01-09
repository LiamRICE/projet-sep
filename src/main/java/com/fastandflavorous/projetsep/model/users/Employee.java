package com.fastandflavorous.projetsep.model.users;

/**
 * 
 */
public class Employee extends User {

    /**
     * Default constructor
     */
    public Employee(String name, String email, String password, float salary, boolean id, boolean ih) {
        super(name);
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.isDirector = id;
        this.setHired(ih);
    }

    /**
     * 
     */
    private int idEmployee;

    private String email;

    private boolean isDirector;

    /**
     * 
     */
    private String password;

    private boolean isHired;

    /**
     * 
     */
    private float salary;

    public int getIdEmployee(){
        return idEmployee;
    }

    /**
     * @return the email of the Employee
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password of the Employee
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the salary of the Employee
     */
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    /**
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDirector(){
        return this.isDirector;
    }

    public void setIsDir(boolean id){
        this.isDirector = id;
    }

    public String toHired(boolean b){
        if(b){
            return "Hired";
        }else{
            return "Fired";
        }
    }

    public String toString(){
        return this.getName() + " : " + this.email + " - " + this.salary + "      | Status = "+ toHired(this.isHired);
    }

    public boolean isHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }
}