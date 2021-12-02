package com.fastandflavorous.projetsep.model.users;

/**
 * 
 */
public class Client extends User {

    /**
     * Default constructor
     */
    public Client(String name, String token, int loyaltyPoints) {
        this.name = name;
        this.token = token;
        this.loyaltyPoints = loyaltyPoints;
    }

    private String name;

    /**
     * 
     */
    private String token;

    /**
     * 
     */
    private int loyaltyPoints;

    /**
     * @return
     */
    public String getToken() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public int getLoyaltyPoints() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int useLoyaltyPoints() {
        // TODO implement here
        return 0;
    }

}