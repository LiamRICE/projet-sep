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

    /**
     *
     */

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
        return getToken();
    }

    /**
     * @return
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * @return
     */
    public int useLoyaltyPoints() {
        // TODO implement here
        return 0;
    }

}