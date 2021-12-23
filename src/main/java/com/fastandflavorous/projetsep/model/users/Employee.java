package com.fastandflavorous.projetsep.model.users;

/**
 * 
 */
public class Employee extends User {

    /**
     * Default constructor
     */
    public Employee(String name, String email, String password, float salary) {
        super(name);
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    /**
     * 
     */
    private String email;

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

}