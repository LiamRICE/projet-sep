package com.fastandflavorous.projetsep.model.users;

/**
 * 
 */
public class Employee extends User {

    /**
     * Default constructor
     */
    public Employee(String name, String email, String password, float salary) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    /**
     *
     */
    private String name;

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
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return
     */
    public float getSalary() {
        return salary;
    }

    /**
     * @return
     */
    public void setEmail(String email) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void setPassword(String password) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void setName(String name) {
        // TODO implement here
    }

}