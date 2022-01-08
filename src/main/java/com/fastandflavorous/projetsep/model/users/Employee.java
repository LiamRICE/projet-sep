package com.fastandflavorous.projetsep.model.users;

/**
 * 
 */
public class Employee extends User {

    /**
     * Default constructor
     */
    public Employee(String name, String email, String password, float salary, boolean id) {
        super(name);
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.isDirector = id;
    }

    /**
     * 
     */
    private String email;

    private boolean isDirector;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private float salary;

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
        // TODO implement here
    }

    /**
     */
    public void setPassword(String password) {
        // TODO implement here
    }

    /**
     */
    public void setName(String name) {
        // TODO implement here
    }

    public boolean isDirector(){
        return this.isDirector;
    }

    public void setIsDir(boolean id){
        this.isDirector = id;
    }

    public String toString(){
        return this.getName() + " : " + this.email + " - " + this.salary;
    }

}